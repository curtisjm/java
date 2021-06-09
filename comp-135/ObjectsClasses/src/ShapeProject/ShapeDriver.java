package ShapeProject;

public class ShapeDriver {
    public static void main(String[] args) {
        Shape myShape = new Shape();
        myShape.display();
        myShape.setArea(10);
        myShape.setPerimeter(7);
        System.out.println();
        myShape.display();

        System.out.println();
        Rectangle r = new Rectangle(2,3);
        r.computeArea();
        r.computePerimeter();
        r.display();

        System.out.println();
        Circle c = new Circle((4));
        c.computeArea();
        c.computePerimeter();
        c.display();
    }
}
