package com.dh;

import com.dh.animales.dao.ConfiguracionJDBC;
import com.dh.animales.dao.impl.DaoH2Animal;
import com.dh.animales.entidades.Animal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            DaoH2Animal daoH2Animal = new DaoH2Animal(new ConfiguracionJDBC());
            Animal pompilia = new Animal(1, "Pompilia", "Perro");
            Animal martin = new Animal(2, "Martin", "Perro");
            Animal peggy = new Animal(3, "Peggy", "Gato");
            Animal jazmin = new Animal(4, "Jazmin", "Gato");

            daoH2Animal.insertarNuevo(pompilia);
            daoH2Animal.insertarNuevo(martin);
            daoH2Animal.insertarNuevo(peggy);
            daoH2Animal.insertarNuevo(jazmin);

            System.out.println("\nConsultando por ID=2");
            System.out.println(daoH2Animal.consultarPorId(new Animal(2, null, null)).toString());

            System.out.println("\nConsultando por todos");
            List<Animal> animales = daoH2Animal.consultarTodos();
            for (Animal animal : animales) {
                System.out.println(animal.toString());
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
