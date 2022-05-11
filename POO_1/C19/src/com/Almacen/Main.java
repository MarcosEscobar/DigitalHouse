package com.Almacen;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProductoFactory fabricaProductos = ProductoFactory.getInstance();

        List<Producto> productos = new ArrayList<Producto>();

        Producto producto1 = fabricaProductos.generarProducto(ProductoFactory.CODIGO_PELOTAFUTBOL);
        Producto producto2 = fabricaProductos.generarProducto(ProductoFactory.CODIGO_PELOTATENIS);
        Producto producto3 = fabricaProductos.generarProducto(ProductoFactory.CODIGO_CAJA10X10);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        Almacen almacen = new Almacen(productos);

        System.out.println(almacen.calcularEspacioNecesario());

    }
}
