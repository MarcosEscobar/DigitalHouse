import org.apache.log4j.Logger;

import java.sql.*;

public class main {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement stmt = con.createStatement();
        String query;
        String query2;
        Logger logger = Logger.getLogger(main.class);

        String createSql = "DROP TABLE IF EXISTS EMPLEADO;\n" +
                "CREATE TABLE EMPLEADO (id INT PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), hobby VARCHAR(255), tallecalzado INT);";
        stmt.execute(createSql);

        query="INSERT INTO EMPLEADO VALUES(1, 'justo', 'marelli', 'truco', 43),\n"+
                "(2, 'mati', 'erramuspe', 'bungee jumping', 42),\n"+
                "(3, 'fede', 'busta', 'romper las bolas', 44),\n"+
                "(4, 'marcos', 'escobar', 'narcotráfico', 43)";
        query2="INSERT INTO EMPLEADO VALUES (1, 'rocío', 'rivas', 'violencia', 48)";
        try{
            stmt.execute(query);
            stmt.execute(query2);
        }catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }finally {
            con.close();
        }

        //UPDATE

        con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        stmt = con.createStatement();
        query="UPDATE EMPLEADO SET ID='666' WHERE APELLIDO='escobar';";
        query2="SELECT * FROM EMPLEADO WHERE ID='666'";
        try{
            stmt.execute(query);
            ResultSet rs=stmt.executeQuery(query2);
            if (rs.next()) {
                logger.debug("Datos del empleado modificado -> ID: "+rs.getInt(1)+", nombre: "+rs.getString(2)+
                        ", apellido: "+rs.getString(3)+", hobby: "+rs.getString(4)+", talle de calzado: "+rs.getInt(5));
            }
        }catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }finally {
            con.close();
        }

        //DELETE CON ID

        con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        stmt = con.createStatement();
        query="SELECT * FROM EMPLEADO WHERE ID='666'";
        query2="DELETE FROM EMPLEADO WHERE ID='666';";
        try{

            ResultSet rs=stmt.executeQuery(query);
            if (rs.next()) {
                logger.info("Datos del empleado eliminado por ID -> ID: "+rs.getInt(1)+", nombre: "+rs.getString(2)+
                        ", apellido: "+rs.getString(3)+", hobby: "+rs.getString(4)+", talle de calzado: "+rs.getInt(5));
            }
            stmt.execute(query2);
        }catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }finally {
            con.close();
        }

        //DELETE CON APELLIDO

        con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        stmt = con.createStatement();
        query="SELECT * FROM EMPLEADO WHERE APELLIDO='erramuspe'";
        query2="DELETE FROM EMPLEADO WHERE APELLIDO='erramuspe'";
        try{

            ResultSet rs=stmt.executeQuery(query);
            if (rs.next()) {
                logger.info("Datos del empleado eliminado por apellido -> ID: "+rs.getInt(1)+", nombre: "+rs.getString(2)+
                        ", apellido: "+rs.getString(3)+", hobby: "+rs.getString(4)+", talle de calzado: "+rs.getInt(5));
            }
            stmt.execute(query2);
        }catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }finally {
            con.close();
        }
    }
}
