package poo;

import uni1a.*;
import uni1a.modelo.CatalogoContenido;
import uni1a.servicio.*;
import java.util.List;

public class PruebaCSV {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE PERSISTENCIA CSV ===\n");
        
        CatalogoContenido catalogo = new CatalogoContenido();
        IArchivable<ContenidoAudiovisual> servicioCSV = new ContenidoAudiovisualCSV();
        
        // Crear contenidos de prueba
        Pelicula pelicula = new Pelicula("El Padrino", 175, "Drama", "Paramount");
        pelicula.agregarActor(new Actor("Marlon Brando", "Estadounidense", 80));
        pelicula.agregarActor(new Actor("Al Pacino", "Estadounidense", 84));
        
        SerieDeTV serie = new SerieDeTV("Stranger Things", 50, "Ciencia Ficcion", 4);
        serie.agregarTemporada(new Temporada(1, 8, "2016"));
        serie.agregarTemporada(new Temporada(2, 9, "2017"));
        
        Documental documental = new Documental("Nuestro Planeta", 50, "Naturaleza", "Ecosistemas");
        documental.setInvestigadorPrincipal(new Investigador("David Attenborough", "Biologia", "BBC"));
        
        catalogo.agregarContenido(pelicula);
        catalogo.agregarContenido(serie);
        catalogo.agregarContenido(documental);
        
        System.out.println("1. Guardando " + catalogo.obtenerCantidadTotal() + " contenidos en CSV...");
        servicioCSV.guardarEnArchivo(catalogo.obtenerTodos(), "test_contenidos.csv");
        System.out.println("   Archivo guardado: test_contenidos.csv\n");
        
        System.out.println("2. Limpiando catalogo...");
        catalogo.limpiarCatalogo();
        System.out.println("   Contenidos en catalogo: " + catalogo.obtenerCantidadTotal() + "\n");
        
        System.out.println("3. Cargando desde CSV...");
        List<ContenidoAudiovisual> cargados = servicioCSV.cargarDesdeArchivo("test_contenidos.csv");
        System.out.println("   Contenidos cargados: " + cargados.size() + "\n");
        
        for (ContenidoAudiovisual contenido : cargados) {
            catalogo.agregarContenido(contenido);
        }
        
        System.out.println("4. Mostrando contenidos cargados:\n");
        for (ContenidoAudiovisual contenido : catalogo.obtenerTodos()) {
            contenido.mostrarDetalles();
        }
        
        System.out.println("=== PRUEBA COMPLETADA EXITOSAMENTE ===");
    }
}
