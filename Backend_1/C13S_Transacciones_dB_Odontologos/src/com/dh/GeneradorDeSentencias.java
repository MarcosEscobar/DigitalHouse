package com.dh;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GeneradorDeSentencias {

    private final static String tabla = "odontologos";

    public static String generarInsert(){
        return "INSERT INTO " + tabla + "(nombre, apellido, matricula) VALUES (?, ?, ?)";
    }

    public static String generarSelectAll(){
        return "SELECT * FROM " + tabla;
    }

    public static String generarSelectPorMatricula(){
        return "SELECT * FROM " + tabla + " WHERE matricula = ?";
    }

    public static String generarDeletePorMatricula(){
        return "DELETE FROM " + tabla + " WHERE matricula = ?";
    }

    public static String crearTabla(Map<String, String> columnas){
        String sentencia =  "DROP TABLE IF EXISTS " + tabla + "; CREATE TABLE " + tabla + " (";

        Set<String> nombresDeLasColumnas = columnas.keySet();
        Iterator<String> iterador = nombresDeLasColumnas.iterator();

        while (iterador.hasNext()){
            String nombreDeLaColumna = iterador.next();
            sentencia = sentencia + nombreDeLaColumna + " " + columnas.get(nombreDeLaColumna);
            if(iterador.hasNext()){
                sentencia = sentencia + ", ";
            }
        }

        sentencia = sentencia + ")";

        return sentencia;
    }
}
