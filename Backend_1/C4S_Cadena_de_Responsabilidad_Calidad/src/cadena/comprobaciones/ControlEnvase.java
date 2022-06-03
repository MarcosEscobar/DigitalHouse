package cadena.comprobaciones;

import cadena.Articulo;

public class ControlEnvase extends Control {

    public ControlEnvase() {
        super();
    }

    public ControlEnvase(Control siguienteControl) {
        super(siguienteControl);
    }

    @Override
    public String comprobar(Articulo a) {
        boolean esAceptable = (a.getEnvasado().equals("sano")) || (a.getEnvasado().equals("casi sano"));
        String resultadoControl = "Envasado: OK";

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
