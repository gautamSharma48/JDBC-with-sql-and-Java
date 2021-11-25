/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author gautam
 */
import java.sql.*;

public class ConnectionProvider {
    private static Connection con;
    
    public static Connection getConnection(){
        try {
            if(con==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/youtube";
            String user="root";
            String password="3222";
            con=DriverManager.getConnection(url, user, password);
            return con;
            }
        } catch (Exception e) {
        }
        return con;
    }
    
}
