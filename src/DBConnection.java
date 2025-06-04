import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nafis
 */
public class DBConnection {
    public static Connection connect() {
        Connection conn = null;

        // Replace with your details
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Loketku;encrypt=true;trustServerCertificate=true";
        String user = "SA";
        String password = "Password123";

        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Connect to the database
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to SQL Server successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("SQLServer JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }

        return conn;
    }
}
