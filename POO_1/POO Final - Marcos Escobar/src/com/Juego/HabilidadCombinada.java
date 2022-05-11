package com.Juego;
import java.util.*;

public class HabilidadCombinada extends Habilidad {
    //ATTRIBUTES
    private final Integer factorMultiplicador;
    private final List<Habilidad> habilidades;

    public HabilidadCombinada(String nombre, String descripcion, Integer factorMultiplicador) {
        super(nombre, descripcion);
        this.factorMultiplicador = factorMultiplicador;
        this.habilidades = new ArrayList<>();
    }
    public void agregarHabilidad(Habilidad habilidad){
        this.habilidades.add(habilidad);
    }
    @Override
    Double calcularPuntaje() {
        double totalPuntos = 0d;
        for (Habilidad habilidad : this.habilidades) {
            totalPuntos += habilidad.calcularPuntaje();
        }
        return totalPuntos * factorMultiplicador;
    }
    @Override
    public String toString() {
        return String.format("{ nombre: %s, puntos: %s}%n| Habilidades: %s",
                this.getNombre(), this.calcularPuntaje(),this.habilidades);
    }
}

