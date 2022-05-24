package svc;
import model.arbol;
import svc.imp.arbolFactory;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<arbol> bosque=new ArrayList<>();
        arbolFactory AFactory=new arbolFactory();

        for (int i = 0; i < 500000; i++) {
            bosque.add(AFactory.obtenerArbolDeFactory("rojo"));
            bosque.add(AFactory.obtenerArbolDeFactory("verde"));
        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
        System.out.println("Tamaño del bosque: "+bosque.size()+" de árboles");
    }
}
