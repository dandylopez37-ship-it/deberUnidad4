package poo;
import uni1a.*;

public class PruebaAudioVisual {
	public static void main(String[] args) {
        System.out.println("=== Sistema de Gesti\u00f3n de Contenidos Audiovisuales ===\n");

        // Crear instancias de las subclases con sus relaciones
        
        // 1. Pel\u00edcula con actores (Asociaci\u00f3n)
        Pelicula pelicula = new Pelicula("Avatar", 162, "Ciencia Ficci\u00f3n", "20th Century Studios");
        pelicula.agregarActor(new Actor("Sam Worthington", "Brit\u00e1nico", 47));
        pelicula.agregarActor(new Actor("Zoe Salda\u00f1a", "Estadounidense", 45));
        pelicula.agregarActor(new Actor("Sigourney Weaver", "Estadounidense", 74));
        
        // 2. Serie de TV con temporadas (Composici\u00f3n)
        SerieDeTV serie = new SerieDeTV("Game of Thrones", 60, "Fantas\u00eda", 8);
        serie.agregarTemporada(new Temporada(1, 10, "2011"));
        serie.agregarTemporada(new Temporada(2, 10, "2012"));
        serie.agregarTemporada(new Temporada(3, 10, "2013"));
        serie.agregarTemporada(new Temporada(4, 10, "2014"));
        serie.agregarTemporada(new Temporada(5, 10, "2015"));
        serie.agregarTemporada(new Temporada(6, 10, "2016"));
        serie.agregarTemporada(new Temporada(7, 7, "2017"));
        serie.agregarTemporada(new Temporada(8, 6, "2019"));
        
        // 3. Documental con investigador (Asociaci\u00f3n)
        Documental documental = new Documental("Cosmos", 45, "Ciencia", "Astronom\u00eda");
        documental.setInvestigadorPrincipal(new Investigador("Neil deGrasse Tyson", 
                                                             "Astrof\u00edsica", 
                                                             "Planetario Hayden"));
        
        // Array de contenidos audiovisuales
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[3];
        contenidos[0] = pelicula;
        contenidos[1] = serie;
        contenidos[2] = documental;

        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
        
        System.out.println("=== Fin del sistema ===");
    }
}