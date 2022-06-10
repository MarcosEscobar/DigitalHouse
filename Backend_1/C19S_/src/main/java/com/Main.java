package com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Contacto contacto1 = new Contacto("Pepe", "Pepardo", "pepe@gmail.com", "1122223333");
        Contacto contacto2 = new Contacto("Pepa", "Peparda", "pepa@gmail.com", "1144445555");

        List<Contacto> contactosAGuardar = new ArrayList<>();
        contactosAGuardar.add(contacto1);
        contactosAGuardar.add(contacto2);

        try {
            ManejoDeArchivos.guardar(contactosAGuardar);
        } catch (IOException e) {
            System.out.println("ERROR: ".concat(e.getMessage()));
        }

        List<Contacto> contactosGuardados = new ArrayList<>();

        try {
            contactosGuardados = (ArrayList) ManejoDeArchivos.leer();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: ".concat(e.getMessage()));
        }

        System.out.println("\nContactos obtenidos del archivo");
        for (Contacto c : contactosGuardados) {
            System.out.println(c.toString());
        }
    }
}
