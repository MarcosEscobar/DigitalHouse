package model;
import svc.ICancion;

public class cancion implements ICancion {
    private String nombre;
    private String artista;
    private String genero;

    public cancion(String nombre, String artista, String genero) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
    }

    @Override
    public void obtenerCancion() {
        System.out.println("Título: "+this.nombre+" , artista: "+this.artista+" , género: "+this.genero);
    }
}
