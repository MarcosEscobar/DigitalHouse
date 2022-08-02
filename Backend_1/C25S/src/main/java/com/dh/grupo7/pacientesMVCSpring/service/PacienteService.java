package com.dh.grupo7.pacientesMVCSpring.service;

import com.dh.grupo7.pacientesMVCSpring.domain.Paciente;
import com.dh.grupo7.pacientesMVCSpring.DAO.IDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PacienteService {
    private IDAO<Paciente> pacienteDAO;

    public PacienteService(){}
    public PacienteService(IDAO<Paciente> pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public void setPacienteDAO(IDAO<Paciente> pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public Paciente darAlta(Paciente p) throws SQLException{
       return pacienteDAO.darAlta(p);
    }
    void modificar(Paciente p) throws SQLException{
        pacienteDAO.modificar(p);
    };
    public Paciente buscarPorId(Long id) throws SQLException{
       return pacienteDAO.buscarPorId(id);
    };

    public void eliminar(Long id) throws SQLException {
        pacienteDAO.eliminar(id);
    }

    public List<Paciente> buscarTodos() throws SQLException{
        return pacienteDAO.buscarTodos();
    };

}
