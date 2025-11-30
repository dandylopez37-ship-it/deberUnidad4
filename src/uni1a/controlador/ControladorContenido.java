package uni1a.controlador;

import uni1a.*;
import uni1a.modelo.CatalogoContenido;
import uni1a.servicio.*;
import uni1a.vista.VistaConsola;
import java.util.List;

public class ControladorContenido {
    private CatalogoContenido catalogo;
    private VistaConsola vista;
    private IArchivable<ContenidoAudiovisual> servicioArchivo;
    
    private static final String RUTA_ARCHIVO = "contenidos.csv";
    
    public ControladorContenido(CatalogoContenido catalogo, VistaConsola vista) {
        this.catalogo = catalogo;
        this.vista = vista;
        this.servicioArchivo = new ContenidoAudiovisualCSV();
    }
    
    public void iniciar() {
        boolean continuar = true;
        
        while (continuar) {
            vista.mostrarMenuPrincipal();
            int opcion = vista.leerOpcion();
            
            switch (opcion) {
                case 1:
                    agregarContenido();
                    break;
                case 2:
                    listarContenidos();
                    break;
                case 3:
                    buscarPorTitulo();
                    break;
                case 4:
                    buscarPorGenero();
                    break;
                case 5:
                    eliminarContenido();
                    break;
                case 6:
                    guardarEnArchivo();
                    break;
                case 7:
                    cargarDesdeArchivo();
                    break;
                case 8:
                    continuar = false;
                    vista.mostrarMensaje("Gracias por usar el sistema.");
                    break;
                default:
                    vista.mostrarError("Opcion no valida.");
            }
        }
    }
    
    private void agregarContenido() {
        vista.mostrarMenuTipoContenido();
        int tipo = vista.leerOpcion();
        
        String titulo = vista.leerTexto("Titulo: ");
        int duracion = vista.leerEntero("Duracion (minutos): ");
        String genero = vista.leerTexto("Genero: ");
        
        ContenidoAudiovisual contenido = null;
        
        switch (tipo) {
            case 1:
                contenido = crearPelicula(titulo, duracion, genero);
                break;
            case 2:
                contenido = crearSerie(titulo, duracion, genero);
                break;
            case 3:
                contenido = crearDocumental(titulo, duracion, genero);
                break;
            default:
                vista.mostrarError("Tipo no valido.");
                return;
        }
        
        if (contenido != null) {
            catalogo.agregarContenido(contenido);
            vista.mostrarMensaje("Contenido agregado exitosamente.");
        }
    }
    
    private Pelicula crearPelicula(String titulo, int duracion, String genero) {
        String estudio = vista.leerTexto("Estudio: ");
        Pelicula pelicula = new Pelicula(titulo, duracion, genero, estudio);
        
        if (vista.confirmarAccion("Desea agregar actores?")) {
            int cantActores = vista.leerEntero("Cuantos actores?: ");
            for (int i = 0; i < cantActores; i++) {
                String nombre = vista.leerTexto("Nombre del actor " + (i+1) + ": ");
                String nacionalidad = vista.leerTexto("Nacionalidad: ");
                int edad = vista.leerEntero("Edad: ");
                pelicula.agregarActor(new Actor(nombre, nacionalidad, edad));
            }
        }
        
        return pelicula;
    }
    
    private SerieDeTV crearSerie(String titulo, int duracion, String genero) {
        int numTemporadas = vista.leerEntero("Numero de temporadas: ");
        SerieDeTV serie = new SerieDeTV(titulo, duracion, genero, numTemporadas);
        
        if (vista.confirmarAccion("Desea agregar detalle de temporadas?")) {
            for (int i = 1; i <= numTemporadas; i++) {
                int episodios = vista.leerEntero("Episodios temporada " + i + ": ");
                String anio = vista.leerTexto("Anio de estreno: ");
                serie.agregarTemporada(new Temporada(i, episodios, anio));
            }
        }
        
        return serie;
    }
    
    private Documental crearDocumental(String titulo, int duracion, String genero) {
        String tema = vista.leerTexto("Tema: ");
        Documental documental = new Documental(titulo, duracion, genero, tema);
        
        if (vista.confirmarAccion("Desea agregar investigador principal?")) {
            String nombre = vista.leerTexto("Nombre del investigador: ");
            String especialidad = vista.leerTexto("Especialidad: ");
            String institucion = vista.leerTexto("Institucion: ");
            documental.setInvestigadorPrincipal(new Investigador(nombre, especialidad, institucion));
        }
        
        return documental;
    }
    
    private void listarContenidos() {
        List<ContenidoAudiovisual> contenidos = catalogo.obtenerTodos();
        vista.mostrarContenidos(contenidos);
        vista.mostrarMensaje("Total: " + contenidos.size() + " contenidos");
    }
    
    private void buscarPorTitulo() {
        String titulo = vista.leerTexto("Ingrese titulo a buscar: ");
        List<ContenidoAudiovisual> resultados = catalogo.buscarPorTitulo(titulo);
        vista.mostrarContenidos(resultados);
    }
    
    private void buscarPorGenero() {
        String genero = vista.leerTexto("Ingrese genero a buscar: ");
        List<ContenidoAudiovisual> resultados = catalogo.buscarPorGenero(genero);
        vista.mostrarContenidos(resultados);
    }
    
    private void eliminarContenido() {
        int id = vista.leerEntero("Ingrese ID del contenido a eliminar: ");
        ContenidoAudiovisual contenido = catalogo.buscarPorId(id);
        
        if (contenido == null) {
            vista.mostrarError("Contenido no encontrado.");
            return;
        }
        
        vista.mostrarDetalleContenido(contenido);
        if (vista.confirmarAccion("Esta seguro de eliminar este contenido?")) {
            catalogo.eliminarContenido(id);
            vista.mostrarMensaje("Contenido eliminado exitosamente.");
        }
    }
    
    private void guardarEnArchivo() {
        List<ContenidoAudiovisual> contenidos = catalogo.obtenerTodos();
        if (contenidos.isEmpty()) {
            vista.mostrarError("No hay contenidos para guardar.");
            return;
        }
        
        servicioArchivo.guardarEnArchivo(contenidos, RUTA_ARCHIVO);
        vista.mostrarMensaje("Datos guardados en " + RUTA_ARCHIVO);
    }
    
    private void cargarDesdeArchivo() {
        List<ContenidoAudiovisual> contenidos = servicioArchivo.cargarDesdeArchivo(RUTA_ARCHIVO);
        
        if (contenidos.isEmpty()) {
            vista.mostrarError("No se pudieron cargar datos del archivo.");
            return;
        }
        
        catalogo.limpiarCatalogo();
        for (ContenidoAudiovisual contenido : contenidos) {
            catalogo.agregarContenido(contenido);
        }
        
        vista.mostrarMensaje("Cargados " + contenidos.size() + " contenidos desde " + RUTA_ARCHIVO);
    }
}
