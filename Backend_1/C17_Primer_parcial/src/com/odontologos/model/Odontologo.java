package com.odontologos.model;

public class Odontologo {
    //Atributos de odontólogo
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    //Constructor vacío
    public Odontologo(){}

    //Constructor con campos
    public Odontologo(Long id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return  "\nOdontologo:" +
                "\nId: " + id +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido+
                "\nMatricula: " + matricula;
    }
}

