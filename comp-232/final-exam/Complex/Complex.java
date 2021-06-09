
public class Complex implements Comparable<Complex> {

    private double a;
    private double b;

    public Complex() {
        this.a = 0;
        this.b = 0;
    }
    public Complex(double a) {
        this.a = a;
        this.b = 0;
    }
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

    public Complex add(Complex otherComplex) {
        return new Complex(a + otherComplex.a, b + otherComplex.b);
    }

    public Complex subtract(Complex otherComplex) {
        return new Complex(a - otherComplex.a, b - otherComplex.b);
    }

    public Complex multiply(Complex otherComplex) {
        return new Complex((a * otherComplex.a) - (b * otherComplex.b), (b * otherComplex.a) + (a * otherComplex.b));
    }

    public Complex divide(Complex otherComplex) {
        return new Complex((a * otherComplex.a + b * otherComplex.b) / (Math.pow(otherComplex.a, 2) + Math.pow(otherComplex.b, 2)),
                (b * otherComplex.a - a * otherComplex.b) / (Math.pow(otherComplex.a, 2) + Math.pow(otherComplex.b, 2)));
    }

    public double abs() {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    @Override
    public String toString() {
        if(a == 0 && b == 0) {
            return "0";
        } else if(b == 0) {
            return "" + a;
        } else {
            return "(" + a + " + " + b + "i)";
        }
    }

    @Override
    public int compareTo(Complex otherComplex) {
        return Double.compare(this.abs(), otherComplex.abs());
    }

}
