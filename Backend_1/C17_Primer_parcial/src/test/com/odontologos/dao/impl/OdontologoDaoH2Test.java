package test.com.odontologos.dao.impl;

import com.odontologos.dao.impl.OdontologoDaoH2;
import com.odontologos.model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDaoH2Test {
    private OdontologoDaoH2 odontologoDaoH2;

    //Reseteamos el Dao
    @BeforeEach
    public void reset() {
        odontologoDaoH2 = new OdontologoDaoH2();
    }
    //Seteamos algunos odontólogos
    Odontologo odontologo1 = new Odontologo(1L,"Mariano","Romero",12313);
    Odontologo odontologo2 = new Odontologo(2L,"Juan","Mendez",12313);
    Odontologo odontologo3 = new Odontologo(3L,"Pablo","Perez",14123);

    @Test
    public void guardar_registros() throws SQLException {
        odontologoDaoH2.guardar(odontologo1);
        odontologoDaoH2.guardar(odontologo2);
        odontologoDaoH2.guardar(odontologo3);
        assertEquals(1L,odontologo1.getId());
        assertEquals(2L,odontologo2.getId());
        assertEquals(3L,odontologo3.getId());
    }

    @Test
    void buscar_Existente() throws Exception {
        assertEquals(1L,odontologoDaoH2.buscar(odontologo1.getId()).getId());
    }

    @Test
    void listarTodos() throws SQLException {
        List<Odontologo> odontologos = odontologoDaoH2.listar();
        assertNotEquals(0, odontologos.size());
    }

    @Test
    void borrar_ID_inexistente() throws Exception {
        assertFalse(new OdontologoDaoH2().borrar(10L));
    }

    @Test
    void borrar_ID_existente() throws Exception {

        odontologoDaoH2.guardar(new Odontologo(10L,"Pepe","Juarez",123412));
        odontologoDaoH2.borrar(10L);
        Assertions.assertNull(odontologoDaoH2.buscar(10L).getId());

    }

}