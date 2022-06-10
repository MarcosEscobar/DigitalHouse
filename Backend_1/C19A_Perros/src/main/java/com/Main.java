package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Perro perro1 = new Perro("Pepe", 2);
        Perro perro2 = new Perro("Pepa", 5);
        Perro perro3 = new Perro("Firulais", 7);

        List<Perro> perrosAGuardar = new ArrayList<>();
        perrosAGuardar.add(perro1);
        perrosAGuardar.add(perro2);
        perrosAGuardar.add(perro3);

        try {
            ManejoDeArchivos.guardar(perrosAGuardar);
        } catch (IOException e) {
            System.out.println("ERROR: ".concat(e.getMessage()));
        }

        List<Perro> perrosGuardados = new ArrayList<>();

        try {
            perrosGuardados = (ArrayList) ManejoDeArchivos.leer();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: ".concat(e.getMessage()));
        }

        System.out.println("\nPerros obtenidos del archivo");
        for (Perro c : perrosGuardados) {
            System.out.println(c.toString());
        }
    }
}
