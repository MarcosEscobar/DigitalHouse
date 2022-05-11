package com.Almacen;

public class ProductoFactory {

    private static ProductoFactory instance;
    public static final String CODIGO_CAJA10X10 = "CAJA10X10";
    public static final String CODIGO_PELOTAFUTBOL = "PELOTAFUTBOL";
    public static final String CODIGO_PELOTATENIS = "PELOTATENIS";

    private ProductoFactory(){}

    public static ProductoFactory getInstance() {
        if (instance == null)
            return new ProductoFactory();
        else
            return instance;
    }

    public Producto generarProducto(String codigo) {
        switch (codigo) {
            case CODIGO_CAJA10X10:
                return new Caja(0.5, 10.0, 10.0, 10.0);
            case CODIGO_PELOTAFUTBOL:
                return new Pelota(0.5, 11.0);
            case CODIGO_PELOTATENIS:
                return new Pelota(0.5, 0.32);
            default:
                return null;
        }


    }
}
