package com.dh.animales;

public class GeneradorDeSentenciasAnimales {

    private final static String tabla = "animales";

    public static String generarInsert(){
        return "INSERT INTO " + tabla + "(tipo, nombre) VALUES (?, ?)";
    }

    public static String generarInsertConId(){
        return "INSERT INTO " + tabla + "(id, tipo, nombre) VALUES (?, ?, ?)";
    }

    public static String generarSelectAll(){
        return "SELECT * FROM " + tabla;
    }

    public static String generarSelectPorId(){
        return "SELECT * FROM " + tabla + " WHERE id = ?";
    }

    public static String generarDelete(){
        return "DELETE FROM " + tabla + " WHERE id = ?";
    }
}