import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


public abstract class Tarjeta {
    public String nrosFrente;
    public Integer CVV;
    public Date expiracion;
    private Calendar todayCalendar;
    public Date fechaActual = new Date(16/05/2022);

    public Tarjeta() {
    }

    public Tarjeta(String nrosFrente, Integer CVV, Date expiracion) {
        this.nrosFrente = nrosFrente;
        this.CVV = CVV;
        this.expiracion = expiracion;
        this.todayCalendar = todayCalendar;
        fechaActual = new Date(17/05/22);

    }

    public void validarTarjeta(double Pago) {
        System.out.println(fechaActual);
        System.out.println(expiracion);
        System.out.println();
        if (!fechaActual.after(expiracion)) {
            System.out.println("La tarjeta es inválida");
        } else {
            procesarPago(Pago);
        }
    }

    protected abstract void procesarPago(double Pago);



}
