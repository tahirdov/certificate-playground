package certification.jdbc;

import certification.utils.Console;

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

    }

    public void printStudentList() {

    }

}
