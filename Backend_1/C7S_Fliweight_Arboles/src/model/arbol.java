package model;

import svc.IArbol;

public class arbol implements IArbol {
    private int alto;
    private int horizontal;
    private String color;
    private String tipo;

    public arbol(int alto, int horizontal, String color, String tipo) {
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
        this.tipo = tipo;
    }

    public int getAlto() {
        return alto;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void obtenerArbol(String color) {
        System.out.println("Arbol plantado del tipo "+this.tipo+" de color "+color+". El mismo ya existía en el hashmap");
    }
}
