package ShapeProject;

// inherits from parent class
public class Rectangle extends Shape {

    double length, width;

    public Rectangle() {
        name = "Rectangle";
        length = width = 0;
    }

    public Rectangle(double length, double width) {
        name = "Rectangle";
        this.length = length;
        this.width = width;
    }

    public void computeArea() {
        area = length * width;
    }
    public void computePerimeter() {
        perimeter = 2 * (length + width);
    }
}
