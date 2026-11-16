import java.util.ArrayList;
import java.util.Scanner;

interface Department {
    void printDepartmentAttributes();
}
class Hostel {
    protected String hostelName;
    protected String hostelLocation;
    protected int numberOfRooms;

    public void getHostelData(Scanner sc) {
        System.out.print("Enter Hostel Name: ");
        hostelName = sc.next();
        System.out.print("Enter Hostel Location: ");
        hostelLocation = sc.next();
        System.out.print("Enter Number of Rooms: ");
        numberOfRooms = sc.nextInt();
    }
     public void printHostelData() {
        System.out.println("Hostel Name: " + hostelName + ", Location: " + hostelLocation + ", Rooms: " + numberOfRooms);
    }
}
class Student extends Hostel implements Department {
    private String studentName;
    private String regdNo;
    private String electiveSubject;
    private double avgMarks;
    private String deptName;
    private String deptHead;

    public void getData(Scanner sc) {
        System.out.print("Enter Student Name: ");
        studentName = sc.next();
        System.out.print("Enter Registration Number: ");
        regdNo = sc.next();
        System.out.print("Enter Elective Subject: ");
        electiveSubject = sc.next();
        System.out.print("Enter Average Marks: ");
        avgMarks = sc.nextDouble();
        
        System.out.print("Enter Department Name: ");
        deptName = sc.next();
        System.out.print("Enter Department Head: ");
        deptHead = sc.next();

        System.out.println("--- Enter Hostel Details ---");
        super.getHostelData(sc);
    }

    public void printData() {
        System.out.println("\n[Student Details]");
        System.out.println("Name: " + studentName + " | Regd No: " + regdNo);
        System.out.println("Elective: " + electiveSubject + " | Avg Marks: " + avgMarks);
        printDepartmentAttributes();
        super.printHostelData();
    }

    @Override
    public void printDepartmentAttributes() {
        System.out.println("Department: " + deptName + " | Dept Head: " + deptHead);
    }

    public String getRegdNo() {
        return regdNo;
    }

    public void migrateStudent(Scanner sc) {
        System.out.println("--- Migrating Student: " + studentName + " ---");
        System.out.print("Enter New Hostel Name: ");
        hostelName = sc.next();
        System.out.print("Enter New Hostel Location: ");
        hostelLocation = sc.next();
        System.out.print("Enter New Department Name: ");
        deptName = sc.next();
        System.out.print("Enter New Department Head: ");
        deptHead = sc.next();
        System.out.println("Student migrated successfully!");
    }
}
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- University Menu ---");
            System.out.println("1. Admit new student");
            System.out.println("2. Migrate a student");
            System.out.println("3. Display details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student newStudent = new Student();
                    newStudent.getData(sc);
                    students.add(newStudent);
                    System.out.println("Student admitted successfully!");
                    break;

                case 2:
                    System.out.print("Enter Registration Number to search and migrate: ");
                    String searchRegd = sc.next();
                    boolean foundMigrate = false;
                    for (Student s : students) {
                        if (s.getRegdNo().equalsIgnoreCase(searchRegd)) {
                            s.migrateStudent(sc);
                            foundMigrate = true;
                            break;
                        }
                    }
                    if (!foundMigrate) {
                        System.out.println("Student with Registration Number " + searchRegd + " not found.");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\n=== All Student Records ===");
                        for (Student s : students) {
                            s.printData();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}