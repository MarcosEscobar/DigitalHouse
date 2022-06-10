package com;

import com.empresa.Empleado;
import com.empresa.Empresa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("20-111222333-0", "Les Pepes");
        empresa.agregarEmpleado(new Empleado("Pepe", "Pepardo", "111", 80000.0));
        empresa.agregarEmpleado(new Empleado("Pepa", "Peparda", "222", 80000.0));
        empresa.agregarEmpleado(new Empleado("Pepo", "Peposo", "333", 80000.0));
        empresa.agregarEmpleado(new Empleado("Pipo", "Pipardo", "444", 80000.0));

        manejoConStreams(empresa);
        manejoManual(empresa);
    }

    public static void manejoConStreams(Empresa empresa) {
        try {
            ManejoDeArchivos.guardar(empresa.getEmpleados());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Empleado> empleadosPersistidos = new ArrayList<>();
        try {
            empleadosPersistidos = (ArrayList) ManejoDeArchivos.leer();

            for (Empleado e : empleadosPersistidos) {
                e.mostrarDatos();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void manejoManual(Empresa empresa) {
        try {
            ManejoDeArchivosManual.guardar(empresa.getEmpleados());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Empleado> empleadosPersistidos = new ArrayList<>();
        try {
            empleadosPersistidos = ManejoDeArchivosManual.leer();

            for (Empleado e : empleadosPersistidos) {
                e.mostrarDatos();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
