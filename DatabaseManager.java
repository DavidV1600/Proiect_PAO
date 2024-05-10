package Proiect_PAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "c##Piele";
    private static final String PASSWORD = "20030616";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            // Close resources in case of exception
            closeResultSet(resultSet);
            closeStatement(statement);
            closeConnection(connection);
            throw e; // Re-throw the exception
        }
    }

    // Utility methods to close resources
    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
        }
    }

    private static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error closing Statement: " + e.getMessage());
            }
        }
    }
}
