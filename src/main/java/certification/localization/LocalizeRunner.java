package certification.localization;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;


public class LocalizeRunner {

    private final AzeLocalizer azeLocalizer = new AzeLocalizer();

    public void runLocalization() {
        printLocalizedData(LocalDateTime.now());
        printLocalizedData(ThreadLocalRandom.current().nextDouble(1, 100));
    }

    private void printLocalizedData(LocalDateTime localDateTime) {
        Charset utf8 = StandardCharsets.UTF_8;

        System.out.printf("%s %s %s", azeLocalizer.getMessage("print.date").toUpperCase(),
                                    StandardCharsets.UTF_8.encode(azeLocalizer.getMessage("print.message")), azeLocalizer.getFormattedDate(localDateTime));
        System.out.println();
    }

    private void printLocalizedData(double amount) {
        System.out.printf("%s %s %s", azeLocalizer.getMessage("print.currency").toUpperCase(),
                azeLocalizer.getMessage("print.message"), azeLocalizer.getFormattedCurrency(amount));
        System.out.println();
    }


}
