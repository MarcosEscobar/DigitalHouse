package busqueda;

import java.util.ArrayList;

public class Buscador {
    public static Object buscar(ArrayList lista, Object objetoBuscado) {
        Object objeto = null;
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < lista.size()) {
            if (lista.get(i).equals(objetoBuscado)) {
                objeto = lista.get(i);
                encontrado = true;
            }
            i++;
        }
        return objeto;
    }
}