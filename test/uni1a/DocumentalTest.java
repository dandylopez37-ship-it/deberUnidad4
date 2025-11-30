package uni1a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DocumentalTest {
    private Documental documental;
    
    @BeforeEach
    void setUp() {
        documental = new Documental("Cosmos", 45, "Ciencia", "Astronomia");
    }
    
    @Test
    void testCreacionDocumental() {
        assertNotNull(documental);
        assertEquals("Cosmos", documental.getTitulo());
        assertEquals(45, documental.getDuracionEnMinutos());
        assertEquals("Ciencia", documental.getGenero());
        assertEquals("Astronomia", documental.getTema());
    }
    
    @Test
    void testSetInvestigadorPrincipal() {
        Investigador inv = new Investigador("Neil deGrasse Tyson", "Astrofisica", "Planetario Hayden");
        documental.setInvestigadorPrincipal(inv);
        
        assertNotNull(documental.getInvestigadorPrincipal());
        assertEquals("Neil deGrasse Tyson", documental.getInvestigadorPrincipal().getNombre());
    }
    
    @Test
    void testInvestigadorInicialmenteNulo() {
        assertNull(documental.getInvestigadorPrincipal());
    }
    
    @Test
    void testSetTema() {
        documental.setTema("Fisica Cuantica");
        assertEquals("Fisica Cuantica", documental.getTema());
    }
}
