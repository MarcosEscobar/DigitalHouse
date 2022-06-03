package cadena.comprobaciones;

import cadena.Articulo;

public class CompruebaCalidad {

    private Control controlInicial;

    public CompruebaCalidad() {
        Control controlFinal = new ControlEnvase();
        controlInicial = new ControlLote(new ControlPeso(controlFinal));

    }

    public void comprobar(Articulo a) {
        System.out.println("\nArticulo: " + a.getNombre());
        System.out.println(controlInicial.comprobar(a));
    }
}
