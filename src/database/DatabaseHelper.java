package database;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author acer
 */

public class DatabaseHelper {
    public static final String connectionUrl = "jdbc:sqlserver://localhost;"
            + "databaseName= QLSV2;user=sa;password=123;encrypt=false";
    
    public static Connection getDBConnect() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return conn;
    }
}
