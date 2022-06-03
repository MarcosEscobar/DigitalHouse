package cadena.comprobaciones;

import cadena.Articulo;

public abstract class Control {

    protected Control siguienteControl;

    public Control() {
        siguienteControl = null;
    }

    public Control(Control siguienteControl) {
        this.siguienteControl = siguienteControl;
    }

    public abstract String comprobar(Articulo articulo);
}
