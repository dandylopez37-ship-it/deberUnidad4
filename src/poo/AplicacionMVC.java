package poo;

import uni1a.controlador.ControladorContenido;
import uni1a.modelo.CatalogoContenido;
import uni1a.vista.VistaConsola;

public class AplicacionMVC {
    public static void main(String[] args) {
        CatalogoContenido catalogo = new CatalogoContenido();
        VistaConsola vista = new VistaConsola();
        ControladorContenido controlador = new ControladorContenido(catalogo, vista);
        
        controlador.iniciar();
        vista.cerrar();
    }
}
