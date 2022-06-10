package com;

import java.io.Serializable;

public class Perro implements Serializable {

    private String nombre;
    private Integer edad;

    public Perro(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "\n\tnombre='" + nombre + '\'' +
                "\n\tedad=" + edad +
                "\n}";
    }
}
