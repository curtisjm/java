package Geom;

public class Driver {

    // could also put in class and cast to object type
    public static void displayGeometricObject(GeometricObject obj) {
        System.out.println();
        System.out.println("The area is " + obj.getArea());
        System.out.println("The perimeter is " + obj.getPerimeter());
    }

    public static boolean equalArea(GeometricObject obj1, GeometricObject obj2) {
        System.out.println();
        return (obj1.getArea() == obj2.getArea());
    }

    public static void main(String[] args) {
        GeometricObject c1 = new Circle(5);
        GeometricObject r1 = new Rectangle(5,3);
        displayGeometricObject(c1);
        displayGeometricObject(r1);
        System.out.println("The two objects have the same area? " + equalArea(c1, r1));
    }
}
