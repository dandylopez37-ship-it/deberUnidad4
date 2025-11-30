package uni1a.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni1a.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CatalogoContenidoTest {
    private CatalogoContenido catalogo;
    private Pelicula pelicula;
    private SerieDeTV serie;
    private Documental documental;
    
    @BeforeEach
    void setUp() {
        catalogo = new CatalogoContenido();
        pelicula = new Pelicula("Avatar", 162, "Ciencia Ficcion", "20th Century");
        serie = new SerieDeTV("Breaking Bad", 45, "Drama", 5);
        documental = new Documental("Planeta Tierra", 50, "Naturaleza", "Vida Salvaje");
    }
    
    @Test
    void testAgregarContenido() {
        catalogo.agregarContenido(pelicula);
        assertEquals(1, catalogo.obtenerCantidadTotal());
    }
    
    @Test
    void testAgregarMultiplesContenidos() {
        catalogo.agregarContenido(pelicula);
        catalogo.agregarContenido(serie);
        catalogo.agregarContenido(documental);
        assertEquals(3, catalogo.obtenerCantidadTotal());
    }
    
    @Test
    void testEliminarContenido() {
        catalogo.agregarContenido(pelicula);
        int id = pelicula.getId();
        catalogo.eliminarContenido(id);
        assertEquals(0, catalogo.obtenerCantidadTotal());
    }
    
    @Test
    void testBuscarPorId() {
        catalogo.agregarContenido(pelicula);
        ContenidoAudiovisual encontrado = catalogo.buscarPorId(pelicula.getId());
        assertNotNull(encontrado);
        assertEquals("Avatar", encontrado.getTitulo());
    }
    
    @Test
    void testBuscarPorIdNoExistente() {
        ContenidoAudiovisual encontrado = catalogo.buscarPorId(999);
        assertNull(encontrado);
    }
    
    @Test
    void testBuscarPorTitulo() {
        catalogo.agregarContenido(pelicula);
        List<ContenidoAudiovisual> resultados = catalogo.buscarPorTitulo("Avatar");
        assertEquals(1, resultados.size());
    }
    
    @Test
    void testBuscarPorTituloParcial() {
        catalogo.agregarContenido(pelicula);
        List<ContenidoAudiovisual> resultados = catalogo.buscarPorTitulo("ava");
        assertEquals(1, resultados.size());
    }
    
    @Test
    void testBuscarPorGenero() {
        catalogo.agregarContenido(pelicula);
        catalogo.agregarContenido(serie);
        List<ContenidoAudiovisual> resultados = catalogo.buscarPorGenero("Drama");
        assertEquals(1, resultados.size());
    }
    
    @Test
    void testObtenerPeliculas() {
        catalogo.agregarContenido(pelicula);
        catalogo.agregarContenido(serie);
        List<Pelicula> peliculas = catalogo.obtenerPeliculas();
        assertEquals(1, peliculas.size());
    }
    
    @Test
    void testObtenerSeries() {
        catalogo.agregarContenido(pelicula);
        catalogo.agregarContenido(serie);
        List<SerieDeTV> series = catalogo.obtenerSeries();
        assertEquals(1, series.size());
    }
    
    @Test
    void testObtenerDocumentales() {
        catalogo.agregarContenido(documental);
        catalogo.agregarContenido(pelicula);
        List<Documental> documentales = catalogo.obtenerDocumentales();
        assertEquals(1, documentales.size());
    }
    
    @Test
    void testLimpiarCatalogo() {
        catalogo.agregarContenido(pelicula);
        catalogo.agregarContenido(serie);
        catalogo.limpiarCatalogo();
        assertEquals(0, catalogo.obtenerCantidadTotal());
    }
}
