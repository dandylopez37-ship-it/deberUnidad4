package uni1a.servicio;

import java.util.List;

public interface IArchivable<T> {
    void guardarEnArchivo(List<T> elementos, String rutaArchivo);
    List<T> cargarDesdeArchivo(String rutaArchivo);
}
