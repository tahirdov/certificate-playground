package certification.lesson4;


import certification.lesson4.jdbc.consoles.JdbcScannerConsole;

public class JdbcApp {

    public static void main(String[] args) {
        JdbcScannerConsole jsc = new JdbcScannerConsole();
        System.out.println("Welcome to the student app");
        jsc.getConsole();
    }
}
