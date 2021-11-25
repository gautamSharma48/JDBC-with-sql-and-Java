/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author gautam
 */
public class Insert_Large_Images {
    
    public static void main(String[] args) {
        try {
        Connection c=ConnectionProvider.getConnection();
        
        String q="insert into images(pic) values(?)";
        
        PreparedStatement p=c.prepareStatement(q);
        
        JFileChooser jf=new JFileChooser();
        jf.showOpenDialog(null);
        File file=jf.getSelectedFile();
            FileInputStream fs=new FileInputStream(file);//converting into byte
        
        p.setBinaryStream(1,fs , fs.available());
        p.executeUpdate();
        System.out.println("done");
            JOptionPane.showMessageDialog(null, "Success");
        } catch (Exception e) {
        }
        
    }
    
}
