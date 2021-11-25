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
import java.awt.Image;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class Helper {
    
    public static ImageIcon getImageIconById(int id,Connection con){
    ImageIcon icon=null;
    
        try {
            
            String q="Select pic from images where id=?";
            
            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1,id);
            ResultSet set=ps.executeQuery();
            if(set.next()){
            Blob b=set.getBlob("pic");
            InputStream is=b.getBinaryStream();
            Image image =ImageIO.read(is);
            icon=new ImageIcon(image);
            }
        } catch (Exception e) {
        }
        return icon;
    }
}
