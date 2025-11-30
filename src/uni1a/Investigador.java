package uni1a;

/**
 * Clase Investigador
 * Representa un investigador que participa en documentales
 */
public class Investigador {
    private String nombre;
    private String especialidad;
    private String institucion;

    public Investigador(String nombre, String especialidad, String institucion) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.institucion = institucion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public void mostrarInfo() {
        System.out.println("Investigador: " + nombre + ", Especialidad: " + especialidad + 
                         ", Institución: " + institucion);
    }

    @Override
    public String toString() {
        return nombre + " - " + especialidad;
    }
}
