package com.company;

public class EmpleadoContratado extends Empleado {

    private Double importePorHora;
    private Double retencionImpuestos;

    public EmpleadoContratado(){

    }

    public EmpleadoContratado(String nombre, String apellido, Integer legajo, Double importePorHora, Double retencionImpuestos) {
        super(nombre, apellido, legajo);
        this.importePorHora = importePorHora;
        this.retencionImpuestos = retencionImpuestos;
    }

    public EmpleadoContratado(Double importePorHora, Double retencionImpuestos) {
        this.importePorHora = importePorHora;
        this.retencionImpuestos = retencionImpuestos;
    }

    @Override
    public Double calcularSueldo(Integer dias){
        return null;
    }

    @Override
    public String toString() {
        return "EmpleadoContratado{" +
                "importePorHora=" + importePorHora +
                ", retencionImpuestos=" + retencionImpuestos +
                '}';
    }
}
