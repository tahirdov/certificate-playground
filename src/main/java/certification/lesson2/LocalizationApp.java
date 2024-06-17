package certification.lesson2;

import certification.lesson2.localization.LocalizeRunner;

/**The entire purpose of this REPOSITORY is testing stuff
     There are many cases that validations and handlings are missing,
        as the focus is not creating a business level application, but rather learning and re-learning**/
public class LocalizationApp {

    public static void main(String[] args) {
        LocalizeRunner localizeRunner = new LocalizeRunner();
        localizeRunner.runLocalization();
    }
}
