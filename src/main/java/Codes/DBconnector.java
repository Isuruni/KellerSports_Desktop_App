
package Codes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Pramodhi
 */
public class DBconnector {
    public static Connection connect() {
       Connection conn=null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3308/KellerSports","root","");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Connection failed");
           System.exit(0);
       }
       return conn;
    }
    
}
