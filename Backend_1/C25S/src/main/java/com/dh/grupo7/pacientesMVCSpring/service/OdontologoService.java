package com.dh.grupo7.pacientesMVCSpring.service;

import com.dh.grupo7.pacientesMVCSpring.domain.Odontologo;
import com.dh.grupo7.pacientesMVCSpring.DAO.IDAO;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {
    private IDAO<Odontologo> odontologoDAO;

    public OdontologoService(IDAO<Odontologo> odontologoDAO){
        this.odontologoDAO=odontologoDAO;
    }

    public List<Odontologo> buscarTodos() throws SQLException {
        return odontologoDAO.buscarTodos();
    }
    public void darAlta(Odontologo odontologo) throws SQLException {
        odontologoDAO.darAlta(odontologo);
    }

    public Odontologo buscarPorId(Long id) throws SQLException {
        return odontologoDAO.buscarPorId(id);
    }

    public void eliminarPorId(Long id) throws SQLException {
        odontologoDAO.eliminar(id);
    }
}
