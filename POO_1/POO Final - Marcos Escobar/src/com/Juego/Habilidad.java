package com.Juego;

public abstract class Habilidad {
    //ATTRIBUTES
    private final String nombre;
    private final String descripcion;
    //CONSTRUCTOR
    public Habilidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    abstract Double calcularPuntaje();

    @Override
    public abstract String toString();
}


