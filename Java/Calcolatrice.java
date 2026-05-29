import java.util.InputMismatchException;

public class Calcolatrice {
    private double a;
    private double b;

    public Calcolatrice() {
        this.a = 0;
        this.b = 0;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double addizione() {
        return a + b;
    }

    public double sottrazione() {
        return a - b;
    }

    public double divisione() {
        if (b == 0) throw new InputMismatchException();

        return a / b;
    }
    public double moltiplicazione() {
        return a * b;
    }
}
