package busqueda;

public class FachadaBusqueda implements IFachadaBusqueda {

    private BusquedaVuelo busquedaVuelo;
    private BusquedaHotel busquedaHotel;

    public FachadaBusqueda(BusquedaVuelo busquedaVuelo, BusquedaHotel busquedaHotel) {
        this.busquedaVuelo = busquedaVuelo;
        this.busquedaHotel = busquedaHotel;
    }

    @Override
    public void buscar(String fechaSalida, String fechaRegreso, String origen, String destino) {
        Vuelo vuelo = busquedaVuelo.buscar(fechaSalida, fechaRegreso, origen, destino);
        Hotel hotel = busquedaHotel.buscar(fechaSalida, fechaRegreso, destino);

        System.out.println("\n\nBuscando...");
        if (vuelo != null) {
            System.out.println("Vuelos");
            vuelo.mostrarInformacion();
        }
        if (hotel != null) {
            System.out.println("Hoteles");
            hotel.mostrarInformacion();
        }
    }
}
