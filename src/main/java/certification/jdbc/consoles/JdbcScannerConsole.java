package certification.jdbc.consoles;

import certification.jdbc.StudentService;
import certification.utils.Console;

public class JdbcScannerConsole implements Console {


    @Override
    public void getConsole() {
        printCommands();
        System.out.println("Enter your command: ");
        StudentService studentService = new StudentService();
        String command = scanner.nextLine();
        switch (command.toLowerCase()) {
            case "run" -> printCommands();
            case "create" -> studentService.createStudent();
            case "update" -> studentService.updateStudent();
            case "find" -> studentService.findStudent();
            case "print" -> studentService.printStudentList();
            case "delete" -> studentService.deleteStudent();
            case "exit" -> System.out.println("Shutting down...");
            default -> {
                System.out.println("Unknown command: " + command);
                getConsole();
            }
        }
    }

    private void printCommands() {
        System.out.println("Available commands: Create, Update, Find, Print, Delete, Exit");
    }
}
