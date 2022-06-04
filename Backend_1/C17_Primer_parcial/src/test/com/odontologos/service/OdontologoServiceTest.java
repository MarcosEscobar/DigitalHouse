package test.com.odontologos.service;

import com.odontologos.dao.impl.OdontologoDaoH2;
import com.odontologos.model.Odontologo;
import com.odontologos.service.OdontologoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.List;

public class OdontologoServiceTest {
    private static final OdontologoService service = new OdontologoService(new OdontologoDaoH2());

    Odontologo odontologo1 = new Odontologo(1L,"Mariano","Romero",12313);
    Odontologo odontologo2 = new Odontologo(2L,"Juan","Mendez",12313);
    Odontologo odontologo3 = new Odontologo(3L,"Pablo","Perez",14123);

    @Test
    void guardar() throws SQLException {
        service.guardar(odontologo1);
        service.guardar(odontologo2);
        service.guardar(odontologo3);
        assertEquals("Mariano",odontologo1.getNombre());
        assertEquals(12313,odontologo2.getMatricula());
        assertEquals("Perez",odontologo3.getApellido());
        assertTrue(service.listar().size()>0);
    }

    @Test
    void buscar() throws Exception{
        service.guardar(odontologo1);
        assertTrue(service.buscar(odontologo1.getId()).getId() == odontologo1.getId());
    }

    @Test
    void borrar() throws Exception{
        service.borrar(odontologo1.getId());
        assertNull(service.buscar(odontologo1.getId()).getId());
    }

    @Test
    void listar() throws SQLException {
        List<Odontologo> odontologos = service.listar();
        assertTrue(odontologos.size()>0);
    }
}
