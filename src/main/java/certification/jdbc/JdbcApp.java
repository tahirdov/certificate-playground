package certification.jdbc;


public class JdbcApp {

    public static void main(String[] args) throws ClassNotFoundException {
    JdbcStudentConnector connector = new JdbcStudentConnector();
    connector.createStudent();
    }
}
