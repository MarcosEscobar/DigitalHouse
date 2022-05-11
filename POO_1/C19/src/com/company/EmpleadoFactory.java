package com.company;

public class EmpleadoFactory {

    private static EmpleadoFactory instance;

    public static final String CODIGO_EMPLEADO_RD1 = "EXT-INT";



    private EmpleadoFactory(){

    }

    public static EmpleadoFactory getInstance(){
        if(instance == null){
            instance = new EmpleadoFactory();
        }
        return instance;
    }

    public Empleado generarEmpleado(String codigo){
        switch (codigo){
            case CODIGO_EMPLEADO_RD1:
                return new EmpleadoRelacionDependencia(1000.0);
            case "EMP-EXT":
                return new EmpleadoContratado(7.0, 14.0);
            default:
                return null;
        }
    }

}
