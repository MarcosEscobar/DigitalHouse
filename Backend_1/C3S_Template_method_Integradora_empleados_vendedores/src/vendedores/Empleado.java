package vendedores;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Empleado extends Vendedor {

    private List<Afiliado> afiliados = new ArrayList<>();
    private Year anioIngreso;

    public Empleado(String nombre, Year anioIngreso) {
        super(nombre);
        this.anioIngreso = anioIngreso;
    }

    public void conseguirAfiliado(Afiliado afiliado) {
        System.out.println(nombre + " está consiguiendo un afiliado...");
        System.out.println("¡" + afiliado.nombre + " es un nuevo afiliado!\n");
        this.afiliados.add(afiliado);
        this.puntos += 10;
    }

    @Override
    public void vender() {
        this.puntos += 5;
    }

    @Override
    public int calcularPuntos() {
        puntos += calcularAntiguedadEnAnios() * 5;
        return puntos;
    }

    @Override
    public void mostrarCategoria() {
        super.mostrarCategoria();
        System.out.println("--------------- Afiliados ---------------");
        for (Afiliado afiliado : afiliados) {
            afiliado.mostrarCategoria();
        }
        System.out.println("-----------------------------------------\n");
    }

    private int calcularAntiguedadEnAnios() {
        return Year.now().getValue() - anioIngreso.getValue();
    }
}
