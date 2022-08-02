package com.dh.grupo7.pacientesMVCSpring;

import com.dh.grupo7.pacientesMVCSpring.DAO.imp.TurnoDAOH2;
import com.dh.grupo7.pacientesMVCSpring.domain.Domicilio;
import com.dh.grupo7.pacientesMVCSpring.domain.Paciente;
import com.dh.grupo7.pacientesMVCSpring.DAO.imp.PacienteDAOH2;
import com.dh.grupo7.pacientesMVCSpring.domain.Turno;
import com.dh.grupo7.pacientesMVCSpring.service.PacienteService;
import com.dh.grupo7.pacientesMVCSpring.service.TurnoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@SpringBootApplication
public class PacientesMvcSpringApplication {
	//variables para iniciar la conexión con la base de datos
	private final static String DB_JDBC_DRIVER = "org.h2.Driver";
	private final static String DB_URL = "jdbc:h2:~/test";
	private final static String DB_USER = "sa";
	private final static String DB_PASSWORD = "";

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(PacientesMvcSpringApplication.class, args);
		crearTabla();

		PacienteDAOH2 PDAOH2=new PacienteDAOH2();
		PacienteService pacienteService=new PacienteService(PDAOH2);

		TurnoDAOH2 turnoDAOH2=new TurnoDAOH2();
		TurnoService turnoService=new TurnoService(turnoDAOH2);

		Turno turnoTest=new Turno(1L,1L, LocalDateTime.of(LocalDate.of(2022,05,12), LocalTime.of(12,00,00)));
		turnoService.darAlta(turnoTest);

		Domicilio domTest=new Domicilio("calleMain",222,"localidadMain", "provinciaMain");
		Paciente pacTest=new Paciente("aldana","gonzalez",22333444, LocalDate.of(2022,06,01),domTest,(long)0);
		pacienteService.darAlta(pacTest);
	}

	public static void crearTabla() throws SQLException {
		Connection con;
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		//Código para crear una tabla. Elimina la tabla si esta ya existe y la
		//vuelve a crear con datos de prueba
		String createSql = "DROP TABLE IF EXISTS PACIENTES;\n" +
				"DROP TABLE IF EXISTS DOMICILIOS;\n" +
				"DROP TABLE IF EXISTS ODONTOLOGOS;\n" +
				"DROP TABLE IF EXISTS TURNOS;\n" +
				"CREATE TABLE PACIENTES (ID LONG AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), DNI INT, FECHAINGRESO DATE, ID_ODONTOLOGO LONG);\n" +
				"CREATE TABLE DOMICILIOS (ID LONG AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(255), NUMERO INT, LOCALIDAD VARCHAR(255), PROVINCIA VARCHAR(255));\n" +
				"CREATE TABLE ODONTOLOGOS (ID LONG AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), MATRICULA VARCHAR(255));\n" +
				"CREATE TABLE TURNOS (ID LONG AUTO_INCREMENT PRIMARY KEY, id_paciente LONG, id_odontologo LONG, fechaYHora DATETIME);\n"+
				"INSERT INTO PACIENTES (nombre, apellido, dni, fechaingreso, id_odontologo) VALUES('fede', 'busta', '11222333', '2022-06-03', '1');\n" +
				"INSERT INTO ODONTOLOGOS (nombre, apellido, matricula) VALUES('mirta den', 'tista', 'M000001');\n" +
				"INSERT INTO TURNOS (id_paciente, id_odontologo, fechaYHora) VALUES('1', '1', '2022-06-20 13:00:00.000');\n" +
				"INSERT INTO DOMICILIOS (calle, numero, localidad, provincia) VALUES('Av. Siempreviva', '742', 'Springfield', 'Springfield');\n";
		try{
			Class.forName(DB_JDBC_DRIVER).newInstance();
			Statement stmt = con.createStatement();
			stmt.execute(createSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
