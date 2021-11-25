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
import java.util.logging.Level;
import java.util.logging.Logger;
public class Create_Table {
    
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/youtube?zeroDateTimeBehavior=convertToNull";
            String user="root";
            String password="3222";
            Connection con=DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            String quey="Create Table Teacher(id int(20) primary key auto_increment,name varchar(50),subject varchar(50)) ";
            st.executeUpdate(quey);
            System.out.println("table created in database");
            con.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Create_Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
