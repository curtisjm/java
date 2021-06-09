package ShapeProject;

public class Shape {

    // protected means all classes within the package have access
    protected String name;
    protected double area, perimeter;

    public Shape() {
        name = "undetermined";
        area = 0;
        perimeter = 0;
    }

    public String getName() {
        return name;
    }
    public double getArea() {
        return area;
    }
    public double getPerimeter() {
        return perimeter;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    // display
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}
