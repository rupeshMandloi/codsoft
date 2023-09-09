import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int remainingSeats;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.remainingSeats = capacity;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public String getSchedule() {
        return schedule;
    }

    public void registerStudent() {
        if (remainingSeats > 0) {
            remainingSeats--;
        } else {
            System.out.println("Course is full. Cannot register.");
        }
    }

    public void dropStudent() {
        if (remainingSeats < capacity) {
            remainingSeats++;
        } else {
            System.out.println("No students to drop from this course.");
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + code +
                "\nTitle: " + title +
                "\nDescription: " + description +
                "\nCapacity: " + capacity +
                "\nRemaining Seats: " + remainingSeats +
                "\nSchedule: " + schedule;
    }
}

class Student {
    private int studentId;
    private String name;
    private List<String> registeredCourses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(String courseCode, Map<String, Course> courseMap) {
        if (courseMap.containsKey(courseCode)) {
            Course course = courseMap.get(courseCode);
            if (!registeredCourses.contains(courseCode)) {
                course.registerStudent();
                registeredCourses.add(courseCode);
                System.out.println("Successfully registered for course: " + courseCode);
            } else {
                System.out.println("Already registered for this course.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    public void dropCourse(String courseCode, Map<String, Course> courseMap) {
        if (courseMap.containsKey(courseCode)) {
            Course course = courseMap.get(courseCode);
            if (registeredCourses.contains(courseCode)) {
                course.dropStudent();
                registeredCourses.remove(courseCode);
                System.out.println("Successfully dropped course: " + courseCode);
            } else {
                System.out.println("Not registered for this course.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId +
                "\nName: " + name +
                "\nRegistered Courses: " + registeredCourses;
    }
}

class task4 {
    public static void main(String[] args) {
        Map<String, Course> courseMap = new HashMap<>();
        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Student Course Registration System");
            System.out.println("1. Add Course");
            System.out.println("2. List Courses");
            System.out.println("3. Register Student");
            System.out.println("4. Drop Course");
            System.out.println("5. List Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter course title: ");
                    String courseTitle = scanner.nextLine();
                    System.out.print("Enter course description: ");
                    String courseDescription = scanner.nextLine();
                    System.out.print("Enter course capacity: ");
                    int courseCapacity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter course schedule: ");
                    String courseSchedule = scanner.nextLine();

                    Course newCourse = new Course(courseCode, courseTitle, courseDescription, courseCapacity, courseSchedule);
                    courseMap.put(courseCode, newCourse);
                    break;

                case 2:
                    System.out.println("\nCourse Listing:");
                    for (Course course : courseMap.values()) {
                        System.out.println(course);
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    Student newStudent = new Student(studentId, studentName);
                    students.add(newStudent);

                    System.out.println("\nAvailable Courses for Registration:");
                    for (Course course : courseMap.values()) {
                        System.out.println("Course Code: " + course.getCode() + ", Title: " + course.getTitle());
                    }

                    System.out.print("Enter the course code to register: ");
                    String regCourseCode = scanner.nextLine();
                    newStudent.registerForCourse(regCourseCode, courseMap);
                    break;

                case 4:
                    System.out.print("Enter student ID to drop course: ");
                    int dropStudentId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the course code to drop: ");
                    String dropCourseCode = scanner.nextLine();

                    for (Student student : students) {
                        if (student.getStudentId() == dropStudentId) {
                            student.dropCourse(dropCourseCode, courseMap);
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nList of Students:");
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;

                case 6:
                    System.out.println("Exiting the Student Course Registration System");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}