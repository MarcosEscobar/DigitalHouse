package com.dh.grupo7.pacientesMVCSpring.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    T darAlta(T t) throws SQLException;
    void modificar(T t) throws SQLException;
    T buscarPorId(Long id) throws SQLException;
    void eliminar(Long id) throws SQLException;
    List<T> buscarTodos() throws SQLException;
}
