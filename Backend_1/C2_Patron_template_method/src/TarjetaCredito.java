import java.util.Calendar;
import java.util.Date;

public class TarjetaCredito extends Tarjeta {
    public double saldoUtilizado;
    public double limite;

    public TarjetaCredito(String nrosFrente, Integer CVV, Date expiracion,  double saldoUtilizado, double limite) {
        super(nrosFrente, CVV, expiracion);
        this.saldoUtilizado = saldoUtilizado;
        this.limite = limite;
    }

    @Override
    protected void procesarPago(double Pago) {
        if ( (limite - saldoUtilizado) >= Pago){
            System.out.println("La transacción fue exitosa.");
        }
        else {
            System.out.println("Salí de acá, pobre.");
        }
    }
}
