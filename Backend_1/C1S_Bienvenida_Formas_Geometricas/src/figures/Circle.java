package figures;

public class Circle extends Figure {

    private double radio;

    public Circle(double radio) {
        if (radio < 0) {
            throw new ValueBelowZero();
        }
        this.radio = radio;
    }

    @Override
    public double perimeterCalc() {
        return 2 * Math.PI * radio;
    }
}
