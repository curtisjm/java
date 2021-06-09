package Geom;

// special type of parent class
// exists only to help define children
// put common / shared code here
public abstract class GeometricObject {

    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }
    public boolean isFilled() {
        return filled;
    }
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    // no set date because it's in constructor and we don't want it to be overwritten

    // Abstract methods
    public abstract double getArea();
    public abstract double getPerimeter();

}
