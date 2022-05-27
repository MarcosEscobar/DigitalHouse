import busqueda.*;

public class Turismo {
    public static void main(String[] args) {

        BusquedaHotel busquedaHotel = new BusquedaHotel();
        BusquedaVuelo busquedaVuelo = new BusquedaVuelo();
        FachadaBusqueda fachadaBusqueda;

        busquedaHotel.agregar(new Hotel("Hotel 1 Mza.", "01-01-2022", "15-01-2022", "Mendoza"));
        busquedaHotel.agregar(new Hotel("Hotel 2 Mza.", "01-01-2022", "15-01-2022", "Mendoza"));
        busquedaHotel.agregar(new Hotel("Hotel 1 Cba.", "01-01-2022", "15-01-2022", "Córdoba"));
        busquedaHotel.agregar(new Hotel("Hotel 2 Cba.", "01-01-2022", "15-01-2022", "Córdoba"));

        busquedaVuelo.agregar(new Vuelo("Aerolineas Argentinas", "01-01-2022", "15-01-2022", "CABA", "Mendoza"));
        busquedaVuelo.agregar(new Vuelo("FlyBondi", "01-01-2022", "15-01-2022", "CABA", "Mendoza"));
        busquedaVuelo.agregar(new Vuelo("Aerolineas Argentinas", "01-01-2022", "15-01-2022", "CABA", "Córdoba"));
        busquedaVuelo.agregar(new Vuelo("FlyBondi", "01-01-2022", "15-01-2022", "CABA", "Córdoba"));

        fachadaBusqueda = new FachadaBusqueda(busquedaVuelo, busquedaHotel);

        fachadaBusqueda.buscar("01-01-2022", "15-01-2022", "CABA", "Mendoza");
        fachadaBusqueda.buscar("01-01-2022", "15-01-2022", "CABA", "Córdoba");
    }
}
