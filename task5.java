package calculater;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.println("Enter student details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        int rollNumber = -1;
        char grade = '\0';

        while (true) {
            try {
                System.out.print("Roll Number: ");
                rollNumber = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for Roll Number.");
            }
        }

        while (true) {
            System.out.print("Grade: ");
            String gradeStr = scanner.nextLine();
            if (gradeStr.length() == 1) {
                grade = gradeStr.charAt(0);
                if (Character.isLetter(grade)) {
                    break;
                }
            }
            System.out.println("Invalid input. Please enter a valid single character for Grade.");
        }

        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void removeStudent() {
        System.out.print("Enter the Roll Number of the student to remove: ");
        int rollNumber = Integer.parseInt(scanner.nextLine());
        boolean removed = false;

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                removed = true;
                System.out.println("Student removed successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent() {
        System.out.print("Enter the Roll Number of the student to search: ");
        int rollNumber = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:\n" + student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("List of all students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void exit() {
        scanner.close();
        System.out.println("Exiting the Student Management System.");
        System.exit(0);
    }
}

class task5 {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.removeStudent();
                    break;
                case 3:
                    system.searchStudent();
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    system.exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
