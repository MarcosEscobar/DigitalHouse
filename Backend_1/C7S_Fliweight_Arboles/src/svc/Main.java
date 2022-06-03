package svc;
import model.Bosque;
import svc.imp.arbolFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bosque bosque = new Bosque("bosque",1000000);
        arbolFactory AFactory = new arbolFactory();

        for (int i = 0; i < 500000; i++) {
            bosque.agregarArbol(AFactory.obtenerArbolDeFactory("rojo"));
            bosque.agregarArbol(AFactory.obtenerArbolDeFactory("verde"));
        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
        System.out.println("Tamaño del bosque: "+bosque.getSize()+" de árboles");
        System.out.println("Nombre del bosque: "+bosque.getNombre());
    }
}
