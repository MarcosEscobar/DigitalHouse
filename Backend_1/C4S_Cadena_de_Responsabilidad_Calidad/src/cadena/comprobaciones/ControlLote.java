package cadena.comprobaciones;

import cadena.Articulo;

public class ControlLote extends Control {


    public ControlLote(Control siguienteControl) {
        super(siguienteControl);
    }

    @Override
    public String comprobar(Articulo a) {
        boolean esAceptable = (a.getLote() >= 1000) && (a.getLote() <= 2000);
        String resultadoControl = "Lote: OK";

        if (esAceptable) {
            System.out.println(resultadoControl);
            if (this.siguienteControl != null) {
                resultadoControl = this.siguienteControl.comprobar(a);
            }
        } else {
            resultadoControl = "El lote es incorrecto";
        }
        return resultadoControl;
    }
}
