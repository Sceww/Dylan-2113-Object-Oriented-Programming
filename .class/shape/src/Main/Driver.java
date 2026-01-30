package Main;

import java.util.Scanner;
import modules.*;

public class Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int circleCount = 0, triangleCount = 0, rectangleCount = 0;
        double totalCircleArea      = 0;
        double totalRectangleArea   = 0;
        double totalTriangleArea    = 0;

        double totalCirclePerimeter     = 0;
        double totalRectanglePerimeter  = 0;
        double totalTrianglePerimeter   = 0;

        while (true) {
            System.out.println("enter shape: ");
            String shape = scnr.next().toLowerCase();
            if (shape.equals("exit")) {
                System.out.println("Total Triangles: " + triangleCount);
                System.out.println("Total Triangle Area: " + totalTriangleArea);
                System.out.println("Total Triangle Perimeter: " + totalTrianglePerimeter);

                System.out.println("Total Circles: " + circleCount);
                System.out.println("Total Circle Area: " + totalCircleArea);
                System.out.println("Total Circle Perimeter: " + totalCirclePerimeter);

                System.out.println("Total Rectangles: " + rectangleCount);
                System.out.println("Total Rectangle Area: " + totalRectangleArea);
                System.out.println("Total Rectangle Perimeter: " + totalRectanglePerimeter);

                break;
            }
            switch (shape) {
                case "circle":
                    double r = scnr.nextDouble();
                    Circle c = new Circle(r);
                    System.out.println("Area: " + c.getArea());
                    System.out.println("Perimeter: " + c.getPerimeter());
                    circleCount++;
                    totalCircleArea += c.getArea();
                    totalCirclePerimeter += c.getPerimeter();
                    break;
                case "triangle":
                    double base = scnr.nextDouble();
                    double height = scnr.nextDouble();
                    double sideA = scnr.nextDouble();
                    double sideB = scnr.nextDouble();
                    double sideC = scnr.nextDouble();
                    
                    Triangle t = new Triangle(base, height, sideA, sideB, sideC);
                    System.out.println("Area: " + t.getArea());
                    System.out.println("Perimeter: " + t.getPerimeter());
                    triangleCount++;
                    totalTriangleArea += t.getArea();
                    totalTrianglePerimeter += t.getPerimeter();
                    break;
                case "rectangle":
                    double length = scnr.nextDouble();
                    double width = scnr.nextDouble();
                    Rectangle rect = new Rectangle(length, width);
                    System.out.println("Area: " + rect.getArea());
                    System.out.println("Perimeter: " + rect.getPerimeter());
                    rectangleCount++;
                    totalRectangleArea += rect.getArea();
                    totalRectanglePerimeter += rect.getPerimeter(); 
                default:
                    System.out.println("Invalid Shape!");
                    break;
            }
        }

    }
}