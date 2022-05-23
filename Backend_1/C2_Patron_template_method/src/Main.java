import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Tarjeta tDebito = new TarjetaDebito("0000111122223333", 012, new Date(22/12/2022), 500);
        Tarjeta tCredito = new TarjetaCredito("0000111122223333", 012, new Date(22/12/2022), 250, 1000);

        tDebito.validarTarjeta(0);
        tCredito.validarTarjeta(23.50);
    }

}
