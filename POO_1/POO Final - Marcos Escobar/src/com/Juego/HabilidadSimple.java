package com.Juego;

public class HabilidadSimple extends Habilidad {
    //ATTRIBUTES
    private final Double puntaje;

    public HabilidadSimple(String nombre, String descripcion, Double puntaje) {
        super(nombre, descripcion);
        this.puntaje = puntaje;
    }

    @Override
    Double calcularPuntaje() {
        double puntajeTotal = this.puntaje;
        if (this.getNombre().equals("Disparar"))
            puntajeTotal *= this.puntaje / 100 + 1;
        return puntajeTotal;
    }
    
    public String toString() {
        return String.format("{ nombre: %s, puntaje: %s }",
                this.getNombre(), this.calcularPuntaje());
    }
}