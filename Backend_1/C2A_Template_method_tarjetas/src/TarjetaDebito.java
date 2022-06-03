import java.util.Calendar;
import java.util.Date;

public class TarjetaDebito extends Tarjeta{
    public double saldoDisponible;

    public TarjetaDebito(String nrosFrente, Integer CVV, Date expiracion, double saldoDisponible) {
        super(nrosFrente, CVV, expiracion);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    protected void procesarPago(double Pago) {
        if (this.saldoDisponible >= Pago){
            System.out.println("La transacción fue exitosa.");
        }
        else {
            System.out.println("Salí de acá, pobre.");
        }
    }
}
