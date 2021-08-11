/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nvtan
 */
public class DBUtil {
    public static Connection getConnect(){
        Connection conn = null;
         try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String url = "jdbc:sqlserver://localhost:1433;databaseName=Reader_Management";
             conn = DriverManager.getConnection(url, "sa", "123");
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return conn;
    }  
}
