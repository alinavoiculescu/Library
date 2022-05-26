package service.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionService {
    private static Connection connection = null;

    private DatabaseConnectionService() {
    }

    public static Connection getDatabaseConnection() throws SQLException {
        if ((connection == null) || !(connection.isValid(2))) {
            try {
                String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
                String DATABASE_USERNAME = "system";
                String DATABASE_PASSWORD = "oracle";
                Class.forName("oracle.jdbc.OracleDriver");
                connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
