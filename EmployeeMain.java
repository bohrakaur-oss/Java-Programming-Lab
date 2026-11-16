
import java.util.Scanner;

class Employee {
    int emp_no;
    String name;
    String department;
    double basic_pay, DA, HRA, gross_salary;

    public void calculateSalary() {
        DA = 0.40 * basic_pay;
        HRA = 0.20 * basic_pay;
        gross_salary = basic_pay + DA + HRA;
    }

    public void displayDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Employee Number : " + emp_no);
        System.out.println("Name            : " + name);
        System.out.println("Department      : " + department);
        System.out.printf("Basic Pay       : %.2f%n", basic_pay);
        System.out.printf("DA (40%%)        : %.2f%n", DA);
        System.out.printf("HRA (20%%)       : %.2f%n", HRA);
        System.out.printf("Gross Salary    : %.2f%n", gross_salary);
        System.out.println("----------------------------------------");
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of employees.");
            scanner.close();
            return;
        }

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee();

            System.out.println("\nEnter details for employee " + (i + 1) + ":");

            System.out.print("Employee No: ");
            employees[i].emp_no = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            employees[i].name = scanner.nextLine();

            System.out.print("Department: ");
            employees[i].department = scanner.nextLine();

            System.out.print("Basic Pay: ");
            employees[i].basic_pay = scanner.nextDouble();

            employees[i].calculateSalary();
        }

        Employee highestPaid = employees[0];

        for (int i = 1; i < n; i++) {
            if (employees[i].gross_salary > highestPaid.gross_salary) {
                highestPaid = employees[i];
            }
        }

        System.out.println("\nEmployee with the Highest Gross Salary:");
        highestPaid.displayDetails();

        scanner.close();
    }
}
