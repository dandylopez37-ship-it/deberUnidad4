package uni1a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvestigadorTest {
    private Investigador investigador;
    
    @BeforeEach
    void setUp() {
        investigador = new Investigador("Carl Sagan", "Astronomia", "Universidad de Cornell");
    }
    
    @Test
    void testCreacionInvestigador() {
        assertNotNull(investigador);
        assertEquals("Carl Sagan", investigador.getNombre());
        assertEquals("Astronomia", investigador.getEspecialidad());
        assertEquals("Universidad de Cornell", investigador.getInstitucion());
    }
    
    @Test
    void testSetNombre() {
        investigador.setNombre("Stephen Hawking");
        assertEquals("Stephen Hawking", investigador.getNombre());
    }
    
    @Test
    void testSetEspecialidad() {
        investigador.setEspecialidad("Fisica Teorica");
        assertEquals("Fisica Teorica", investigador.getEspecialidad());
    }
    
    @Test
    void testSetInstitucion() {
        investigador.setInstitucion("Universidad de Cambridge");
        assertEquals("Universidad de Cambridge", investigador.getInstitucion());
    }
    
    @Test
    void testToString() {
        String resultado = investigador.toString();
        assertTrue(resultado.contains("Carl Sagan"));
        assertTrue(resultado.contains("Astronomia"));
    }
}
