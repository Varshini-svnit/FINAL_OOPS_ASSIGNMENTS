package Lab4_5_6;

import java.util.Scanner;

class Cuboid {
    private double length, width, height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return 2 * (length * width + width * height + height * length);
    }

    public void displayDimensions() {
        System.out.println("Length: " + length + ", Width: " + width + ", Height: " + height);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setDimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
}

class CubeHelper {
    public void convertToCube(Cuboid cuboid) {
        double side = Math.min(cuboid.getLength(), Math.min(cuboid.getWidth(), cuboid.getHeight()));
        cuboid.setDimensions(side, side, side);
    }
}

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dimensions of the cuboid (length, width, height): ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        Cuboid cuboid = new Cuboid(length, width, height);

        System.out.println("\nOriginal Cuboid:");
        cuboid.displayDimensions();
        System.out.println("Area of the cuboid: " + cuboid.calculateArea());

        CubeHelper cubeHelper = new CubeHelper();
        cubeHelper.convertToCube(cuboid);

        System.out.println("\nConverted Cube:");
        cuboid.displayDimensions();
        System.out.println("Area of the cube: " + cuboid.calculateArea());

        scanner.close();
    }
}
