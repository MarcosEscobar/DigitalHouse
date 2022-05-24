import model.cancion;
import svc.imp.cancionFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        ArrayList<cancion> lista=new ArrayList<>();
        cancionFactory CFactory=new cancionFactory();
        String titulo;
        Scanner scanner=new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese el título de la canción");
            titulo=scanner.nextLine();
            lista.add(CFactory.obtenerCancionDeFactory(titulo));
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Lista de reproducción:");
        for (cancion c: lista) {
            c.obtenerCancion();
        }
    }
}
