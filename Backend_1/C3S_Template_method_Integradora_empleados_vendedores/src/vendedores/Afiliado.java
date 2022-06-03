package vendedores;

public class Afiliado extends Vendedor {

    public Afiliado(String nombre) {
        super(nombre);
    }

    @Override
    public void vender() {
        this.puntos += 15;
    }

    @Override
    public int calcularPuntos() {
        return this.puntos;
    }
}
