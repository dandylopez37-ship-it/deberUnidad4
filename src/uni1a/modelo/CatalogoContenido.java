package uni1a.modelo;

import uni1a.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoContenido {
    private List<ContenidoAudiovisual> contenidos;
    
    public CatalogoContenido() {
        this.contenidos = new ArrayList<>();
    }
    
    public void agregarContenido(ContenidoAudiovisual contenido) {
        if (contenido != null) {
            contenidos.add(contenido);
        }
    }
    
    public void eliminarContenido(int id) {
        contenidos.removeIf(c -> c.getId() == id);
    }
    
    public ContenidoAudiovisual buscarPorId(int id) {
        return contenidos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public List<ContenidoAudiovisual> buscarPorTitulo(String titulo) {
        return contenidos.stream()
                .filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    public List<ContenidoAudiovisual> buscarPorGenero(String genero) {
        return contenidos.stream()
                .filter(c -> c.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }
    
    public List<Pelicula> obtenerPeliculas() {
        return contenidos.stream()
                .filter(c -> c instanceof Pelicula)
                .map(c -> (Pelicula) c)
                .collect(Collectors.toList());
    }
    
    public List<SerieDeTV> obtenerSeries() {
        return contenidos.stream()
                .filter(c -> c instanceof SerieDeTV)
                .map(c -> (SerieDeTV) c)
                .collect(Collectors.toList());
    }
    
    public List<Documental> obtenerDocumentales() {
        return contenidos.stream()
                .filter(c -> c instanceof Documental)
                .map(c -> (Documental) c)
                .collect(Collectors.toList());
    }
    
    public List<ContenidoAudiovisual> obtenerTodos() {
        return new ArrayList<>(contenidos);
    }
    
    public void limpiarCatalogo() {
        contenidos.clear();
    }
    
    public int obtenerCantidadTotal() {
        return contenidos.size();
    }
}
