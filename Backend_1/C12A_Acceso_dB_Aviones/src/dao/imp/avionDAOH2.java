package dao.imp;

import dao.IDAO;
import model.avion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class avionDAOH2 implements IDAO<avion> {
    //variables para iniciar la conexión con la base de datos
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    private Connection con;

    public avionDAOH2() throws Exception {
        con = this.getConnection();
        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear con datos de prueba
        String createSql = "DROP TABLE IF EXISTS AVION;\n" +
                "CREATE TABLE AVION(ID INT PRIMARY KEY, MARCA VARCHAR(255), MODELO VARCHAR(255), MATRICULA VARCHAR(255), FECHAENTRADASERVICIO DATE);" +
                "INSERT INTO AVION VALUES(1, 'MARCA1', 'MODELO1', 'MATRICULA1', '2022-05-01');\n" +
                "INSERT INTO AVION VALUES(2, 'MARCA2', 'MODELO2', 'MATRICULA2', '2020-05-01');\n";
        try{
            stmt.execute(createSql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    @Override
    public void registrarAvion(avion avion) {
        PreparedStatement preparedStatement = null;

        try {
            //inicio la conexión
            con = this.getConnection();
            con.setAutoCommit(false);
            //armo mi sentencia
            preparedStatement = con.prepareStatement("INSERT INTO AVION VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, avion.getId());
            preparedStatement.setString(2, avion.getMarca());
            preparedStatement.setString(3, avion.getModelo());
            preparedStatement.setString(4, avion.getMatricula());
            preparedStatement.setDate(5, Date.valueOf(avion.getEntradaEnServicio()));

            //ejecuto la sentencia
            preparedStatement.executeUpdate();

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
            try {
                //cierro la conexión
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public avion buscarPorId(int id) {
        System.out.println("Buscando avión con ID "+id);
        //armo mi sentencia
        String buscarSQL = "select * from AVION where ID='" + id + "'";
        ResultSet rd = null;
        avion avEncontrado=null;

        try {
            con = this.getConnection();
            Statement stmt = con.createStatement();
            //ejecuto la query
            rd = stmt.executeQuery(buscarSQL);
            //si obtengo un resultado, armo un objeto avion para el return
            if (rd.next()) {
                avEncontrado = new avion(rd.getString("MARCA"), rd.getString("MODELO"), rd.getString("MATRICULA"),
                        rd.getDate("FECHAENTRADASERVICIO").toLocalDate(), rd.getInt("ID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //cierro la conexión
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return avEncontrado;
    }



    @Override
    public void eliminarPorId(int id) {
        System.out.println("Eliminando avión con ID "+id);
        String eliminarSQL;
        //armo la query
        eliminarSQL = "delete from AVION where ID='" + id + "'";

        try {
            //abro la conexión y ejecuto la sentencia
            con = this.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(eliminarSQL);
            System.out.println("Avion ID "+id+" eliminado");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //cierro la conexión
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<avion> buscarTodos() {
        //armo la sentencia
        String buscarTodosSQL = "SELECT * FROM AVION";
        //listado de aviones para almacenar los resultados de la query
        List<avion> aviones = new ArrayList<>();

        try {
            //abro la conexión
            con = this.getConnection();
            Statement stmt = con.createStatement();
            //ejecuto la query y almaceno los resultados
            ResultSet result = stmt.executeQuery(buscarTodosSQL);

            //armo objetos aviones para insertar en el listado
            while (result.next()) {
                int id = result.getInt("ID");
                String marca = result.getString("MARCA");
                String modelo = result.getString("MODELO");
                String matricula = result.getString("MATRICULA");
                Date fechaentradaservicio = result.getDate("FECHAENTRADASERVICIO");
                avion avion=new avion(marca, modelo, matricula, fechaentradaservicio.toLocalDate(),id);
                aviones.add(avion);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //cierro la conexión
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //retorno el listado de aviones
        return aviones;
    }

    //método genérico para iniciar las conexiones a la base de datos
    public Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
