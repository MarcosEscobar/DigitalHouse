package main;

import main.animales.Felino;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import main.animales.Leon;
import main.animales.Tigre;

public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();

        Tigre tiggerJr = null, tigger = null, pepe = null;
        Leon mufasa = null, simba = null, nala = null;

        try {
            tiggerJr = new Tigre("Tigger Jr", 5);
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (tiggerJr != null) {
                tiggerJr.correr();
                tiggerJr.esMayorA10();
            }
        }

        try {
            tigger = new Tigre("Tigger", 15);
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (tigger != null) {
                tigger.correr();
                tigger.esMayorA10();
            }
        }

        try {
            pepe = new Tigre("Pepe", -1);
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (pepe != null) {
                pepe.correr();
                pepe.esMayorA10();
            }
        }

        try {
            mufasa = new Leon("Mufasa", 20, true);
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (mufasa != null) {
                mufasa.correr();
                mufasa.esMayorA10();
            }
        }

        try {
            simba = new Leon("Simba", 7);
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (simba != null) {
                simba.correr();
                simba.esMayorA10();
            }
        }

        try {
            nala = new Leon("Nala", -10);
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (nala != null) {
                nala.correr();
                nala.esMayorA10();
            }
        }
    }
}
