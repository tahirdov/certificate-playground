package certification.types.math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TypePromoter {

    private final Scanner scanner = new Scanner(System.in);


    public void printInput(String command) {
        if (command.equalsIgnoreCase("stop")) return;
        System.out.println("Enter an integer");
        var num = scanner.nextLine();
        scanner.nextLine();
        int number = 0;
        try {
            number = Integer.parseInt(num);
            printNum(number);
            System.out.println("Enter your next command");
            String nextCommand = scanner.nextLine();
            printInput(nextCommand);
        } catch (InputMismatchException e) {
            printNum((long) number);
            printInput(command);
        } catch (NumberFormatException e) {
            System.out.println("You did not enter a number. Please enter a number");
            scanner.nextLine();
            printInput(command);
        }

    }

    public void printNum(int d) {
        System.out.println("Printed int: " + d);
    }

    public void printNum(long d) {
        System.out.println("Printed long: " + d);
    }



}
