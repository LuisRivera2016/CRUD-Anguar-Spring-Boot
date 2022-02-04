package com.example.curso.Impl;

import com.example.curso.DTO.GatoDTO;
import com.example.curso.DTO.PersonaDTO;
import com.example.curso.Exceptions.NotFoundException;
import com.example.curso.Repository.GatoRepository;
import com.example.curso.domain.Gato;
import com.example.curso.domain.Persona;
import com.example.curso.service.GatoService;
import com.example.curso.util.ConvertEntitytoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;


@Service
public class GatoServiceImp implements GatoService {

    @Autowired
    private GatoRepository gatoRepository;

    @Autowired
    private ConvertEntitytoDTO convertEntitytoDTO;

    @Override
    public List<GatoDTO> listaGato() {
        List<GatoDTO> listaDTO = null;
        List<Gato> listaEntidad = gatoRepository.findAll();
        listaDTO = listaEntidad.stream().map(param-> convertEntitytoDTO.convertToGato(param)).collect(Collectors.toList());
        return listaDTO;
    }

    @Override
    public String guardar(GatoDTO gatoDTO) {
        Gato gato = new Gato();
        gato.setNombre(gatoDTO.getNombre());
        gato.setRaza(gatoDTO.getRaza());
        gato.setPersona(gatoDTO.getPersona());
        gatoRepository.save(gato);
        return "Se inserto";
    }

    @Override
    public String eliminar(Long idGato) {
        Long existe = gatoRepository.validaExisteGato(idGato);
        if (existe == 0){
            System.out.println("No existe");
            return "No existe";
        }else{
            gatoRepository.deleteById(idGato);
            return "Eliminado";
        }
    }


    @Override
    public GatoDTO obtenerGato(Long idGato) {
        Long existe = gatoRepository.validaExisteGato(idGato);
        if(existe == 0){
            System.out.println("No existe");
            throw new NotFoundException("No existe el Gato");
        }else{
            return convertEntitytoDTO.convertToGato(gatoRepository.obtenerGato(idGato));
        }

    }

    @Override
    public String actualizarGato(GatoDTO gatoDTO, Long idGato) {
        Long existe = gatoRepository.validaExisteGato(idGato);
        if(existe == 0){
            System.out.println("No existe");
            return "No existe el Gato";
        }else{
            Gato gato = new Gato();
            BeanUtils.copyProperties(gatoDTO,gato);
            gatoRepository.save(gato);
            return "Gato Actualizado";
        }

    }


}
