package StudentGradeManager;

import java.util.*;
import java.io.*;

public class GradeManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String name, int marks) {
        students.add(new Student(name, marks));
    }

    public void viewStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student s : students) {
                writer.println(s.name + "," + s.marks);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public void loadFromFile(String filename) {
        students.clear();
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                if (parts.length == 2) {
                    addStudent(parts[0], Integer.parseInt(parts[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        }
    }
}
