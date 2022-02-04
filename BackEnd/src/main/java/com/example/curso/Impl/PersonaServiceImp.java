package com.example.curso.Impl;

import com.example.curso.DTO.PersonaDTO;
import com.example.curso.Exceptions.NotFoundException;
import com.example.curso.domain.Persona;
import com.example.curso.service.PersonaService;
import com.example.curso.util.ConvertEntitytoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.curso.Repository.PersonaRepository;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;

@Service
public class PersonaServiceImp implements PersonaService {



    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ConvertEntitytoDTO convertEntitytoDTO;

    @Override
    public List<PersonaDTO> listaPersona() {
        List<PersonaDTO> listaDTO = null;
        List<Persona> listaEntidad = personaRepository.findAll();
        listaDTO = listaEntidad.stream().map(param-> convertEntitytoDTO.convertToPersona(param)).collect(Collectors.toList());
        return listaDTO;
    }

    @Override
    public String guardar(PersonaDTO personaDTO) {

        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setEmail(personaDTO.getEmail());
        personaRepository.save(persona);
        return "Se inserto";
    }

    @Override
    @Transactional
    public String eliminar(Long idPersona){
        Long existe = personaRepository.validaExistePersona(idPersona);
            if (existe == 0){
            System.out.println("No existe");
            return "No existe";
        }else{
            personaRepository.deleteById(idPersona);
            return "Eliminado";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaDTO encontrarPersona(Long idPersona) {
        Persona persona = personaRepository.getById(idPersona);
        if(persona != null){
           return convertEntitytoDTO.convertToPersona(persona);
        }else{
            throw new NotFoundException("No existe la persona");
        }

    }


    @Override
    @Transactional
    public String actualizarPersona(PersonaDTO personaDTO,Long idPersona){
        Long existe = personaRepository.validaExistePersona(idPersona);
        if (existe == 0){
            System.out.println("No existe");
            return "No existe";
        }else{
           Persona persona = new Persona();
           BeanUtils.copyProperties(personaDTO,persona);
//           persona.setIdPersona(personaDTO.getIdPersona());
//           persona.setNombre(personaDTO.getNombre());
//           persona.setApellido(personaDTO.getApellido());
//           persona.setEmail(personaDTO.getEmail());
//           persona.setTelefono(personaDTO.getTelefono());
           personaRepository.save(persona);
            return "Actualizado";
        }
    }



}
