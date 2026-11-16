
class Employee {
    private String name;
    private String department;
    private double salary;

    private static String companyName = "Techmax";

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Name: " + name
                + ", Department: " + department
                + ", Salary: " + salary);
    }

    public static void displayCompanyName() {
        System.out.println("Company Name: " + companyName);
    }

    public static void main(String[] args) {
        Employee.displayCompanyName();
        System.out.println();

        Employee e1 = new Employee("Sankalp Pandey", "IT", 50000);
        Employee e2 = new Employee("Naman Lall", "HR", 65000);
        Employee e3 = new Employee("Nayan Chhetri", "Sales", 45000);
        Employee e4 = new Employee("Niladri Deb", "Tech", 55000);
        Employee e5 = new Employee("Champak Sinha", "Accounts", 68000);

        e1.display();
        e2.display();
        e3.display();
        e4.display();
        e5.display();
    }
}