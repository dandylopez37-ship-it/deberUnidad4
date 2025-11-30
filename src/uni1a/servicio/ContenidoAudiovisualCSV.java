package uni1a.servicio;

import uni1a.*;
import java.io.*;
import java.util.*;

public class ContenidoAudiovisualCSV implements IArchivable<ContenidoAudiovisual> {
    
    private static final String SEPARADOR = ",";
    private static final String SEPARADOR_LISTA = ";";
    
    @Override
    public void guardarEnArchivo(List<ContenidoAudiovisual> contenidos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("tipo,id,titulo,duracion,genero,dato_especifico,datos_extra\n");
            
            for (ContenidoAudiovisual contenido : contenidos) {
                writer.write(convertirACSV(contenido));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
        }
    }
    
    @Override
    public List<ContenidoAudiovisual> cargarDesdeArchivo(String rutaArchivo) {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            reader.readLine(); // Saltar encabezado
            
            while ((linea = reader.readLine()) != null) {
                ContenidoAudiovisual contenido = parsearLinea(linea);
                if (contenido != null) {
                    contenidos.add(contenido);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar archivo: " + e.getMessage());
        }
        
        return contenidos;
    }
    
    private String convertirACSV(ContenidoAudiovisual contenido) {
        StringBuilder sb = new StringBuilder();
        
        if (contenido instanceof Pelicula) {
            Pelicula p = (Pelicula) contenido;
            sb.append("PELICULA").append(SEPARADOR);
            sb.append(p.getId()).append(SEPARADOR);
            sb.append(p.getTitulo()).append(SEPARADOR);
            sb.append(p.getDuracionEnMinutos()).append(SEPARADOR);
            sb.append(p.getGenero()).append(SEPARADOR);
            sb.append(p.getEstudio()).append(SEPARADOR);
            sb.append(convertirActores(p.getActores()));
            
        } else if (contenido instanceof SerieDeTV) {
            SerieDeTV s = (SerieDeTV) contenido;
            sb.append("SERIE").append(SEPARADOR);
            sb.append(s.getId()).append(SEPARADOR);
            sb.append(s.getTitulo()).append(SEPARADOR);
            sb.append(s.getDuracionEnMinutos()).append(SEPARADOR);
            sb.append(s.getGenero()).append(SEPARADOR);
            sb.append(s.getTemporadas()).append(SEPARADOR);
            sb.append(convertirTemporadas(s.getListaTemporadas()));
            
        } else if (contenido instanceof Documental) {
            Documental d = (Documental) contenido;
            sb.append("DOCUMENTAL").append(SEPARADOR);
            sb.append(d.getId()).append(SEPARADOR);
            sb.append(d.getTitulo()).append(SEPARADOR);
            sb.append(d.getDuracionEnMinutos()).append(SEPARADOR);
            sb.append(d.getGenero()).append(SEPARADOR);
            sb.append(d.getTema()).append(SEPARADOR);
            sb.append(convertirInvestigador(d.getInvestigadorPrincipal()));
        }
        
        return sb.toString();
    }
    
    private ContenidoAudiovisual parsearLinea(String linea) {
        String[] datos = linea.split(SEPARADOR, -1);
        
        if (datos.length < 6) return null;
        
        String tipo = datos[0];
        String titulo = datos[2];
        int duracion = Integer.parseInt(datos[3]);
        String genero = datos[4];
        String datoEspecifico = datos[5];
        String datosExtra = datos.length > 6 ? datos[6] : "";
        
        switch (tipo) {
            case "PELICULA":
                Pelicula pelicula = new Pelicula(titulo, duracion, genero, datoEspecifico);
                parsearActores(datosExtra, pelicula);
                return pelicula;
                
            case "SERIE":
                SerieDeTV serie = new SerieDeTV(titulo, duracion, genero, Integer.parseInt(datoEspecifico));
                parsearTemporadas(datosExtra, serie);
                return serie;
                
            case "DOCUMENTAL":
                Documental documental = new Documental(titulo, duracion, genero, datoEspecifico);
                parsearInvestigador(datosExtra, documental);
                return documental;
                
            default:
                return null;
        }
    }
    
    private String convertirActores(List<Actor> actores) {
        if (actores.isEmpty()) return "";
        
        StringBuilder sb = new StringBuilder();
        for (Actor actor : actores) {
            sb.append(actor.getNombre()).append("|");
            sb.append(actor.getNacionalidad()).append("|");
            sb.append(actor.getEdad()).append(SEPARADOR_LISTA);
        }
        return sb.toString();
    }
    
    private void parsearActores(String datosExtra, Pelicula pelicula) {
        if (datosExtra.isEmpty()) return;
        
        String[] actores = datosExtra.split(SEPARADOR_LISTA);
        for (String actorData : actores) {
            String[] datos = actorData.split("\\|");
            if (datos.length == 3) {
                pelicula.agregarActor(new Actor(datos[0], datos[1], Integer.parseInt(datos[2])));
            }
        }
    }
    
    private String convertirTemporadas(List<Temporada> temporadas) {
        if (temporadas.isEmpty()) return "";
        
        StringBuilder sb = new StringBuilder();
        for (Temporada temp : temporadas) {
            sb.append(temp.getNumeroTemporada()).append("|");
            sb.append(temp.getCantidadEpisodios()).append("|");
            sb.append(temp.getAnioEstreno()).append(SEPARADOR_LISTA);
        }
        return sb.toString();
    }
    
    private void parsearTemporadas(String datosExtra, SerieDeTV serie) {
        if (datosExtra.isEmpty()) return;
        
        String[] temporadas = datosExtra.split(SEPARADOR_LISTA);
        for (String tempData : temporadas) {
            String[] datos = tempData.split("\\|");
            if (datos.length == 3) {
                serie.agregarTemporada(new Temporada(Integer.parseInt(datos[0]), 
                                                     Integer.parseInt(datos[1]), 
                                                     datos[2]));
            }
        }
    }
    
    private String convertirInvestigador(Investigador investigador) {
        if (investigador == null) return "";
        
        return investigador.getNombre() + "|" + 
               investigador.getEspecialidad() + "|" + 
               investigador.getInstitucion();
    }
    
    private void parsearInvestigador(String datosExtra, Documental documental) {
        if (datosExtra.isEmpty()) return;
        
        String[] datos = datosExtra.split("\\|");
        if (datos.length == 3) {
            documental.setInvestigadorPrincipal(new Investigador(datos[0], datos[1], datos[2]));
        }
    }
}
