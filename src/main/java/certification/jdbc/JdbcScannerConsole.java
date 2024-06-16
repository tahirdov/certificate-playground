package certification.jdbc;

import certification.utils.Console;

public class JdbcScannerConsole implements Console {

    JdbcStudentConnector jdbcConnector = new JdbcStudentConnector();

    @Override
    public void getConsole() {
        System.out.println("Enter your command: ");
        String command = scanner.nextLine();
        switch (command.toLowerCase()) {
            case "run" -> printCommands();
            case "create" -> jdbcConnector.createStudent();
            case "find" -> jdbcConnector.findStudent();
            case "print" -> jdbcConnector.printStudentList();
            case "delete" -> {
                System.out.println("Enter the student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                jdbcConnector.deleteStudent(id);
            }
            default -> {
                System.out.println("Unknown command: " + command);
                printCommands();
            }
        }
    }

    private void printCommands() {
        System.out.println("Available commands: Create, Find, Print, Delete");
    }
}
