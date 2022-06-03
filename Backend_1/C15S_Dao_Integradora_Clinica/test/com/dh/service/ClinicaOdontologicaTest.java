package com.dh.service;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.model.entidades.Domicilio;
import com.dh.model.entidades.Paciente;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClinicaOdontologicaTest {

    private ClinicaOdontologica clinicaOdontologica = new ClinicaOdontologica();

    public ClinicaOdontologicaTest() throws Exception {}

    @AfterEach
    public void reset() throws Exception {
        clinicaOdontologica = new ClinicaOdontologica(new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql';", "sa", ""));
    }

    @BeforeAll
    public static void init() {
        PropertyConfigurator.configure("log4j.properties");
    }

    @Test
    public void test01DarDeAltaPacienteConDomicilioID() {
        Paciente paciente = new Paciente("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), new Domicilio(1));
        String respuestaEsperada = "El paciente " + paciente + " fue dado de alta con éxito";

        String respuesta = clinicaOdontologica.darDeAltaPaciente("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), 1);

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void test02DarDeAltaPacienteConTodosLosDatos() {
        Domicilio domicilio = new Domicilio("Calle Falsa", 123, "Springfield", "Springfield");
        Paciente paciente = new Paciente("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), domicilio);
        String respuestaEsperada = "El paciente " + paciente + " fue dado de alta con éxito";

        String respuesta = clinicaOdontologica.darDeAltaPaciente("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), "Calle Falsa", 123, "Springfield", "Springfield");

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void test03NoSePuedeDarDeAltaPacienteSiAlgunCampoEsNull() {
        String respuestaEsperada = "No se pudo dar de alta el paciente";

        String respuesta = clinicaOdontologica.darDeAltaPaciente(null, "Pepardo", 123456789, Date.valueOf("2021-08-26"), null);

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void test04NoSePuedeDarDeBajaPacienteInexistenteEnBD() {
        String respuestaEsperada = "No se pudo dar de baja el paciente";

        String respuesta = clinicaOdontologica.darDeBajaPaciente(1);

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void test05NoSePuedeActualizarDatosDeUnPacienteInexistenteEnBD() {
        String respuestaEsperada = "Paciente con ID: 13 no encontrado";

        String respuesta = clinicaOdontologica.actualizarPaciente(13, "Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), 1);

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void test06DarDeBajaPaciente() {
        String respuestaEsperada = "El paciente con ID: 1 se borró con éxito";
        clinicaOdontologica.darDeAltaPaciente("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), "Calle Falsa", 123, "Springfield", "Springfield");

        String respuesta = clinicaOdontologica.darDeBajaPaciente(1);

        assertEquals(respuestaEsperada, respuesta);
    }


    @Test
    public void test07ActualizarDatosPaciente() {
        clinicaOdontologica.darDeAltaPaciente("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), "Calle Falsa", 123, "Springfield", "Springfield");
        Paciente pacienteActualizado = new Paciente("Pepa", "Peparda", 987654321, Date.valueOf("2021-08-23"), new Domicilio("Calle Falsa", 123, "Springfield", "Springfield"));
        String respuestaEsperada = "Los nuevos datos son:\n" + pacienteActualizado;

        String respuesta = clinicaOdontologica.actualizarPaciente(1, "Pepa", "Peparda", 987654321, Date.valueOf("2021-08-23"), 1);

        assertEquals(respuestaEsperada, respuesta);
    }
}
