package certification.jdbc;

import certification.utils.Console;

import java.util.HashMap;
import java.util.Map;


public class StudentService implements Console {

    JdbcStudentConnector jdbcConnector = new JdbcStudentConnector();

    public void createStudent() {
        System.out.println("Please enter student details: ");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Gender: ");
        String gender = scanner.nextLine();
        System.out.println("Faculty: ");
        String faculty = scanner.nextLine();
        jdbcConnector.createStudent(new Student(name, age, gender, faculty));
    }

    public void deleteStudent() {
        System.out.println("Enter the student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        jdbcConnector.deleteStudent(id);
    }

    public void updateStudent() {

    }

    public void findStudent() {
        Map<String, Object> details = new HashMap<>();
        System.out.println("Enter the student ID: ");
        Long id = null;
        try{
            id = Long.valueOf(scanner.nextLine());
        } catch (NumberFormatException ignored) {}
        details.put("id", id);
        System.out.println("Enter the student name: ");
        String name = scanner.nextLine();
        details.put("name", name);
        System.out.println("Enter the student age: ");
        Integer age = null;
        try {
            age = Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException ignored) {}
        details.put("age", age);
        System.out.println("Enter the student gender: ");
        String gender = scanner.nextLine();
        details.put("gender", gender);
        System.out.println("Enter the student faculty: ");
        String faculty = scanner.nextLine();
        details.put("faculty", faculty);
        jdbcConnector.findStudent(details);
    }

    public void printStudentList() {
        jdbcConnector.printStudentList();
    }


}
