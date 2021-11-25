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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class updateJdbc {
    public static void main(String[] args) throws IOException, SQLException {
        Connection con=ConnectionProvider.getConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name");
        String name=br.readLine();
        System.out.println("Enter Subject");
        String subject=br.readLine();
        System.out.println("Enter id");
        int id=Integer.parseInt(br.readLine());
        
        
        String query="update teacher set name=?, subject=? where id=?";
         PreparedStatement p=con.prepareStatement(query);
          p.setString(1, name);
          p.setString(2, subject);
          p.setInt(3, id);
          
         p.executeUpdate();
         System.out.println("done");
         con.close();
        
    }
    
}
