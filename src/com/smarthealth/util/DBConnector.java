package com.smarthealth.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnector {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/smarthealth";
        String user = "root";
        String password = "1608@Anmol";

        return DriverManager.getConnection(url,user,password);
    }
    public static void main(String[] args) {
        try{
            Connection conn = getConnection();
            System.out.println("Connected to the database successfully");
            conn.close();
        }catch (SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
