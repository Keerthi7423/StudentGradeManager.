package StudentGradeManager;

import java.util.Scanner;

public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager manager = new GradeManager();
        manager.loadFromFile("students.txt");

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter marks: ");
                    int marks = scanner.nextInt();
                    manager.addStudent(name, marks);
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    manager.saveToFile("students.txt");
                    System.out.println("Data saved. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

