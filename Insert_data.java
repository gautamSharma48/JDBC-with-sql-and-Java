/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author gautam
 */
public class Insert_data {
    
    public static void main(String args[]) throws SQLException, IOException{
        //prepared statement:insert
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/youtube";
            String user="root";
            String password="3222";
            Connection con=DriverManager.getConnection(url, user, password);
            
            String q="insert into teacher(name,subject) values(?,?)";
            
            //get a prepared statement
           PreparedStatement p= con.prepareStatement(q);
           //set the values to query
           /*1.static value
           p.setString(1, "uttam");
           p.setString(2,".NET");
           */
           //Dynami value
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name");
            String name=br.readLine();
            System.out.println("Enter Subject");
            String subject=br.readLine();
             p.setString(1, name);
           p.setString(2,subject);
           p.executeUpdate();
           
            System.out.println("inserted..");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Insert_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
