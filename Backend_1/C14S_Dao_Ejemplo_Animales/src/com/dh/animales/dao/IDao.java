package com.dh.animales.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T consultarPorId(T t) throws SQLException;
    Boolean insertarNuevo(T t) throws SQLException;
    List<T> consultarTodos() throws  SQLException;
}
