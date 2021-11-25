/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;

/**
 *
 * @author gautam
 */
public class Select_jdbc {
    
    public static void main(String[] args) {
        try {
            Connection c=ConnectionProvider.getConnection();
            String query ="select * from teacher";
            
            Statement st=c.createStatement();
            ResultSet set=st.executeQuery(query);
            
            while(set.next()){
            //next() return either the true or false whenever the next row is exist
            //it return true and otherwise it return false
            int id=set.getInt(1);
            String name=set.getString(2);
            String subject=set.getString(3);
            
            System.out.println(id+name+subject );
            }
            
            
        } catch (Exception e) {
        }
    }
    
}
