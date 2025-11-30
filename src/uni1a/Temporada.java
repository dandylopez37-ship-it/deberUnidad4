package uni1a;

/**
 * Clase Temporada
 * Representa una temporada de una serie de TV con sus episodios
 */
public class Temporada {
    private int numeroTemporada;
    private int cantidadEpisodios;
    private String anioEstreno;

    public Temporada(int numeroTemporada, int cantidadEpisodios, String anioEstreno) {
        this.numeroTemporada = numeroTemporada;
        this.cantidadEpisodios = cantidadEpisodios;
        this.anioEstreno = anioEstreno;
    }

    // Getters y Setters
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }

    public void setCantidadEpisodios(int cantidadEpisodios) {
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public String getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(String anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public void mostrarInfo() {
        System.out.println("Temporada " + numeroTemporada + ": " + cantidadEpisodios + 
                         " episodios (" + anioEstreno + ")");
    }

    @Override
    public String toString() {
        return "Temporada " + numeroTemporada + " - " + cantidadEpisodios + " episodios";
    }
}
