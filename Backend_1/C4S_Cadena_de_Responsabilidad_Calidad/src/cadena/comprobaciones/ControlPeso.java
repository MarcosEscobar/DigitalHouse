package cadena.comprobaciones;

import cadena.Articulo;

public class ControlPeso extends Control {


    public ControlPeso(Control siguienteControl) {
        super(siguienteControl);
    }

    @Override
    public String comprobar(Articulo a) {
        boolean esAceptable = (a.getPeso() >= 1200) && (a.getPeso() <= 1300);
        String resultadoControl = "Peso: OK";

        if (esAceptable) {
            System.out.println(resultadoControl);
            if (this.siguienteControl != null) {
                resultadoControl = this.siguienteControl.comprobar(a);
            }
        } else {
            resultadoControl = "El peso es incorrecto";
        }
        return resultadoControl;
    }
}
