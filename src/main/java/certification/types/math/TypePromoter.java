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
                    System.out.println("Your value is too big");
                    executePrintCommand();

            }
        }
    }

    public void printNum(long d) {
        System.out.println("Printed long: " + d);
    }

    private void executePrintCommand() {
        System.out.println("Enter your next command");
        String nextCommand = scanner.nextLine();
        printInput(nextCommand);
    }

}
