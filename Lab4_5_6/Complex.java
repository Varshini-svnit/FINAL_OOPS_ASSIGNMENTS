package Lab4_5_6;


import java.util.Scanner;

class Complex {
    private double real, imaginary;

    // Constructor to initialize the complex number
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Inline method to multiply two complex numbers
    public Complex multiply(Complex c) {
        double realPart = this.real * c.real - this.imaginary * c.imaginary;
        double imaginaryPart = this.real * c.imaginary + this.imaginary * c.real;
        return new Complex(realPart, imaginaryPart);
    }

    // Display the complex number in a + bi format
    public void display() {
        System.out.println(real + (imaginary >= 0 ? " + " : " - ") + Math.abs(imaginary) + "i");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the real and imaginary parts of the first complex number: ");
        double real1 = scanner.nextDouble();
        double imaginary1 = scanner.nextDouble();

        System.out.print("Enter the real and imaginary parts of the second complex number: ");
        double real2 = scanner.nextDouble();
        double imaginary2 = scanner.nextDouble();

        Complex c1 = new Complex(real1, imaginary1);
        Complex c2 = new Complex(real2, imaginary2);

        System.out.println("\nFirst Complex Number: ");
        c1.display();

        System.out.println("Second Complex Number: ");
        c2.display();

        Complex result = c1.multiply(c2);

        System.out.println("\nResult of Multiplication: ");
        result.display();

        scanner.close();
    }
}
