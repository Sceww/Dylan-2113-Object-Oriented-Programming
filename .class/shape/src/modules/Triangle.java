package modules;
public class Triangle {
    private double base, height;
    private double sideA, sideB, sideC;

    public Triangle(double base, double height, double sideA, double sideB, double sideC) {
        this.base = base; this.height = height;
        this.sideA = sideA; this.sideB = sideB; this.sideC = sideC;
    }

    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }

    public void setBase(double base) {
        this.base = base;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

}