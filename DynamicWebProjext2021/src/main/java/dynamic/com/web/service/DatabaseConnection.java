package dynamic.com.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
// This class can be used to initialize the database connection
public class DatabaseConnection {
    public static Connection initializeDatabase()
        throws SQLException,ClassNotFoundException 
    {
        // Initialize all the information regarding
        // Database Connection
       
        String dbURL = "jdbc:mysql://localhost:3306/";
        // Database name to access
        String dbName = "usersdb";
        String dbUsername = "root";
        String dbPassword = "karma";
  
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbURL + dbName,
                                                     dbUsername, 
                                                     dbPassword);
        return con;
    }
}