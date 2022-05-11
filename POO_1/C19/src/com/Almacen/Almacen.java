package com.Almacen;

import java.util.ArrayList;
import java.util.List;

public class Almacen {

    private List<Producto> listaProductos = new ArrayList<Producto>();

    public Almacen(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Double calcularEspacioNecesario(){

        Double espacioNecesario = 0.0;

        for (Producto producto : this.listaProductos){
            espacioNecesario += producto.calcularEspacio();
        }

        return espacioNecesario;
    }
}
