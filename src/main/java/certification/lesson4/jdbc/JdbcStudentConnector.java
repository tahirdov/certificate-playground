package certification.lesson4.jdbc;

import certification.lesson4.jdbc.consoles.JdbcScannerConsole;

import java.sql.*;
import java.util.*;

import static certification.lesson4.jdbc.JdbcDriverManager.getConnection;

@SuppressWarnings("all")
public class JdbcStudentConnector {

    SqlQueryHandler sqlQueryHandler = new SqlQueryHandler();
    private final JdbcScannerConsole console = new JdbcScannerConsole();


    public void createStudent(Student student) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(sqlQueryHandler.getInsertQuery())) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getFaculty());
            statement.execute();
            System.out.println("Student successfully created " + student);
            console.getConsole();
        } catch (SQLException e) {
            System.out.println("An error occured while creating student");
            e.printStackTrace();
            console.getConsole();
        }
    }

    public void findStudent(Map<String, Object> fields) {
        StringBuilder stringBuilder = new StringBuilder(sqlQueryHandler.getBaseSelectQueryWithConditions());
        Map<String, Object> queryParams = new HashMap<>();

        for (String key : fields.keySet()) {
            if ((fields.get(key) != null) && !(fields.get(key).toString().isEmpty())) {
                queryParams.put(key, fields.get(key));
            }
        }

        List<String> keys = new ArrayList<>(queryParams.keySet());
        if (queryParams.size() > 0) {
            for (String key : queryParams.keySet()) {
                if (key != keys.get(keys.size() - 1)) {
                    stringBuilder.append(key).append(" = '").append(fields.get(key)).append("' AND ");
                } else {
                    stringBuilder.append(key).append(" = '").append(fields.get(key)).append("'");
                }
            }
        }


        String sql = stringBuilder.toString();
        System.out.println("SQL: " + sql);

        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("Printing student: "
                        + new Student(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5)));
                console.getConsole();
            }
        } catch (SQLException e) {
            System.out.println("An error occured while finding student");
            e.printStackTrace();
            console.getConsole();
        }
    }

    public void deleteStudent(int id) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sqlQueryHandler.getDeleteQuery(id));
            System.out.println("Student successfully deleted " + id);
            console.getConsole();
        } catch (SQLException e) {
            System.out.println("An error occured while deleting student");
            e.printStackTrace();
            console.getConsole();
        }
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
            System.out.println("Printing Students List:");
            System.out.println(students);
            console.getConsole();
        } catch (SQLException e) {
            System.out.println("An error occured while printing students");
            e.printStackTrace();
            console.getConsole();
        }
    }

}
