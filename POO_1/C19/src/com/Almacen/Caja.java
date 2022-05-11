package com.Almacen;

public class Caja extends Producto{

    private Double longitud;
    private Double ancho;
    private Double altura;

    public Caja(Double peso, Double longitud, Double ancho, Double altura) {
        super(peso);
        this.longitud = longitud;
        this.ancho = ancho;
        this.altura = altura;
    }

    @Override
    public Double calcularEspacio(){
        return this.longitud*this.ancho*this.altura;
    }
}
