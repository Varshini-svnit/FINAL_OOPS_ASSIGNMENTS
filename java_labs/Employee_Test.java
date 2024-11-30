package java_labs;


class Employee {
    String name;
    String lastName;
    private double monthlySalary;

    public Employee(String name, String lastName, double monthlySalary) {
        this.name = name;
        this.lastName = lastName;
        setMonthlySalary(monthlySalary);
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.out.println("Monthly salary must be positive.");
        }
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double yearlySalary() {
        return monthlySalary * 12;
    }

    public void giveRaise(double percentage) {
        setMonthlySalary(monthlySalary * (1 + percentage / 100));
    }
}

public class Employee_Test {


    public static void main(String[] args) {
     
        Employee employee1 = new Employee("rani", "singh", 5000);
        Employee employee2 = new Employee("varshini", "Roy", 10000);

        
        System.out.printf("Name=%s\nLast name= %s\nYearly Salary: $%.2f%n\n", employee1.name, employee1.lastName, employee1.yearlySalary());
        System.out.printf("Name=%s\nLast name= %s\nYearly Salary: $%.2f%n\n", employee2.name, employee2.lastName, employee2.yearlySalary());

        employee1.giveRaise(10);
        employee2.giveRaise(10);

   
        System.out.println("After 10% raise:\n");
        System.out.printf("Name=%s\nLast name= %s\nYearly Salary: $%.2f%n\n", employee1.name, employee1.lastName, employee1.yearlySalary());
        System.out.printf("Name=%s\nLast name= %s\nYearly Salary: $%.2f%n\n", employee2.name, employee2.lastName, employee2.yearlySalary());
    }
}