package com.Juego;

public class HabilidadFactory {
    //ATTRIBUTES
    public final static String HS_SALTAR = "saltar";
    public final static String HS_DISPARAR = "disparar";
    public final static String HC_DISPARO_AL_SALTAR = "disparo-al-saltar";

    private static HabilidadFactory instance;

    private HabilidadFactory() {

    }

    public static HabilidadFactory getInstance() {
        if (instance == null)
            instance = new HabilidadFactory();
        return instance;
    }

    public Habilidad generarHabilidad(String tipoHabilidad) throws HabilidadFactoryException {
        switch (tipoHabilidad) {
            case HS_DISPARAR:
                return new HabilidadSimple("Disparar", "some", 10d);
            case HS_SALTAR:
                return new HabilidadSimple("Saltar", "some", 7.5);
            case HC_DISPARO_AL_SALTAR:
                HabilidadCombinada habilidadCombinada =
                        new HabilidadCombinada
                                ("Disparo al Saltar", "some", 3);
                habilidadCombinada.agregarHabilidad(generarHabilidad(HS_SALTAR));
                habilidadCombinada.agregarHabilidad(generarHabilidad(HS_DISPARAR));
                return habilidadCombinada;
            default:
                throw new HabilidadFactoryException("¡Codigo Invalido!");

        }
    }
}