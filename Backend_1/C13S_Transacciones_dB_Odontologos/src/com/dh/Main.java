package com.dh;

import java.sql.*;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            Statement crearTabla = connection.createStatement();
            crearTabla.execute(GeneradorDeSentencias.crearTabla(
                    Map.of("nombre", "VARCHAR(50)",
                            "apellido", "VARCHAR(50)",
                            "matricula", "VARCHAR(50)")
            ));

            Odontologo o = new Odontologo("Pepe", "Peposo", "A123B");
            PreparedStatement insertarOdontologo = connection.prepareStatement(GeneradorDeSentencias.generarInsert());
            insertarOdontologo.setString(1, o.getNombre());
            insertarOdontologo.setString(2, o.getApellido());
            insertarOdontologo.setString(3, o.getApellido());
            insertarOdontologo.execute();

//            connection.commit();

            connection.close();
            connection = getConnection();
//            connection.rollback();

            PreparedStatement obtenerOdontologos = connection.prepareStatement(GeneradorDeSentencias.generarSelectAll());
            ResultSet odontologosEnDB = obtenerOdontologos.executeQuery();
            while (odontologosEnDB.next()) {
                String registry = odontologosEnDB.getString("nombre") + " " +
                        odontologosEnDB.getString("apellido")  + " - Matricula: " +
                        odontologosEnDB.getString("matricula");
                System.out.println(registry);
            }

        } catch(Exception e) {
            try {
                assert connection != null;
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println(e.getMessage());
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("La conexión no puede cerrarse porque nunca se inicializó (es null)");
            }
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}
