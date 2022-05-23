import java.util.Date;


class TarjetaTest {
    Tarjeta tDebito1 = new TarjetaDebito("0000111122223333", 012, new Date(22/12/2022), 500);
    Tarjeta tCredito1 = new TarjetaCredito("0000111122223333", 012, new Date(22/12/2022), 250, 1000);

    Tarjeta tDebitoVencida = new TarjetaDebito("0000111122223333", 012, new Date(22/12/2021), 500);
    Tarjeta tCreditoVencida = new TarjetaCredito("0000111122223333", 012, new Date(22/12/2021), 250, 1000);

    //@Test
    //public void siTarjetaVencida() {assertEquals("", tDebitoVencida.procesarPago(0))}


}