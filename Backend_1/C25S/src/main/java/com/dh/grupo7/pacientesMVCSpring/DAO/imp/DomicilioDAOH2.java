package com.dh.grupo7.pacientesMVCSpring.DAO.imp;

import com.dh.grupo7.pacientesMVCSpring.domain.Domicilio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.dh.grupo7.pacientesMVCSpring.DAO.IDAO;

public class DomicilioDAOH2 implements IDAO<Domicilio>{

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    private Connection con;

    @Override
    public Domicilio darAlta(Domicilio domicilio) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            //inicio la conexión
            con = this.getConnection();
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement("INSERT INTO DOMICILIOS (calle, numero, localidad, provincia) VALUES(?,?,?,?)");
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            //ejecuto la sentencia
            preparedStatement.executeUpdate();
            //hago el commit y luego habilito el autocommit
            con.commit();
            con.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (Exception a) {
                a.printStackTrace();
            }
        }finally {
            //cierro la conexión
            con.close();
        }
        return domicilio;
    }

    @Override
    public void modificar(Domicilio domicilio) throws SQLException {

    }

    @Override
    public Domicilio buscarPorId(Long id) throws SQLException {
        //armo mi sentencia
        String buscarSQLdomicilio = "select * from DOMICILIOS where ID='" + id + "'";
        ResultSet rdDomicilio = null;
        Domicilio domicilioEncontrado = null;

        try {
            con = this.getConnection();
            Statement stmt = con.createStatement();
            //ejecuto la query
            rdDomicilio = stmt.executeQuery(buscarSQLdomicilio);
            //si obtengo un resultado, armo un objeto paciente para el return
            if (rdDomicilio.next()) {
                domicilioEncontrado = new Domicilio(
                        rdDomicilio.getLong("id"),
                        rdDomicilio.getString("calle"),
                        rdDomicilio.getInt("numero"),
                        rdDomicilio.getString("localidad"),
                        rdDomicilio.getString("provincia")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return domicilioEncontrado;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String eliminarSQLdomicilio;
        //armo la query
        eliminarSQLdomicilio = "delete from DOMICILIOS where ID='" + id + "'";

        try {
            //abro la conexión y ejecuto la sentencia
            con = this.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(eliminarSQLdomicilio);
            System.out.println("domicilio ID "+id+" eliminado");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //cierro la conexión
            con.close();
        }
    }

    @Override
    public List<Domicilio> buscarTodos() throws SQLException {
        //armo la sentencia
        String buscarTodosSQLdomicilios= "SELECT * FROM DOMICILIOS";
        //listado de pacientes para almacenar los resultados de la query
        List<Domicilio> domicilios = new ArrayList<>();

        try {
            //abro la conexión
            con = this.getConnection();
            Statement stmt = con.createStatement();
            //ejecuto la query y almaceno los resultados
            ResultSet rdDomicilio = stmt.executeQuery(buscarTodosSQLdomicilios);
            //armo objetos aviones para insertar en el listado
            while (rdDomicilio.next()) {
                Domicilio domicilioEncontrado = new Domicilio(
                        rdDomicilio.getLong("id"),
                        rdDomicilio.getString("calle"),
                        rdDomicilio.getInt("numero"),
                        rdDomicilio.getString("localidad"),
                        rdDomicilio.getString("provincia")
                );
                domicilios.add(domicilioEncontrado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //cierro la conexión
            con.close();
        }
        //retorno el listado de pacientes
        return domicilios;
    }
    public Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
