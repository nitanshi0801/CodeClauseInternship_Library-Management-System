/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library1;

/**
 *
 * @author Nitanshi Gupta
 */
import java.sql.*;

public class connectionclass {
 
     Connection con;
     Statement stmt;
     
public connectionclass()
{
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Nishi@1234");
        stmt = con.createStatement();
    }
    catch(Exception e){
     
        e.printStackTrace();
    }
    
    
}    
    public static void main(String[] args) {
        new connectionclass();
    }
}
