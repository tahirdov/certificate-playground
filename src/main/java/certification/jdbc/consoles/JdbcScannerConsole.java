package certification.jdbc.consoles;

import certification.jdbc.StudentService;
import certification.utils.Console;

public class JdbcScannerConsole implements Console {

    StudentService studentService = new StudentService();

    @Override
    public void getConsole() {
        System.out.println("Enter your command: ");
        String command = scanner.nextLine();
        switch (command.toLowerCase()) {
            case "run" -> printCommands();
            case "create" -> studentService.createStudent();
            case "update" -> studentService.updateStudent();
            case "find" -> studentService.findStudent();
            case "print" -> studentService.printStudentList();
            case "delete" -> studentService.deleteStudent();
            default -> {
                System.out.println("Unknown command: " + command);
                printCommands();
            }
        }
    }

    private void printCommands() {
        System.out.println("Available commands: Create, Update, Find, Print, Delete");
    }
}
