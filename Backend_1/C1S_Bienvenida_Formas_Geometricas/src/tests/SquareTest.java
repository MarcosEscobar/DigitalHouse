package tests;

import figures.Figure;
import figures.Square;
import figures.ValueBelowZero;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {

    private Figure square;

    @Test
    public void T01_Square_with_perimeter_0() {
        square = new Square(0);
        assertEquals(0.0, square.perimeterCalc());
    }
    @Test
    public void T02_Square_with_perimeter_positive() {
        square = new Square(5);
        assertEquals(20.0, square.perimeterCalc());
    }

    @Test
    public void T03_Square_with_perimeter_negative() {
        assertThrows(ValueBelowZero.class, () -> {
            new Square(-10);
        });
    }
}