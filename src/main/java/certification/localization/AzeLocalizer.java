package certification.localization;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class AzeLocalizer {

    private final Locale locale;
    private final ResourceBundle resourceBundle;
    private final DateTimeFormatter dateTimeFormatter;
    private final NumberFormat currencyFormatter;

    public AzeLocalizer() {
        this.locale = new Locale("az", "AZ");
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss", locale);
        this.currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        this.resourceBundle = ResourceBundle.getBundle("Messages", locale);
    }

    public String getMessage(String key){
        return resourceBundle.getString(key);
    }
    public String getFormattedCurrency(double amount) {
        return currencyFormatter.format(amount);
    }

    public LocalDateTime getFormattedDate(LocalDateTime localDateTime) {
        return LocalDateTime.parse(dateTimeFormatter.format(localDateTime), dateTimeFormatter);
    }
}
