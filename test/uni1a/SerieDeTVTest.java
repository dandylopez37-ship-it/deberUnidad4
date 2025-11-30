package uni1a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SerieDeTVTest {
    private SerieDeTV serie;
    
    @BeforeEach
    void setUp() {
        serie = new SerieDeTV("Game of Thrones", 60, "Fantasia", 8);
    }
    
    @Test
    void testCreacionSerie() {
        assertNotNull(serie);
        assertEquals("Game of Thrones", serie.getTitulo());
        assertEquals(60, serie.getDuracionEnMinutos());
        assertEquals("Fantasia", serie.getGenero());
        assertEquals(8, serie.getTemporadas());
    }
    
    @Test
    void testAgregarTemporada() {
        Temporada temp = new Temporada(1, 10, "2011");
        serie.agregarTemporada(temp);
        
        assertEquals(1, serie.getListaTemporadas().size());
        assertTrue(serie.getListaTemporadas().contains(temp));
    }
    
    @Test
    void testAgregarMultiplesTemporadas() {
        serie.agregarTemporada(new Temporada(1, 10, "2011"));
        serie.agregarTemporada(new Temporada(2, 10, "2012"));
        serie.agregarTemporada(new Temporada(3, 10, "2013"));
        
        assertEquals(3, serie.getListaTemporadas().size());
    }
    
    @Test
    void testSetTemporadas() {
        serie.setTemporadas(10);
        assertEquals(10, serie.getTemporadas());
    }
}
