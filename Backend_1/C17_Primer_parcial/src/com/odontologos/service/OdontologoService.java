package com.odontologos.service;

import com.odontologos.dao.IDao;
import com.odontologos.model.Odontologo;
import java.sql.SQLException;
import java.util.List;

public class OdontologoService {

    private final IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologo) {
        this.odontologoIDao = odontologo;
    }

    public void guardar(Odontologo odontologo) throws SQLException {
        this.odontologoIDao.guardar(odontologo);
    }

    public Odontologo buscar(Long id) throws Exception {
        return this.odontologoIDao.buscar(id);
    }

    public void borrar(Long id) throws Exception {
        this.odontologoIDao.borrar(id);
    }

    public List<Odontologo> listar() throws SQLException {
        return this.odontologoIDao.listar();
    }

}
