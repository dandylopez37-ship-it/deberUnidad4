package uni1a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeliculaTest {
    private Pelicula pelicula;
    
    @BeforeEach
    void setUp() {
        pelicula = new Pelicula("Avatar", 162, "Ciencia Ficcion", "20th Century Studios");
    }
    
    @Test
    void testCreacionPelicula() {
        assertNotNull(pelicula);
        assertEquals("Avatar", pelicula.getTitulo());
        assertEquals(162, pelicula.getDuracionEnMinutos());
        assertEquals("Ciencia Ficcion", pelicula.getGenero());
        assertEquals("20th Century Studios", pelicula.getEstudio());
    }
    
    @Test
    void testAgregarActor() {
        Actor actor = new Actor("Sam Worthington", "Britanico", 47);
        pelicula.agregarActor(actor);
        
        assertEquals(1, pelicula.getActores().size());
        assertTrue(pelicula.getActores().contains(actor));
    }
    
    @Test
    void testAgregarMultiplesActores() {
        Actor actor1 = new Actor("Sam Worthington", "Britanico", 47);
        Actor actor2 = new Actor("Zoe Saldana", "Estadounidense", 45);
        
        pelicula.agregarActor(actor1);
        pelicula.agregarActor(actor2);
        
        assertEquals(2, pelicula.getActores().size());
    }
    
    @Test
    void testEliminarActor() {
        Actor actor = new Actor("Sam Worthington", "Britanico", 47);
        pelicula.agregarActor(actor);
        pelicula.eliminarActor(actor);
        
        assertEquals(0, pelicula.getActores().size());
    }
    
    @Test
    void testSettersGetters() {
        pelicula.setTitulo("Avatar 2");
        pelicula.setDuracionEnMinutos(192);
        pelicula.setGenero("Aventura");
        pelicula.setEstudio("Disney");
        
        assertEquals("Avatar 2", pelicula.getTitulo());
        assertEquals(192, pelicula.getDuracionEnMinutos());
        assertEquals("Aventura", pelicula.getGenero());
        assertEquals("Disney", pelicula.getEstudio());
    }
}
