package com.dh.grupo7.pacientesMVCSpring.service;

import com.dh.grupo7.pacientesMVCSpring.DAO.IDAO;
import com.dh.grupo7.pacientesMVCSpring.domain.Odontologo;
import com.dh.grupo7.pacientesMVCSpring.domain.Turno;

import java.sql.SQLException;
import java.util.List;

public class TurnoService {
    private IDAO<Turno> turnoDAO;

    public TurnoService(IDAO<Turno> turnoDAO){
        this.turnoDAO=turnoDAO;
    }

    public List<Turno> buscarTodos() throws SQLException {
        return turnoDAO.buscarTodos();
    }
    public void darAlta(Turno turno) throws SQLException {
        turnoDAO.darAlta(turno);
    }

    public Turno buscarPorId(Long id) throws SQLException {
        return turnoDAO.buscarPorId(id);
    }

    public void eliminarPorId(Long id) throws SQLException {
        turnoDAO.eliminar(id);
    }
}
