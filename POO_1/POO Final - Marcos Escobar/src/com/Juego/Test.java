package com.Juego;

public class Test {
    public static void main(String[] args) {
        Personaje personaje = new Personaje("DiegoHap");
        personaje.agregarHabilidad(HabilidadFactory.HS_SALTAR);
        personaje.agregarHabilidad(HabilidadFactory.HS_DISPARAR);
        personaje.agregarHabilidad(HabilidadFactory.HC_DISPARO_AL_SALTAR);
        personaje.agregarHabilidad("Conducir");
        personaje.mostrarHabilidades();

    }
}
