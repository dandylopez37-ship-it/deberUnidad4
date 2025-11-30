package uni1a;

/**
 * Clase Actor
 * Representa un actor que puede participar en películas
 */
public class Actor {
    private String nombre;
    private String nacionalidad;
    private int edad;

    public Actor(String nombre, String nacionalidad, int edad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarInfo() {
        System.out.println("Actor: " + nombre + ", Nacionalidad: " + nacionalidad + ", Edad: " + edad);
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}
