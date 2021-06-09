package ShapeProject;

public class Circle extends Shape {

    double radius;

    public Circle() {
        name = "Circle";
        radius = 0;
    }

    public Circle(double radius) {
        name = "Circle";
        this.radius = radius;
    }

    public void computeArea() {
        area = Math.PI * radius * radius;
    }
    public void computePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }
}
