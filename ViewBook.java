
package library1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewBook extends JFrame
{
    String x[]={"ID","Book No","Book name","Author","Publisher","Quantity","Issued","Date"};
    JButton bt;
    String y[][]= new String[20][8];
    int i =0,j=0;
    JTable t;
    Font f,f1;
    
    ViewBook()
    {
        super(" Book Information");
        setLocation(1,1);
        setSize(1000,400);        
        
        f = new Font("Arial",Font.BOLD,15);
        
        try{
             connectionclass obj = new connectionclass();
             String q = "select * from addbook ";
             ResultSet rest = obj.stmt.executeQuery(q);
             while(rest.next()){
                 y[i][j++]=rest.getString("id"); 
                 y[i][j++]=rest.getString("bookNo"); 
                 y[i][j++]=rest.getString("bookname"); 
                 y[i][j++]=rest.getString("author"); 
                 y[i][j++]=rest.getString("publisher"); 
                 y[i][j++]=rest.getString("quantity"); 
                 y[i][j++]=rest.getString("issuebook"); 
                 y[i][j++]=rest.getString("date"); 
                 i++;
                 j=0;
             }
            t= new JTable(y,x);
            t.setFont(f);
         }
         catch(Exception ex){
             ex.printStackTrace();
             
         }
        JScrollPane sp = new JScrollPane(t);
         add(sp);
         
    }
    public static void main(String[] args) {
        new ViewBook().setVisible(true);
    }
    
    
    
}
