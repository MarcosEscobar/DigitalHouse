package model;

import java.time.LocalDate;

public class avion {
    private String marca;
    private String modelo;
    private String matricula;
    private LocalDate entradaEnServicio;
    private int id;

    public avion(String marca, String modelo, String matricula, LocalDate entradaEnServicio, int id) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.entradaEnServicio = entradaEnServicio;
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getEntradaEnServicio() {
        return entradaEnServicio;
    }

    public void setEntradaEnServicio(LocalDate entradaEnServicio) {
        this.entradaEnServicio = entradaEnServicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Avión ID "+this.id+", marca "+this.marca+", modelo "+this.modelo+", matrícula "+this.matricula+
                " y fecha de entrada en servicio en "+this.entradaEnServicio;
    }
}
