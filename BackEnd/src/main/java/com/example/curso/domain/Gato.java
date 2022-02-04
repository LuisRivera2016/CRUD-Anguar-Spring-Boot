package com.example.curso.domain;

import javax.persistence.*;


@Entity
@Table(name = "Gato")
public class Gato {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGato")
    private Long idGato;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "raza")
    private String raza;
    @ManyToOne
    @JoinColumn(name = "Persona")
    private  Persona persona;

    public Gato() {
    }

    public Gato(Long idGato, String nombre, String raza, Persona persona) {
        this.idGato = idGato;
        this.nombre = nombre;
        this.raza = raza;
        this.persona = persona;
    }

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
