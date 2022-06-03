import figures.Circle;
import figures.Figure;
import figures.Square;
import figures.ValueBelowZero;

import java.util.Scanner;

public class main {

    public static void main(String[] args){
        Figure figure;
        double length;
        Scanner scanner = new Scanner(System.in);

        System.out.println("What shape would you like to calc?");
        System.out.println("1. Circle");
        System.out.println("2. Square");
        int menu = scanner.nextInt();

        if (menu == 1){
            System.out.print("What is the radius of the circle?: ");
            try {
                figure = new Circle(scanner.nextDouble());
                System.out.println("The area of the circle is: ");
                System.out.printf("%.2f", figure.perimeterCalc());
            } catch (ValueBelowZero v) {
                System.out.println("No puedes ingresar valores menores a 0");
            }
        }
        if ( menu == 2){
            System.out.print("What is the length of the side of the square?: ");
            try {
                figure = new Square(scanner.nextDouble());
                System.out.println("The area of the circle is:");
                System.out.printf("%.2f", figure.perimeterCalc());
            } catch (ValueBelowZero e){
                System.out.println("No puedes ingresar valores menores a 0");
            }

        }

    }

}
