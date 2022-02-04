package com.example.curso.service;

import com.example.curso.DTO.PersonaDTO;
import com.example.curso.domain.Persona;

import java.util.List;

public interface PersonaService {
    public List<PersonaDTO> listaPersona();
    public String guardar(PersonaDTO personaDTO);
    public String eliminar(Long idPersona);
    public PersonaDTO encontrarPersona(Long idPersona);
    public String actualizarPersona(PersonaDTO personaDTO,Long idPersona);
}
