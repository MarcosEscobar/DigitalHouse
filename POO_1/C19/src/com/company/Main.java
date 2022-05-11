package com.company;

public class Main {
    public static void main(String[] args) {

        EmpleadoFactory unEmpleadoFactory = EmpleadoFactory.getInstance();
        EmpleadoFactory otroEmpleadoFactory = EmpleadoFactory.getInstance();

        System.out.println(unEmpleadoFactory.equals(otroEmpleadoFactory));

        Empleado empleado = unEmpleadoFactory.generarEmpleado(EmpleadoFactory.CODIGO_EMPLEADO_RD1);
        System.out.println(empleado.toString());

    }
}