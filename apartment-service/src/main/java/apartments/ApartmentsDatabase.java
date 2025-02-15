package apartments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ApartmentsDatabase {
    private static final String DB_PATH = System.getenv("APARTMENT_DB_PATH") != null ?
            System.getenv("APARTMENT_DB_PATH") : "apartments.db";


    // Connect to SQLite database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
    }

    // Initialize the database (create tables if they don't exist)
    public static void initialize() {
        try (Connection conn = getConnection(); // This line ensures the connection is open
             Statement stmt = conn.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS apartments (" +
                    "id TEXT PRIMARY KEY, " +
                    "name TEXT, " +
                    "address TEXT, " +
                    "noiseLevel INTEGER, " +
                    "floor INTEGER)";
            stmt.execute(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

