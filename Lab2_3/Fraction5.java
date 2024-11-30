package Lab2;

public class Fraction5 {

    int numerator;
    int denominator;

    Fraction5(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void add(Fraction5 f) {
        int newNumerator = this.numerator * f.denominator + f.numerator * this.denominator;
        int newDenominator = this.denominator * f.denominator;
        System.out.println("Sum: " + newNumerator + "/" + newDenominator);
    }

    public void subtract(Fraction5 f) {
        int newNumerator = this.numerator * f.denominator - f.numerator * this.denominator;
        int newDenominator = this.denominator * f.denominator;
        System.out.println("Difference: " + newNumerator + "/" + newDenominator);
    }

    public void multiply(Fraction5 f) {
        int newNumerator = this.numerator * f.numerator;
        int newDenominator = this.denominator * f.denominator;
        System.out.println("Product: " + newNumerator + "/" + newDenominator);
    }

    public static void main(String[] args) {
        Fraction5 f1 = new Fraction5(3, 4);
        Fraction5 f2 = new Fraction5(5, 6);

        f1.add(f2);
        f1.subtract(f2);
        f1.multiply(f2);
    }
}
