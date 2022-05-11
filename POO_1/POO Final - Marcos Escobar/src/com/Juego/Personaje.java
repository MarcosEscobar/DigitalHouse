package com.Juego;
import java.util.ArrayList;
import java.util.List;

public class Personaje {

    private final String nombre;
    private final List<Habilidad> habilidades;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.habilidades = new ArrayList<>();
    }

    public void mostrarHabilidades(){
        System.out.printf("Mi nombre es %s, y puedo hacer:%n", this.nombre);
        for (Habilidad habilidad : this.habilidades) {
            System.out.printf("%s => %s %n",
                    habilidad.getClass().getSimpleName(), habilidad);
        }
    }

    public void agregarHabilidad(String tipoHabilidad){
        try {
            this.habilidades.add(HabilidadFactory.getInstance().generarHabilidad(tipoHabilidad));
        } catch (HabilidadFactoryException e) {
            e.printStackTrace();
        }
    }
}