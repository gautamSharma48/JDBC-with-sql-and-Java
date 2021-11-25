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
import java.sql.*;
public class Sql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            // TODO code application logic here

          Connection con=ConnectionProvider.getConnection();
            Statement st=con.createStatement();
           
           String q="Select * from teacher";
           ResultSet s=st.executeQuery(q);
           s.next();
           String sname=s.getString("name");
           
           System.out.println(sname);
           
            con.close();
            
        } catch (Exception ex) {
            System.out.println(ex);
             }
        
    }
    
}
