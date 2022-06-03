package spotify;

import spotify.descarga.ProxyDescarga;
import spotify.descarga.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario premium = new Usuario(666, "Premium");
        Usuario free = new Usuario(999, "Free");
        ProxyDescarga proxy = new ProxyDescarga();

        proxy.descargar(premium, "I Will Survive");
        proxy.descargar(free, "I Will Survive");
    }
}
