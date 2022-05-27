package busqueda;

import java.util.Objects;

public class Vuelo {

    private String nombre;
    private String fechaSalida;
    private String fechaRegreso;
    private String origen;
    private String destino;

    public Vuelo(String fechaSalida, String fechaRegreso, String origen, String destino) {
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.origen = origen;
        this.destino = destino;
    }

    public Vuelo(String nombre, String fechaSalida, String fechaRegreso, String origen, String destino) {
        this.nombre = nombre;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.origen = origen;
        this.destino = destino;
    }

    public void mostrarInformacion() {
        System.out.println(nombre);
        System.out.println("\tFecha salida:\t" + fechaSalida +
                           "\n\tFecha regreso:\t" + fechaRegreso +
                           "\n\tOrigen:\t" + origen +
                           "\n\tDestino:\t" + destino);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return fechaSalida.equals(vuelo.fechaSalida) && fechaRegreso.equals(vuelo.fechaRegreso) && origen.equals(vuelo.origen) && destino.equals(vuelo.destino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaSalida, fechaRegreso, origen, destino);
    }
}
