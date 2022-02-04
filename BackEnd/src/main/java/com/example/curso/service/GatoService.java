package com.example.curso.service;

import com.example.curso.DTO.GatoDTO;
import com.example.curso.DTO.PersonaDTO;
import com.example.curso.domain.Gato;
import com.example.curso.domain.Persona;

import java.util.List;

public interface GatoService {
    public List<GatoDTO> listaGato();
    public String guardar(GatoDTO gatoDTO);
    public String eliminar(Long idGato);
    public GatoDTO obtenerGato(Long idGato);
    public String actualizarGato(GatoDTO gatoDTO,Long idGato);

}
