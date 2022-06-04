package com.odontologos.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T guardar(T t) throws SQLException;
    T buscar(Long id) throws Exception;
    List<T> listar() throws  SQLException;
    boolean borrar(Long id) throws Exception;
}