package com.example.clinica.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Que la base de datos se encargue del autoincremento.
    private Long id;

    private LocalDateTime fechaYhoraDeTurno;
    @ManyToOne
    @JoinColumn(name = "pacienteId", nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "odontologoId", nullable = false)
    private Odontologo odontologo;

    public Turno() {

    }

    public Turno(LocalDateTime fechaYhoraDeTurno, Paciente paciente, Odontologo odontologo) {
        this.fechaYhoraDeTurno = fechaYhoraDeTurno;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaYhoraDeTurno() {
        return fechaYhoraDeTurno;
    }

    public void setFechaYhoraDeTurno(LocalDateTime fechaYhoraDeTurno) {
        this.fechaYhoraDeTurno = fechaYhoraDeTurno;
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
}
