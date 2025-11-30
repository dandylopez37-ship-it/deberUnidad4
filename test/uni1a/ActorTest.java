package uni1a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActorTest {
    private Actor actor;
    
    @BeforeEach
    void setUp() {
        actor = new Actor("Leonardo DiCaprio", "Estadounidense", 49);
    }
    
    @Test
    void testCreacionActor() {
        assertNotNull(actor);
        assertEquals("Leonardo DiCaprio", actor.getNombre());
        assertEquals("Estadounidense", actor.getNacionalidad());
        assertEquals(49, actor.getEdad());
    }
    
    @Test
    void testSetNombre() {
        actor.setNombre("Brad Pitt");
        assertEquals("Brad Pitt", actor.getNombre());
    }
    
    @Test
    void testSetNacionalidad() {
        actor.setNacionalidad("Britanico");
        assertEquals("Britanico", actor.getNacionalidad());
    }
    
    @Test
    void testSetEdad() {
        actor.setEdad(50);
        assertEquals(50, actor.getEdad());
    }
    
    @Test
    void testToString() {
        String resultado = actor.toString();
        assertTrue(resultado.contains("Leonardo DiCaprio"));
        assertTrue(resultado.contains("Estadounidense"));
    }
}
