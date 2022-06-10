package com;

import com.empresa.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejoDeArchivosManual {
    static String nombreArchivo = "outputManual.txt";

    public static void guardar(List<Empleado> empleados) throws IOException {
        if (nombreArchivo != null) {
            Writer fileWriter = new FileWriter(nombreArchivo);
            for(Empleado e : empleados) {
                fileWriter.write(e.toString());
            }
            fileWriter.close();
        }
    }

    public static List<Empleado> leer() throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        if (nombreArchivo != null) {
            Reader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = bufferedReader.readLine();
            while(linea != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                String apellido = datos[1];
                String legajo = datos[2];
                Double sueldo = Double.parseDouble(datos[3]);
                empleados.add(new Empleado(nombre, apellido, legajo, sueldo));
                linea = bufferedReader.readLine();
            }
            fileReader.close();
        }
        return empleados;
    }
}
