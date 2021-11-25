/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.FileInputStream;
import java.sql.*;

/**
 *
 * @author gautam
 */
public class Insert_Image {
    public static void main(String[] args) throws SQLException{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/youtube";
        String user="root";
        String password="3222";
        Connection con=DriverManager.getConnection(url, user, password);
        String query2="insert into images(pic) values(?)";
        
   
      
        
        PreparedStatement p=con.prepareStatement(query2);
            FileInputStream f=new FileInputStream("C:\\Users\\gautam\\Documents\\NetBeansProjects\\Sql\\src\\sql\\profile.jpeg");
            p.setBinaryStream(1, f,f.available());
            p.executeUpdate();
            System.out.println("inserted..");
            con.close();
        }catch(Exception e){
        System.out.println(e);
        }
    }
}
