package poo;

import poo.empleados.GeneradorDeSentencias;

import java.sql.*;
import java.time.LocalDate;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String createTable = GeneradorDeSentencias.crearTabla(
                    Map.of("id", "INTEGER PRIMARY KEY",
                           "nombre", "VARCHAR(50)",
                           "nombreEmpresa", "VARCHAR(50)",
                           "fechaIngreso", "VARCHAR(50)")
            );
            statement.execute(createTable);

            statement.execute(GeneradorDeSentencias.generarInsert(1, "Pepe", "Les Pepes", LocalDate.of(2015, 6, 1)));
            statement.execute(GeneradorDeSentencias.generarInsert(2, "Pepa", "Les Pepes", LocalDate.of(2017, 3, 1)));
            statement.execute(GeneradorDeSentencias.generarInsert(3, "Pepo", "Les Pepes", LocalDate.of(2010, 1, 1)));
            statement.execute(GeneradorDeSentencias.generarInsert(4, "Pipo", "Les Pipes", LocalDate.of(2021, 8, 20)));
            statement.execute(GeneradorDeSentencias.generarInsert(5, "Pipa", "Les Pipes", LocalDate.of(2021, 8, 20)));

            statement.execute(GeneradorDeSentencias.generarDelete(3));

            ResultSet results = statement.executeQuery(GeneradorDeSentencias.generarSelectAll());
            while (results.next()) {
                String registry = results.getInt("id") + ". " +
                        results.getString("nombre")  + " trabaja en " +
                        results.getString("nombreEmpresa") + " desde " +
                        results.getString("fechaIngreso");
                System.out.println(registry);
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.err.println("La conexión no puede cerrarse porque nunca se inicializó (es null)");
                System.err.println(e.getMessage());
            }
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}
