package modules;
public class Rectangle {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length; 
    }
    public void setWidth(double width) {
        this.width = width; 
    }

    public double getArea() {
        return width * length;
    }
    public double getPerimeter() {
        return (2*width) + (2*length);
    }

}

