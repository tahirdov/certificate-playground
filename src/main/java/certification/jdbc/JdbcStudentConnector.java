package certification.jdbc;

import java.sql.*;
import java.util.*;

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
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getStackTrace());
        }
    }

    public void findStudent(Map<String, Object> fields) {
        StringBuilder stringBuilder = new StringBuilder(sqlQueryHandler.getBaseSelectQueryWithConditions());
        for (String key : fields.keySet()) {
            if (!(fields.get(key) == null)) {
                stringBuilder.append(key).append("=").append(fields.get(key));
            }
        }
        String sql = stringBuilder.toString();
        System.out.println("SQL: " + sql);

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("Printing student: "
                        + new Student(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getStackTrace());
        }
    }

    public void deleteStudent(int id) {

    }

    public void printStudentList() {
        List<Student> students = new ArrayList<>();
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQueryHandler.getBaseSelectQuery());
            while (rs.next()) {
                students.add(new Student(rs.getLong(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println("SqlException Occurred: " + e.getStackTrace());
        }
        System.out.println("Printing Students List:");
        System.out.println(students);
    }

}
