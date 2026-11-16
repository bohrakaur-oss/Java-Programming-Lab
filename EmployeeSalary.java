
interface Gross {
    void calculateGross();
}

class Employee {
    int emp_id;
    String name;
    double basicSalary;

    void getDetails() {
        emp_id = 101;
        name = "Jasleen";
        basicSalary = 30000;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

class Salary extends Employee implements Gross {
    double DA, HRA, grossSalary;

    public void calculateGross() {
        DA = basicSalary * 0.40;
        HRA = basicSalary * 0.20;

        grossSalary = basicSalary + DA + HRA;
    }

    void displaySalary() {
        System.out.println("DA: " + DA);
        System.out.println("HRA: " + HRA);
        System.out.println("Gross Salary: " + grossSalary);
    }
}

public class EmployeeSalary {
    public static void main(String[] args) {

        Salary s = new Salary();

        s.getDetails();
        s.calculateGross();

        System.out.println("----- Employee Details -----");
        s.displayDetails();

        System.out.println("\n----- Salary Details -----");
        s.displaySalary();
    }
}
