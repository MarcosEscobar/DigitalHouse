package com.dh.animales.entidades;

import java.util.Objects;

public class Animal {

    private Integer id;
    private String nombre;
    private String tipo;

    public Animal(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Animal(Integer id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id.equals(animal.id) && nombre.equals(animal.nombre) && tipo.equals(animal.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipo);
    }

    @Override
    public String toString() {
        return "Animal" +
                "\n\tID: " + id +
                "\n\tNombre: '" + nombre + "'" +
                "\n\tTipo: '" + tipo + "'";
    }
}
