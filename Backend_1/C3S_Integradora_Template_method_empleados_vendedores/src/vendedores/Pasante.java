package vendedores;

public class Pasante extends Vendedor {

    public Pasante(String nombre) {
        super(nombre);
    }

    @Override
    public void vender() {
        this.puntos += 5;
    }

    @Override
    public int calcularPuntos() {
        return this.puntos;
    }

    @Override
    public void recategorizar() {
        categoria = "pasante novato";
        if (50 <= puntos) {
            categoria = "pasante experimentado";
        }
    }
}
