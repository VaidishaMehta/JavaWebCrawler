package webcrawler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    // JDBC URL, username, and password of PostgreSQL server
    private static final String URL = "jdbc:postgresql://localhost:5432/webCrawler_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    // Method to establish a database connection
    public static Connection connect() {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your project's requirements
            return null;
        }
    }

    // Method to close the database connection
    public static void close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your project's requirements
        }
    }

    // This is the entry point of the program
    public static void main(String[] args) {
        // Example of using the database connection
        Connection connection = connect();

        if (connection != null) {
            System.out.println("Connected to the database!");

            // Perform any testing or initialization tasks using the connection here

            // Close the connection when done
            close(connection);
            System.out.println("Connection closed.");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}
