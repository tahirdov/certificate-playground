package certification.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcDriverManager {


    public static Connection getConnection() throws SQLException {
        Map<String, String> connectionDetails = getConnectionDetails();
        return DriverManager.getConnection(connectionDetails.get("url"), connectionDetails.get("user"), connectionDetails.get("password"));
    }

    private static Map<String, String> getConnectionDetails(){
        Map<String, String> connectionDetails = new HashMap<String, String>();
        connectionDetails.put("url", "jdbc:postgresql://localhost:5432/postgres");
        connectionDetails.put("user", "postgres");
        connectionDetails.put("password", "tahir123");
        return connectionDetails;
    }
}
