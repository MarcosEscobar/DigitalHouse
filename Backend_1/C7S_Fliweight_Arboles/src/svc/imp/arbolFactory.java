package svc.imp;

import model.arbol;

import java.util.HashMap;

public class arbolFactory{
    private HashMap<String, arbol> arboles=new HashMap();

    public arbol obtenerArbolDeFactory(String color){
        arbol a=arboles.get(color);
        if (a==null){
            if (color.equals("rojo")){
                a=new arbol(500, 300, color, "Frutal");
                arboles.put(color, a);
            }else if (color.equals("verde")){
                a=new arbol(200, 400, color, "Ornamental");
                arboles.put(color, a);
            }
            System.out.println("Creando nuevo arbol. Tipo: "+a.getTipo()+", alto: "+a.getAlto()+", horizontal: "+a.getHorizontal()+", color: "+a.getColor());
        }else{
            a.obtenerArbol(color);
        }
        return a;
    }
}
