package model;

import svc.imp.arbolFactory;

import java.util.ArrayList;

public class Bosque {

    private final long tamano;
    private String nombre;
    private ArrayList<arbol> bosque=new ArrayList<>();

    public long getTamano() {
        return tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bosque(String nombre, long tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }


    public void agregarArbol(arbol a) {
        bosque.add(a);
    }

    public int getSize(){
        return bosque.size();
    }
}
