package com.dh.grupo7.pacientesMVCSpring.domain;

import java.time.LocalDate;

public class Paciente {
    private Long id;
    private Long id_odontologo;
    private String nombre;
    private String apellido;
    private int DNI;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;

    public Paciente(Long id, String nombre, String apellido, int DNI, LocalDate fechaIngreso, Domicilio domicilio, Long id_odontologo) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.id_odontologo=id_odontologo;
    }

    public Paciente(String nombre, String apellido, int DNI, LocalDate fechaIngreso, Domicilio domicilio, Long id_odontologo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.id_odontologo=id_odontologo;
    }

    public Long getId_odontologo() {
        return id_odontologo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }


    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI=" + DNI +
                ", fechaIngreso=" + fechaIngreso +
                "}\n"+this.domicilio.toString();
    }
}
