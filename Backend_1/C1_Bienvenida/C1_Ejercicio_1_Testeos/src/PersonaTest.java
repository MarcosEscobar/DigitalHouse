import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    Persona persona1 = new Persona("Marcos", "Escobar", "mescobar@gmail.com", 33);
    Persona persona2 = new Persona("Juan","Perez", "jperez@gg.com", 15);

    @Test
    public void siNombreEsCorrecto(){
        assertEquals("Marcos Escobar", persona1.getNombreCompleto());
    }

    @Test
    public void siEsMayor(){
        assertTrue(persona1.esMayor());
        assertFalse(persona2.esMayor());
    }
}