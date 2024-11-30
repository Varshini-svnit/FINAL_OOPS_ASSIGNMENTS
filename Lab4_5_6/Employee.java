package Lab4_5_6;


import java.util.Scanner;

class Employee {
    private int emp_id;
    private String emp_name;
    private int age;

    public Employee(int emp_id, String emp_name, int age) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.age = age;
    }

    public int getEmpId() {
        return emp_id;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Age: " + age);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[10];
        int searchId;
        boolean found = false;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter Employee ID: ");
            int emp_id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter Employee Name: ");
            String emp_name = scanner.nextLine();
            System.out.print("Enter Employee Age: ");
            int age = scanner.nextInt();
            employees[i] = new Employee(emp_id, emp_name, age);
        }

        System.out.print("Enter Employee ID to search: ");
        searchId = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            if (employees[i].getEmpId() == searchId) {
                employees[i].displayEmployeeDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + searchId + " not found.");
        }

        scanner.close();
    }
}
