package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/promanage";
    private static final String USER = "postgres";
    private static final String PASS = "your_password";

    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
