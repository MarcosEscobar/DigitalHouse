package com.example.clinica.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private int id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDateTime fechaYhoraDeTurno;

    public TurnoDTO() {

    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDateTime getFechaYhoraDeTurno() {
        return fechaYhoraDeTurno;
    }

    public void setFechaYhoraDeTurno(LocalDateTime fechaYhoraDeTurno) {
        this.fechaYhoraDeTurno = fechaYhoraDeTurno;
    }
}
