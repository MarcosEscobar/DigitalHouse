package com.dh.grupo7.pacientesMVCSpring.DAO.imp;

import com.dh.grupo7.pacientesMVCSpring.DAO.IDAO;
import com.dh.grupo7.pacientesMVCSpring.domain.Paciente;
import com.dh.grupo7.pacientesMVCSpring.domain.Turno;

import java.sql.*;
import java.util.List;

public class TurnoDAOH2 implements IDAO<Turno> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    private Connection con;

    @Override
    public Turno darAlta(Turno turno) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            //inicio la conexión
            con = this.getConnection();
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement("INSERT INTO TURNOS (id_paciente, id_odontologo, fechaYHora) VALUES(?,?,?)");
            preparedStatement.setLong(1, turno.getId_paciente());
            preparedStatement.setLong(2, turno.getId_odontologo());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(turno.getFechaYHora()));

            //ejecuto la sentencia
            preparedStatement.executeUpdate();
            //hago el commit y luego habilito el autocommit
            con.commit();
            con.setAutoCommit(true);
            System.out.println("turno agregado con éxito");
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
        return turno;
    }

    @Override
    public void modificar(Turno turno) throws SQLException {

    }

    @Override
    public Turno buscarPorId(Long id) throws SQLException {
        String buscarSQLturno = "select * from TURNOS where ID='" + id + "'";
        ResultSet rdTurno = null;
        Turno turnoEncontrado=null;

        try {
            con = this.getConnection();
            Statement stmt = con.createStatement();
            //ejecuto la query
            rdTurno = stmt.executeQuery(buscarSQLturno);
            //si obtengo un resultado, armo un objeto turno para el return
            if (rdTurno.next()) {
                turnoEncontrado = new Turno(
                        rdTurno.getLong("id"),
                        rdTurno.getLong("id_paciente"),
                        rdTurno.getLong("id_odontologo"),
                        rdTurno.getTimestamp("fechaYHora").toLocalDateTime()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //cierro la conexión
            con.close();

        }
        return turnoEncontrado;
    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    @Override
    public List<Turno> buscarTodos() throws SQLException {
        return null;
    }

    public Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
