package com.dh.grupo7.pacientesMVCSpring.DAO.imp;

import com.dh.grupo7.pacientesMVCSpring.domain.Odontologo;
import com.dh.grupo7.pacientesMVCSpring.DAO.IDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDAO<Odontologo> {
    //variables para iniciar la conexión con la base de datos
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    private Connection con;

    @Override
    public Odontologo darAlta(Odontologo odontologo) {
        PreparedStatement preparedStatement = null;

        //uso el try con recursos que se encarga de cerrar la conexión automáticamente
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            con.setAutoCommit(false);
            //armo mi sentencia usando los datos del odontólogo pasado por parámetro
            preparedStatement = con.prepareStatement("INSERT INTO odontologos (matricula, nombre, apellido) VALUES(?,?,?)");
            preparedStatement.setString(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            //ejecuto la sentencia
            preparedStatement.executeUpdate();
            //hago el commit y luego habilito el autocommit
            con.commit();
            con.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void modificar(Odontologo odontologo) throws SQLException {
        this.eliminar(odontologo.getId());
        this.darAlta(odontologo);
    }

    @Override
    public Odontologo buscarPorId (Long id) {
        //armo mi sentencia
        String buscarSQL = "select * from odontologos where ID='" + id + "'";
        Odontologo odEncontrado=null;

        //uso el try con recursos que se encarga de cerrar la conexión automáticamente
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            Statement stmt = con.createStatement();
            //ejecuto la query
            ResultSet result = stmt.executeQuery(buscarSQL);
            //si obtengo un resultado, armo un objeto odontologo para el return
            //vale notar que se usa el constructor con ID
            if (result.next()) {
                odEncontrado = new Odontologo(
                        result.getString("matricula"),
                        result.getString("nombre"),
                        result.getString("apellido"),
                        result.getLong("id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return odEncontrado;
    }

    @Override
    public void eliminar(Long id) {
        //armo la query
        String eliminarSQL = "delete from odontologos where ID='" + id + "'";

        //uso el try con recursos que se encarga de cerrar la conexión automáticamente
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            //abro la conexión y ejecuto la sentencia
            Statement stmt = con.createStatement();
            stmt.execute(eliminarSQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        //armo la sentencia
        String buscarTodosSQL = "SELECT * FROM odontologos";
        //listado de odontologos para almacenar los resultados de la query
        List<Odontologo> odontologos = new ArrayList<>();

        //uso el try con recursos que se encarga de cerrar la conexión automáticamente
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            Statement stmt = con.createStatement();
            //ejecuto la query y almaceno los resultados
            ResultSet result = stmt.executeQuery(buscarTodosSQL);

            //armo objetos odontólogos para insertar en el listado
            //vale notar que se usa el constructor con ID
            while (result.next()) {
                Odontologo odontologo=new Odontologo(
                        result.getString("matricula"),
                        result.getString("nombre"),
                        result.getString("apellido"),
                        result.getLong("id")
                );
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //retorno el listado de odontologos
        return odontologos;
    }

    //método genérico para iniciar las conexiones a la base de datos
    public Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
