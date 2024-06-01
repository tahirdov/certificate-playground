package certification.types.math;

import java.math.BigInteger;
import java.util.Scanner;

public class TypePromoter {

    private final Scanner scanner = new Scanner(System.in);


    public void printInput(String command) {
        if (!command.equalsIgnoreCase("run")) return;
        System.out.println("Enter an integer");
        var num = scanner.nextLine();
        try {
            printNum(Integer.parseInt(num));
            executePrintCommand();
        }
        catch (NumberFormatException failedParseInt) {
            try {
                printNum(Long.parseLong(num));
                executePrintCommand();
            }
            catch (NumberFormatException failedParseLong) {
                try {
                    printNum(new BigInteger(num));
                    executePrintCommand();
                }
                catch (NumberFormatException failedParseBigInteger) {
                    System.out.println("You did not enter a number. Please enter a number");
                    executePrintCommand();
                }
            }
        }
    }

    public void printNum(int d) {
        System.out.println("Printed int: " + d);
    }

    public void printNum(long d) {
        System.out.println("Printed long: " + d);
    }

    public void printNum(BigInteger d) {
        System.out.println("Printed BigInteger: " + d);
    }

    private void executePrintCommand() {
        System.out.println("Enter your next command");
        String nextCommand = scanner.nextLine();
        printInput(nextCommand);
    }

}
