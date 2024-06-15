package certification.jdbc;

import java.sql.*;

public class JdbcStudentConnector {

    public void createStudent() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tahir123"))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        }
        catch (SQLException e) {
            System.out.println("SqlException Occured: " + e.getMessage());
        }
    }

}
