package com.dh.animales.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracionJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nombreUsuario;
    private String contrasenia;

    public ConfiguracionJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:mem:animales;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql';";
        this.nombreUsuario = "sa";
        this.contrasenia = "sa";
    }

    public ConfiguracionJDBC(String jdbcDriver, String dbUrl, String nombreUsuario, String contrasenia) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public Connection contectarConBD() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenia);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }
}
