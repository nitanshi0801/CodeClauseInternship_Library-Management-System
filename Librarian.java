
package library1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Librarian extends JFrame implements ActionListener 
        {
     JLabel l1,l2,l3;
    JButton btn1,btn2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1;
    JPasswordField pf1;    
    
   Librarian(){
        
        super("Librarian  Login Page");
        setLocation(450,400);
        setSize(500,200);
        
        f=new Font("Arial",Font.BOLD,25);
         f1=new Font("Arial",Font.BOLD,20);
         
         l1=new JLabel ("Librarian Login");
         l2 = new JLabel("Name");
         l3 = new JLabel("Password");
         
         btn1 = new JButton("Login");
         btn2 = new JButton("Cancle");
         
         btn1.addActionListener(this);
          btn2.addActionListener(this);
         
         tf1= new JTextField();
         pf1 = new JPasswordField();
         
         l1.setFont(f);
         l2.setFont(f1);
         l3.setFont(f1);
         btn1.setFont(f1);
         btn2.setFont(f1);
         tf1.setFont(f1);
         pf1.setFont(f1);         
         
         l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.white);
        
         p1=new JPanel();
         p1.setLayout(new GridLayout(1,1,10,10));
         p1.add(l1);
         p1.setBackground(Color.blue);
        
          p2=new JPanel();
         p2 .setLayout(new GridLayout(3,2,10,10));
         p2.add(l2);
         p2.add(tf1);
         p2.add(l3);
         p2.add(pf1);
            p2.add(btn1);
               p2.add(btn2);
         
         setLayout(new BorderLayout(10,10));
         add(p1,"North");
         add(p2,"Center");
    
}
   public void actionPerformed(ActionEvent e){
       
       String name=tf1.getText();
    String pass = pf1.getText();
   if(e.getSource()==btn1){
        
        try{
             connectionclass obj = new connectionclass();
             String s = "select name,password from librarian where name='"+name+"' and password='"+pass+"'";
              ResultSet rs =  obj.stmt.executeQuery(s);
              if(rs.next()){
                    //System.out.println("librarian Section");
              new LibrarianSection().setVisible(true);
                  this.setVisible(false);
                      
              }
              else{
                  JOptionPane.showMessageDialog(null,"Your name and password is incorrect");
                  this.setVisible(false);
              }
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    if(e.getSource()==btn2){
        
        this.setVisible(false);
    }
    
}

  public static void main(String[] args) {
        
       new Librarian() .setVisible(true);
    }
    
}
   

