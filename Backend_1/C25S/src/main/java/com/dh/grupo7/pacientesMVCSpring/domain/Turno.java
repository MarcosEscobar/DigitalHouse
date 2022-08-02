package com.dh.grupo7.pacientesMVCSpring.domain;

import java.time.LocalDateTime;

public class Turno {
    private Long id;
    private Long id_paciente;
    private Long id_odontologo;
    private LocalDateTime fechaYHora;

    public Long getId() {
        return id;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Long getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(Long id_odontologo) {
        this.id_odontologo = id_odontologo;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Turno(Long id, Long id_paciente, Long id_odontologo, LocalDateTime fechaYHora) {
        this.id = id;
        this.id_paciente = id_paciente;
        this.id_odontologo = id_odontologo;
        this.fechaYHora = fechaYHora;
    }

    public Turno(Long id_paciente, Long id_odontologo, LocalDateTime fechaYHora) {
        this.id_paciente = id_paciente;
        this.id_odontologo = id_odontologo;
        this.fechaYHora = fechaYHora;
    }
}

