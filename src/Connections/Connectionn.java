package Connections;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connectionn {
    //OBJECTS
    static Methods.Sound sound = new Methods.Sound();
    
    //VARIABLES
    static Connection contact = null;

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=bd_LGD";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            sound.error();
            JOptionPane.showMessageDialog(null, "CONNECTION NOT ESTABLISHED" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        try {
            contact = DriverManager.getConnection(url,"sa","12345");
        } catch (SQLException e) {
            sound.error();
            JOptionPane.showMessageDialog(null, "CONNECTION NOT ESTABLISHED" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return contact;
    }
    
//    public static void enter(String user, String password){
//        Connectionn.user = user; 
//        Connectionn.password = password;
//    }
//    
//    public static boolean status(){
//        return status;
//    }

    public static ResultSet consultation(String consultation) {
        Connection con = getConnection();
        try {
            Statement declare;
            declare = con.createStatement();
            ResultSet answer = declare.executeQuery(consultation);
            return answer;
        } catch (SQLException e) {
            sound.error();
            JOptionPane.showMessageDialog(null, "CONNECTION NOT ESTABLISHED" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
