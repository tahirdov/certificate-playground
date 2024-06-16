package certification.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static certification.jdbc.JdbcDriverManager.getConnection;

@SuppressWarnings("all")
public class JdbcStudentConnector {

    SqlQueryHandler sqlQueryHandler = new SqlQueryHandler();


    public void createStudent(Student student) {
    try (Connection con = getConnection();
    PreparedStatement statement = con.prepareStatement(sqlQueryHandler.getInsertQuery())) {
        statement.setString(2, student.getName());
        statement.setInt(3, student.getAge());
        statement.setString(4, student.getGender());
        statement.setString(5, student.getFaculty());
        statement.execute();
    }
    catch (SQLException e) {
        System.out.println("SQLException: " + e.getStackTrace());
    }
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
                students.add(new Student(rs.getLong(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5)));
            }
        }
        catch (SQLException e) {
            System.out.println("SqlException Occurred: " + e.getStackTrace());
        }
        System.out.println("Printing Students List:");
        System.out.println(students);
    }

}
