import cadena.Articulo;
import cadena.comprobaciones.CompruebaCalidad;

public class Main {
    public static void main(String[] args) {
        Articulo gaseosa = new Articulo("Gaseosa", 2600, 1400, "no sano");
        Articulo bananas = new Articulo("Bananas", 1100, 2000, "sano");
        Articulo alfajores = new Articulo("Alfajores", 1200, 1250, "no sano");
        Articulo espinaca = new Articulo("Espinaca", 1800, 1250, "sano");
        CompruebaCalidad departamentoDeCalidad = new CompruebaCalidad();

        departamentoDeCalidad.comprobar(gaseosa);
        departamentoDeCalidad.comprobar(bananas);
        departamentoDeCalidad.comprobar(alfajores);
        departamentoDeCalidad.comprobar(espinaca);
    }
}
