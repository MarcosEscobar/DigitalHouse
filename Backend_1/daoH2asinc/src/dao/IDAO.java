package dao;

import java.util.List;

public interface IDAO<T>{
    void registrarAvion(T t);
    T buscarPorId(int id);
    void eliminarPorId(int id);
    List<T> buscarTodos();
}
