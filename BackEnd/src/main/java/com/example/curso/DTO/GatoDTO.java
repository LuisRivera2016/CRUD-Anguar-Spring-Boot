package com.example.curso.DTO;

import com.example.curso.domain.Persona;

import java.io.Serializable;

public class GatoDTO implements Serializable {
    private static final long serialVersionUID = 4L;

    private Long idGato;
    private String nombre;
    private String raza;
    private Persona persona;

    public Long getIdGato() {
        return idGato;
    }

    public void setIdGato(Long idGato) {
        this.idGato = idGato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
