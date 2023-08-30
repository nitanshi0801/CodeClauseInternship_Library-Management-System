
package library1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteLibrarian extends JFrame implements ActionListener {
   
    String x[]={"ID","Name","Password","Email","Contact","Adress","City"};
    JButton btn1;
    JLabel l1;
    String y[][]= new String[20][7];
    int i =0,j=0;
    JTable t;
    Font f,f1;
    JTextField tf1;
    JPanel p1;
    
        DeleteLibrarian(){
            
        super(" Libraraian Information");
        setLocation(1,1);
        setSize(1000,400);
        
         f=new Font("Arial",Font.PLAIN,15);
         
         try{
             connectionclass obj = new connectionclass();
             String q = "select * from librarian ";
             ResultSet rest = obj.stmt.executeQuery(q);
             while(rest.next()){
                 y[i][j++]=rest.getString("Lid"); 
                 y[i][j++]=rest.getString("Name"); 
                 y[i][j++]=rest.getString("Password"); 
                 y[i][j++]=rest.getString("Email"); 
                 y[i][j++]=rest.getString("Contact"); 
                 y[i][j++]=rest.getString("Address"); 
                 y[i][j++]=rest.getString("City"); 
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
         
         l1= new JLabel("Delete Librarian");
         tf1= new JTextField();
         btn1= new JButton("Delete");
         btn1.addActionListener(this);
         
         l1.setFont(f);
          tf1.setFont(f);
           btn1.setFont(f);
           
           p1= new JPanel();
           p1.setLayout(new GridLayout(1,3,10,10));
           p1.add(l1);
           p1.add(tf1);
           p1.add(btn1);
           
           setLayout(new BorderLayout(10,10));
           add(sp,"Center");
           add(p1,"South");
                  
            }
         public void actionPerformed(ActionEvent e){
         
             if(e.getSource()==btn1)
             {
    //gettext gives the string value so integer.parseint is used for converting the string into the integer
           int id = Integer .parseInt(tf1.getText());   
          
           try{
               connectionclass obj = new connectionclass();
               String q = "delete from librarian where lid='"+id+"'";
               int res = obj.stmt.executeUpdate(q);
               if(res==1)
               {
                   JOptionPane.showMessageDialog(null,"Your data is Successfully deleted");
                   this.setVisible(false);
                   new DeleteLibrarian().setVisible(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Your data is not Successfully deleted");
                    this.setVisible(false);
                   new DeleteLibrarian().setVisible(true);
               }
           }
           catch(Exception ex)
           {            
               ex.printStackTrace();
           }
             }
         }
         public static void main(String[] args) {
        
             new DeleteLibrarian().setVisible(true);
    }
    
}

