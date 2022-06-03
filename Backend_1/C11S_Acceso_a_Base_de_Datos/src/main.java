import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        String createSql = "DROP TABLE IF EXISTS FIGURAS;\n" +
                "CREATE TABLE FIGURAS (id INT PRIMARY KEY, tipo VARCHAR(255), color VARCHAR(255));\n" +
                "INSERT INTO FIGURAS VALUES(1, 'circulo', 'rojo');\n" +
                "INSERT INTO FIGURAS VALUES(2, 'circulo', 'amarillo');\n"+
                "INSERT INTO FIGURAS VALUES(3, 'cuadrado', 'violeta');\n"+
                "INSERT INTO FIGURAS VALUES(4, 'cuadrado', 'rojo');\n"+
                "INSERT INTO FIGURAS VALUES(5, 'cuadrado', 'verde');";
        stmt.execute(createSql);

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "select * from FIGURAS where tipo='circulo' and color='rojo'";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        System.out.println("Círculos de color rojo:");
        while(rd.next()) {
            System.out.println("Id: "+rd.getInt("id") +", tipo de figura: "+ rd.getString("tipo")+", color: "+rd.getString("color"));
        }

        //nueva consulta para luego listar todas las figuras
        sql = "select * from FIGURAS";
        rd = stmt.executeQuery(sql);
        System.out.println("Todas las figuras:");

        //Código para recorrer el resultado de la consulta
        while(rd.next()) {
            System.out.println("Id: "+rd.getInt("id") +", tipo de figura: "+ rd.getString("tipo")+", color: "+rd.getString("color"));
        }

        //cierro la conexión
        stmt.close();
    }
}
