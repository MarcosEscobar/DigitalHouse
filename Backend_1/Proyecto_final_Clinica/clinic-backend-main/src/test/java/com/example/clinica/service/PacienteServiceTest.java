package com.example.clinica.service;
import com.example.clinica.entities.Direccion;
import com.example.clinica.entities.PacienteDTO;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
    private static Logger logger = Logger.getLogger(Main.class);
    Direccion direccion = new Direccion("siempreviva","123","Springfield","Springfield");
    PacienteDTO paciente = new PacienteDTO("Homero", "Simpson","hsimpson@gmail.com",13412341234L,LocalDate.now(),direccion);

    @Autowired
    private PacienteService pacienteService;

    @Test
    public void test01_CrearPaciente() {
        pacienteService.crearPaciente(paciente);
        assertNotNull(pacienteService.buscarPacientesPorId(1L));
    }
    @Test
    public void test02_ListarPacientes(){
        pacienteService.crearPaciente(paciente);
        assertFalse(pacienteService.listarPacientes().size()==0);
    }
    @Test
    public void test03_actualizar() {
        PacienteDTO p = pacienteService.crearPaciente(paciente);
        PacienteDTO original = pacienteService.buscarPacientesPorId(p.getId());
        p.setNombre("Rigoberto");
        PacienteDTO actualizado = pacienteService.modificarPaciente(p);
        assertNotEquals(actualizado, original);
    }
}