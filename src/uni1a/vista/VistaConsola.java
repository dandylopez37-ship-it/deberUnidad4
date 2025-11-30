package uni1a.vista;

import uni1a.*;
import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;
    
    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE GESTION DE CONTENIDOS AUDIOVISUALES ===");
        System.out.println("1. Agregar contenido");
        System.out.println("2. Listar todos los contenidos");
        System.out.println("3. Buscar por titulo");
        System.out.println("4. Buscar por genero");
        System.out.println("5. Eliminar contenido");
        System.out.println("6. Guardar en archivo");
        System.out.println("7. Cargar desde archivo");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    public void mostrarMenuTipoContenido() {
        System.out.println("\n--- Tipo de Contenido ---");
        System.out.println("1. Pelicula");
        System.out.println("2. Serie de TV");
        System.out.println("3. Documental");
        System.out.print("Seleccione tipo: ");
    }
    
    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }
    
    public void mostrarContenidos(List<ContenidoAudiovisual> contenidos) {
        if (contenidos.isEmpty()) {
            System.out.println("\nNo hay contenidos para mostrar.");
            return;
        }
        
        System.out.println("\n=== LISTA DE CONTENIDOS ===");
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }
    
    public void mostrarDetalleContenido(ContenidoAudiovisual contenido) {
        if (contenido == null) {
            System.out.println("Contenido no encontrado.");
            return;
        }
        contenido.mostrarDetalles();
    }
    
    public boolean confirmarAccion(String mensaje) {
        System.out.print(mensaje + " (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta.equals("S");
    }
    
    public void cerrar() {
        scanner.close();
    }
}
