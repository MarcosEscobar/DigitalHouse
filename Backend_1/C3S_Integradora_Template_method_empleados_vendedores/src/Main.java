import vendedores.Afiliado;
import vendedores.Empleado;
import vendedores.Pasante;
import vendedores.Vendedor;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        Empleado pepa = new Empleado("Pepa", Year.of(2018));    // += 3 * 5 puntos
        Afiliado pepe = new Afiliado("Pepe");
        Afiliado pepo = new Afiliado("Pepo");
        Pasante pipo = new Pasante("Pipo");

        pepa.vender();  // += 5 puntos
        pepa.vender();  // += 5 puntos
        pepa.vender();  // += 5 puntos

        pepe.vender();  // += 15 puntos
        pepe.vender();  // += 15 puntos

        pepo.vender();  // += 15 puntos

        for (int i = 0; i < 12; i++) {
            pipo.vender();  // += 5 puntos
        }

        pepa.conseguirAfiliado(pepe);   // += 10
        pepa.conseguirAfiliado(pepo);   // += 10

        pepa.mostrarCategoria();
        pipo.mostrarCategoria();
    }
}
