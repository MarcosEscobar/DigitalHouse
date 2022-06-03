package com.dh.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T consultarPorId(Integer id) throws SQLException, Exception;
    List<T> consultarTodos() throws  SQLException;
    T insertarNuevo(T t) throws SQLException, Exception;
    void borrarTodos() throws SQLException;
    Boolean borrarPorId(Integer id) throws SQLException;
    Boolean actualizar(T paciente) throws Exception;
}
