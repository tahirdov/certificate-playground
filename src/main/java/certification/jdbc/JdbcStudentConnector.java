package certification.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcStudentConnector {

    Map<String, String> connectionDetails = JdbcDriverManager.getConnectionDetails();

    public void printStudentList() {

    }

    public void findStudent(String... arg) {

    }

    public void deleteStudent(int id) {

    }

    public void createStudent() throws ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(connectionDetails.get("url"), connectionDetails.get("user"), connectionDetails.get("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5)));
            }
        }
        catch (SQLException e) {
            System.out.println("SqlException Occured: " + e.getMessage());
        }
        System.out.println(students);
    }

}
