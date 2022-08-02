package com.example.clinica.service;
import com.example.clinica.entities.Direccion;
import com.example.clinica.entities.OdontologoDTO;
import com.example.clinica.entities.OdontologoDTO;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    private static Logger logger = Logger.getLogger(Main.class);
    Direccion direccion = new Direccion("siempreviva","123","Springfield","Springfield");
    OdontologoDTO odontologo = new OdontologoDTO("Homero","Simpson","A3321");

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void test01_CrearPaciente() {
        odontologoService.crearOdontologo(odontologo);
        assertNotNull(odontologoService.buscarOdontologoPorId(1L));
    }
    @Test
    public void test02_ListarPacientes(){
        odontologoService.crearOdontologo(odontologo);
        assertFalse(odontologoService.listarOdontologos().size()==0);
    }
    @Test
    public void test03_actualizar() {
        OdontologoDTO p = odontologoService.crearOdontologo(odontologo);
        OdontologoDTO original = odontologoService.buscarOdontologoPorId(p.getId());
        p.setNombre("Rigoberto");
        OdontologoDTO actualizado = odontologoService.modificarOdontologo(p);
        assertNotEquals(actualizado, original);
    }
}