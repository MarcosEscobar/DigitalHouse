package com;

import java.io.*;
import java.util.List;

public class ManejoDeArchivos {

    static String nombreArchivo = "output.txt";

    public static void guardar(List datos) throws IOException {
        if (nombreArchivo != null) {
            //     * ------------------> *
            //    App                 salida.txt
            // defino el flujo, hacia donde va a ir el dato
            OutputStream outputStream = new FileOutputStream(nombreArchivo);
            // Objeto ------  → 0110101...
            //             ↓ |
            //              * ------------------> * ------------------> *
            //             App             FileOutputStream          salida.txt
            // creo el flujo
            ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(datos);
        }
    }

    public static List leer() throws IOException, ClassNotFoundException {
        List datos = null;
        if (nombreArchivo != null) {
            InputStream inputStream = new FileInputStream(nombreArchivo);
            ObjectInputStream objectInput = new ObjectInputStream(inputStream);
            datos = (List) objectInput.readObject();
        }
        return datos;
    }
}
