package svc.imp;

import model.cancion;

import java.util.HashMap;
import java.util.Scanner;

public class cancionFactory {
    private HashMap<String, cancion> canciones=new HashMap();

    public cancion obtenerCancionDeFactory (String titulo){
        cancion c=canciones.get(titulo);
        if (c==null){
            Scanner s= new Scanner(System.in);
            String artista;
            String genero;
            System.out.println("Ingrese el nombre del artista");
            artista=s.nextLine();
            System.out.println("Ingrese el género de la canción");
            genero=s.nextLine();
            c=new cancion(titulo, artista, genero);
            canciones.put(titulo, c);
            System.out.println("Creando canción. Título: "+titulo+" , artista: "+artista+" , género: "+genero);
        }else{
            c.obtenerCancion();
        }
        return c;
    }
}
