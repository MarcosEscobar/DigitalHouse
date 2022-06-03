package tests;

import figures.Circle;
import figures.Figure;
import figures.ValueBelowZero;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    private Figure circle;

    @Test
    public void T01_Create_circle_with_radio_0() {
        circle = new Circle(0);
        assertEquals(0.0, circle.perimeterCalc());
    }
    @Test
    public void T02_Create_circle_with_positive_value() {
        circle = new Circle(10);
        double perimeterExpected = 2 * Math.PI * 10;
        assertEquals(perimeterExpected, circle.perimeterCalc());
    }

    @Test
    public void T03_Create_circle_with_negative_value() {
        assertThrows(ValueBelowZero.class, () -> {
           new Circle(-1);
        });
    }
}