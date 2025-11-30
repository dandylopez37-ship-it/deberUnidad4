package uni1a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemporadaTest {
    private Temporada temporada;
    
    @BeforeEach
    void setUp() {
        temporada = new Temporada(1, 10, "2020");
    }
    
    @Test
    void testCreacionTemporada() {
        assertNotNull(temporada);
        assertEquals(1, temporada.getNumeroTemporada());
        assertEquals(10, temporada.getCantidadEpisodios());
        assertEquals("2020", temporada.getAnioEstreno());
    }
    
    @Test
    void testSetNumeroTemporada() {
        temporada.setNumeroTemporada(2);
        assertEquals(2, temporada.getNumeroTemporada());
    }
    
    @Test
    void testSetCantidadEpisodios() {
        temporada.setCantidadEpisodios(12);
        assertEquals(12, temporada.getCantidadEpisodios());
    }
    
    @Test
    void testSetAnioEstreno() {
        temporada.setAnioEstreno("2021");
        assertEquals("2021", temporada.getAnioEstreno());
    }
    
    @Test
    void testToString() {
        String resultado = temporada.toString();
        assertTrue(resultado.contains("Temporada 1"));
        assertTrue(resultado.contains("10"));
    }
}
