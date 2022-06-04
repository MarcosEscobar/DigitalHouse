package com.odontologos.dao.impl;

import com.odontologos.dao.IDao;
import com.odontologos.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDaoH2 implements IDao<Odontologo> {
    //Driver H2
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:~/.test;INIT=RUNSCRIPT FROM 'create.sql'";
    //Credenciales para acceder a la dB
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";
    //Inicializamos el logger
    public static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    //Implementamos los métodos
    @Override
    public Odontologo guardar(Odontologo odontologo) throws SQLException {
        logger.debug("Iniciando guardado de Odontólogo");
        PreparedStatement preparedStatement;
        try {
            //Conectamos con la base de datos
            Connection connection = conectarConH2();
            //Creamos una sentencia SQL
            logger.debug("Creamos la sentencia SQL para guardar Odontólogo");
            preparedStatement = connection.prepareStatement("INSERT INTO odontologos (NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?)");
            /*El ID es autoincremental, por lo que no se lo pasamos por parámetro.
            preparedStatement.setLong(1, odontologo.getId()); */
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setInt(3, odontologo.getMatricula());
            //Eiecutamos la sentencia SQL
            logger.debug("Estamos guardando el siguiente odontólogo: ");
            logger.info(odontologo.toString());
            preparedStatement.executeUpdate();
            //Cerramos el Statement
            preparedStatement.close();
            logger.debug("Registro guardado con éxito");
        } catch (Exception e){
            //Capturamos en caso de error y reportamos.
            logger.error("Error al ejecutar la sentencia SQL al guardar");
            e.printStackTrace();
        } finally {
            conectarConH2().close();
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Long id) throws Exception {
        logger.debug("Iniciando buscador de Odontólogo");
        PreparedStatement preparedStatement;
        Odontologo odontologo = new Odontologo();

        try {
            //Conectamos con la base de datos
            Connection connection = conectarConH2();
            //Creamos una sentencia SQL
            logger.debug("Creamos la sentencia SQL para buscar el registro");
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id=?");
            preparedStatement.setLong(1,id);
            logger.debug(preparedStatement);
            //Eiecutamos la sentencia SQL
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                odontologo.setId(resultSet.getLong(1));
                odontologo.setNombre(resultSet.getString(2));
                odontologo.setApellido(resultSet.getString(3));
                odontologo.setMatricula(resultSet.getInt(4));
                logger.debug("Registro encontrado.");
                logger.info(odontologo.toString());
            } else {
                throw new Exception("No hay registros con ese ID");
            }
            //Cerramos el Statement y ResultSet
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e){
            //Capturamos en caso de error y reportamos.
            logger.error("Error al ejecutar la sentencia SQL al buscar.");
            e.printStackTrace();
        } finally {
            conectarConH2().close();
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() throws SQLException {
        logger.debug("Iniciando listar Odontólogos");
        PreparedStatement preparedStatement;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            //Conectamos con la base de datos
            Connection connection = conectarConH2();
            //Creamos una sentencia SQL
            logger.debug("Creamos la sentencia SQL para listar los registros");
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");
            //Eiecutamos la sentencia SQL
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Odontologo odontologo = new Odontologo(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
                odontologos.add(odontologo);
            }
            //Cerramos el Statement y ResultSet
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e){
            //Capturamos en caso de error y reportamos.
            logger.error("Error al ejecutar la sentencia SQL al listar.");
            e.printStackTrace();
        } finally {
            conectarConH2().close();
        }
        logger.debug(odontologos.toString());
        return odontologos;
    }

    @Override
    public boolean borrar(Long id) throws Exception {
        PreparedStatement preparedStatement;
        OdontologoDaoH2 odontologo = new OdontologoDaoH2();
        logger.debug("Valor de odontologo no encontrado: " + odontologo);
        if (odontologo.buscar(id).getId() == null) {
            logger.error("No se encontró ningún registro con ese ID");
            return false;
        } else {
            try {
                //Conectamos con la base de datos
                Connection connection = conectarConH2();
                //Preparamos la sentencia SQL
                logger.debug("Creamos la sentencia SQL para borrar el registro");
                preparedStatement = connection.prepareStatement("DELETE FROM odontologos WHERE ID=?");
                preparedStatement.setLong(1, id);
                //Ejecutamos la sentencia SQL
                preparedStatement.executeUpdate();
                preparedStatement.close();
                logger.debug("Registro borrado");
                return true;
            } catch (Exception e) {
                logger.error("Error al ejecutar la sentencia SQL para borrar el registro.");
                e.printStackTrace();
                return false;
            } finally {
                conectarConH2().close();
            }
        }
    }

    public Connection conectarConH2() {
        Connection connection = null;
        try {
            logger.debug("Obteniendo conexión con la base de datos.");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("No se pudo establecer la conexión con la base de datos.");
            logger.error(e.getMessage());
        }
        return connection;
    }
}
