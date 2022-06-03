package figures;

public class Square extends Figure {

    private double side;

    public Square(double side) {
        if (side < 0) {
            throw new ValueBelowZero();
        }
        this.side = side;
    }

    @Override
    public double perimeterCalc() {
        return side * 4;
    }
}
