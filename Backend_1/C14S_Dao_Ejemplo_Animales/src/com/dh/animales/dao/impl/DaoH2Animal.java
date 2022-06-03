package com.dh.animales.dao.impl;

import com.dh.animales.GeneradorDeSentenciasAnimales;
import com.dh.animales.dao.ConfiguracionJDBC;
import com.dh.animales.dao.IDao;
import com.dh.animales.entidades.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoH2Animal implements IDao<Animal> {

    private ConfiguracionJDBC configuracionJDBC;

    public DaoH2Animal(ConfiguracionJDBC configuracionJDBC) throws Exception {
        if (configuracionJDBC == null) {
            throw new Exception("Sin configuracion de JDBC no hay DAO");
        }
        this.configuracionJDBC = configuracionJDBC;
    }

    @Override
    public Animal consultarPorId(Animal animal) throws SQLException {
        Connection connection = configuracionJDBC.contectarConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentenciasAnimales.generarSelectPorId());
        preparedStatement.setInt(1, animal.getId());
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            animal.setTipo(result.getString("tipo"));
            animal.setNombre(result.getString("nombre"));
        }

        connection.close();
        return animal;
    }

    @Override
    public Boolean insertarNuevo(Animal animal) throws SQLException {
        Connection connection = configuracionJDBC.contectarConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentenciasAnimales.generarInsertConId());
        preparedStatement.setInt(1, animal.getId());
        preparedStatement.setString(2, animal.getTipo());
        preparedStatement.setString(3, animal.getNombre());
        Boolean sePudoInsertar = preparedStatement.execute();
        connection.close();
        return sePudoInsertar;
    }

    @Override
    public List<Animal> consultarTodos() throws SQLException {
        Connection connection = configuracionJDBC.contectarConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentenciasAnimales.generarSelectAll());
        ResultSet results = preparedStatement.executeQuery();
        List<Animal> animals = new ArrayList<>();

        while(results.next()) {
            Animal animal = new Animal(results.getInt("id"), results.getString("nombre"), results.getString("tipo"));
            animals.add(animal);
        }
        return animals;
    }
}
