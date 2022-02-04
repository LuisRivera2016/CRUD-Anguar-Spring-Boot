package com.example.curso.util;

import com.example.curso.DTO.GatoDTO;
import com.example.curso.DTO.PersonaDTO;
import com.example.curso.domain.Gato;
import com.example.curso.domain.Persona;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("converEntitytoDTO")
public class ConvertEntitytoDTO {

    @Autowired
    private ModelMapper modelMapper;

    public PersonaDTO convertToPersona(Persona persona){
        PersonaDTO personaDTO = null;

        if(persona != null){
            personaDTO = modelMapper.map(persona, PersonaDTO.class);
        }
        return  personaDTO;
    }

    public GatoDTO convertToGato(Gato gato){
        GatoDTO GatoDTO = null;

        if(gato != null){
            GatoDTO = modelMapper.map(gato, GatoDTO.class);
        }
        return  GatoDTO;
    }
}
