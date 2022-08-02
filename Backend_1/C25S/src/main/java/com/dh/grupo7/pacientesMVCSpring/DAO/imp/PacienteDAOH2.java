package com.dh.grupo7.pacientesMVCSpring.DAO.imp;

import com.dh.grupo7.pacientesMVCSpring.domain.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.dh.grupo7.pacientesMVCSpring.DAO.IDAO;

public class PacienteDAOH2 implements IDAO<Paciente>{
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    private Connection con;
    private DomicilioDAOH2 domicilioDAOH2=new DomicilioDAOH2();

    @Override
    public Paciente darAlta(Paciente paciente) throws SQLException {
        System.out.println("Agregando paciente:");
        System.out.println(paciente.toString());
        PreparedStatement preparedStatement = null;

        try {
            //inicio la conexión
            con = this.getConnection();
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement("INSERT INTO PACIENTES (nombre, apellido, dni, fechaingreso, id_odontologo) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setInt(3, paciente.getDNI());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setLong(5, paciente.getId_odontologo());

            //ejecuto la sentencia
            preparedStatement.executeUpdate();
            //hago el commit y luego habilito el autocommit
            con.commit();
            con.setAutoCommit(true);
            domicilioDAOH2.darAlta(paciente.getDomicilio());
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
        return paciente;
    }

    @Override
    public void modificar(Paciente paciente) throws SQLException {
        this.eliminar(paciente.getId());
        this.darAlta(paciente);
    }

    @Override
    public Paciente buscarPorId(Long id) throws SQLException {
        System.out.println("Buscando paciente con ID "+id);
        //armo mi sentencia
        String buscarSQLpaciente = "select * from PACIENTES where ID='" + id + "'";
        ResultSet rdPaciente = null;
        Paciente pacienteEncontrado=null;

        try {
            con = this.getConnection();
            Statement stmt = con.createStatement();
            //ejecuto la query
            rdPaciente = stmt.executeQuery(buscarSQLpaciente);
            //si obtengo un resultado, armo un objeto paciente para el return
            if (rdPaciente.next()) {
                pacienteEncontrado = new Paciente(
                        rdPaciente.getLong("id"),
                        rdPaciente.getString("nombre"),
                        rdPaciente.getString("apellido"),
                        rdPaciente.getInt("DNI"),
                        rdPaciente.getDate("fechaIngreso").toLocalDate(),
                        domicilioDAOH2.buscarPorId(id),
                        rdPaciente.getLong("id_odontologo")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //cierro la conexión
            con.close();

        }
        return pacienteEncontrado;
    }


    @Override
    public void eliminar(Long id) throws SQLException {
        System.out.println("Eliminando paciente con ID "+id);
        String eliminarSQLpaciente;
        //armo la query
        eliminarSQLpaciente = "delete from PACIENTES where ID='" + id + "'";

        try {
            //abro la conexión y ejecuto la sentencia
            con = this.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(eliminarSQLpaciente);
            System.out.println("Paciente ID "+id+" eliminado");
            domicilioDAOH2.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //cierro la conexión
            con.close();
        }
    }

    @Override
    public List<Paciente> buscarTodos() throws SQLException {
        //armo la sentencia
        String buscarTodosSQLpacientes = "SELECT * FROM PACIENTES";
        //listado de pacientes para almacenar los resultados de la query
        List<Paciente> pacientes = new ArrayList<>();
        try {
            //abro la conexión
            con = this.getConnection();
            Statement stmt = con.createStatement();
            //ejecuto la query y almaceno los resultados
            ResultSet rdPaciente = stmt.executeQuery(buscarTodosSQLpacientes);
            //armo objetos aviones para insertar en el listado
            while (rdPaciente.next()) {
                Paciente pacienteEncontrado = new Paciente(
                        rdPaciente.getLong("id"),
                        rdPaciente.getString("nombre"),
                        rdPaciente.getString("apellido"),
                        rdPaciente.getInt("DNI"),
                        rdPaciente.getDate("fechaIngreso").toLocalDate(),
                        domicilioDAOH2.buscarPorId(rdPaciente.getLong("id")),
                        rdPaciente.getLong("id_odontologo")
                );
                pacientes.add(pacienteEncontrado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //cierro la conexión
            con.close();
        }
        //retorno el listado de pacientes
        return pacientes;
    }

    public Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
