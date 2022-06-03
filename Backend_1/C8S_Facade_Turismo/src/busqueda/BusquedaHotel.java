package busqueda;

import java.util.ArrayList;

public class BusquedaHotel {

    ArrayList<Hotel> hoteles = new ArrayList<>();

    public void agregar(Hotel hotel) {
        this.hoteles.add(hotel);
    }

    public Hotel buscar(String fechaSalida, String fechaRegreso, String destino) {
        Hotel buscado = new Hotel(fechaSalida, fechaRegreso, destino);
        return (Hotel) Buscador.buscar(this.hoteles, buscado);
    }
}
