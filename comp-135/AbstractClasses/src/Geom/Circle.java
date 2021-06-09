package Geom;

public class Circle extends GeometricObject {

    private double radius;

    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        // could also use super();
        setColor(color);
        setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // implements abstract methods
    public double getArea() {
        return radius * radius * Math.PI;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void printCircle() {
        System.out.println("Circle was created at: " + getDateCreated() + " for radius " + radius);
    }
}
