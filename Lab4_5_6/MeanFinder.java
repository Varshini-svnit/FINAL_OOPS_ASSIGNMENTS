package Lab4_5_6;


class ClassA {
    private double numberA;

    public void setNumber(double number) {
        this.numberA = number;
    }

    public double getNumber() {
        return this.numberA;
    }
}

class ClassB {
    private double numberB;

    public void setNumber(double number) {
        this.numberB = number;
    }

    public double getNumber() {
        return this.numberB;
    }
}

class MeanCalculator {
    public static double calculateMean(ClassA objA, ClassB objB) {
        return (objA.getNumber() + objB.getNumber()) / 2;
    }
}

public class MeanFinder {
    public static void main(String[] args) {
        ClassA objA = new ClassA();
        ClassB objB = new ClassB();

        objA.setNumber(10.5);
        objB.setNumber(15.5);

        double mean = MeanCalculator.calculateMean(objA, objB);
        System.out.println("The mean of the two numbers is: " + mean);
    }
}
