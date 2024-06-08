package certification.localization;

/**The entire purpose of this REPOSITORY is testing stuff
     There are many cases that validations and handlings are missing,
        as the focus is not creating a business level application, but rather learning and re-learning**/
public class LocalizationApp {

    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        LocalizeRunner localizeRunner = new LocalizeRunner();
        localizeRunner.runLocalization();
    }
}
