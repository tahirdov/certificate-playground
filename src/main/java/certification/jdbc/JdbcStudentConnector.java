package certification.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@SuppressWarnings("all")
public class JdbcStudentConnector {

    SqlQueryHandler sqlQueryHandler = new SqlQueryHandler();

    public void createStudent(Student student) {

    }

    public void findStudent(String... arg) {

    }

    public void deleteStudent(int id) {

    }

    public void printStudentList() {
        List<Student> students = new ArrayList<>();
        try (Connection con = getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQueryHandler.getBaseSelectQuery());
            while (rs.next()) {
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5)));
            }
        }
        catch (SQLException e) {
            System.out.println("SqlException Occurred: " + e.getStackTrace());
        }
        System.out.println("Printing Students List:");
        System.out.println(students);
    }

    private Connection getConnection(){
        Map<String, String> connectionDetails = JdbcDriverManager.getConnectionDetails();
        String url = connectionDetails.get("url");
        String user = connectionDetails.get("user");
        String password = connectionDetails.get("password");
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            return connection;
        }
        catch (SQLException e) {
            System.out.println("SqlException Occurred: " + e.getStackTrace());
        }

    }
}
