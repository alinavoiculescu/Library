package service.database;

import mapper.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryExecutorService {

    private static final Connection connection;

    static {
        try {
            connection = DatabaseConnectionService.getDatabaseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Used for SELECT queries
     */
    public static List<Object> executeReadQuery(String sql, RowMapper<?> rowMapper) {
        Statement stmt = null;
        List<Object> result = new ArrayList<>();
        try {
            stmt = DatabaseConnectionService.getDatabaseConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(rowMapper.mapRow(rs));
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            } // nothing we can do
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Used for INSERT, UPDATE, DELETE sql queries
     */
    public static void executeUpdateQuery(String sql) {
        try (Statement stmt = DatabaseConnectionService.getDatabaseConnection().createStatement()) {

            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // nothing we can do
    }
}
