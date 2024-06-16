package certification.jdbc;

import java.util.HashMap;
import java.util.Map;

public class JdbcDriverManager {

    public static Map<String, String> getConnectionDetails(){
        Map<String, String> connectionDetails = new HashMap<String, String>();
        connectionDetails.put("url", "jdbc:postgresql://localhost:5432/postgres");
        connectionDetails.put("user", "postgres");
        connectionDetails.put("password", "tahir123");
        return connectionDetails;
    }
}
