
package library1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener
{
    
    JLabel l1,l2,l3;
    JButton btn1,btn2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1,tf2;
    
    ReturnBook(){
        
        super("Return Book");
        setLocation(0,0);
        setSize(650,400);
        
         f=new Font("Arial",Font.BOLD,25);
         f1=new Font("Arial",Font.BOLD,20);
         
         l1 = new JLabel ("Return Book");
         l2 = new JLabel("Book No");
         l3 = new JLabel("Student Id");
         
         l1.setForeground(Color.WHITE);
          l1.setHorizontalAlignment(JLabel.CENTER);
          
         tf1=new JTextField();
         tf2=new JTextField();
         
          btn1= new JButton("Return Book");
         btn2 = new JButton("Cancel");
         
         btn1.setFont(f1);
         btn2.setFont(f1);
         
         btn1.addActionListener(this);
           btn2.addActionListener(this);
           
           l1.setFont(f);
         l2.setFont(f1);
         l3.setFont(f1);
         
          tf1.setFont(f1);
         tf2.setFont(f1);
         
           p1= new JPanel();
           p1.setLayout(new GridLayout(1,1,10,10));
           p1.add(l1);
           p1.setBackground(Color.BLUE);
           
            p2= new JPanel();
           p2.setLayout(new GridLayout(3,2,10,10));
           p2.add(l2);
           p2.add(tf1);
           p2.add(l3);
           p2.add(tf2);
           p2.add(btn1);
            p2.add(btn2);
         
            setLayout(new BorderLayout(10,10));
          add(p1,"North");
          add(p2,"Center");
        }
     public void actionPerformed(ActionEvent e)
     {
         String bookno=tf1.getText();
         int stuid = Integer.parseInt(tf2.getText());
         
         if(e.getSource()==btn1)
        {
            try
            {
                connectionclass obj = new connectionclass();
             String q = "delete from issuebook where bookno = '"+bookno+"' and studentId='"+stuid+"'";
              int res =  obj.stmt.executeUpdate(q);
             if(res==0)
             {
                 JOptionPane.showMessageDialog(null,"Book is not issue");
                 this.setVisible(false);
             }
             else
             {
                 String q1= "update addbook set issuebook = issuebook-1 where BookNo='"+bookno+"'";
                 String q2= "update addbook set quantity = quantity+1 where BookNo='"+bookno+"'";
                 int aaa= obj.stmt.executeUpdate(q1);
                  int a= obj.stmt.executeUpdate(q2);
                 if(aaa==1)
                 {
                      if(aaa==1)
                      {
                     JOptionPane.showMessageDialog(null,"Your book successfully updated");
                     this.setVisible(false);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"Please,fill all details Successfully");
                 }
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Please,fill all details Successfully");
             }
                 
             }
     }
         catch(Exception ee)
                 {
                 ee.printStackTrace();
                 }
                 
                 }
     if(e.getSource()==btn2)
     {
         JOptionPane.showMessageDialog(null,"Are you sure you want to close it ");
         this.setVisible(false);
     }
}
public static void main(String[] args)
{
new ReturnBook().setVisible(true);
}
}
