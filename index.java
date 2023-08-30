/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class index extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4;
    JButton btn1,btn2;
    JPanel p1,p2,p3;
    Font f,f1;
    
    index(){
        
        super("Login Page");
        setLocation(500,350);
        setSize(500,200);
        
        f=new Font("Arial",Font.BOLD,25);
         f1=new Font("Arial",Font.BOLD,20);
         
         
         l1=new JLabel ("Admin Login");
         l2 = new JLabel("Librarian Login");
         l3 = new JLabel("Library Management");
         
         btn1 =new  JButton("Login");
         btn2 = new JButton("Login");
         
         btn1.addActionListener(this);
          btn2.addActionListener(this);
         
         
         ImageIcon img =new ImageIcon(ClassLoader.getSystemResource("library1/icon/login.jpg"));
         Image i = img.getImage().getScaledInstance(130,120,Image.SCALE_DEFAULT);
         ImageIcon img2 = new ImageIcon(i);
         l4= new JLabel(img2);
         
         l1.setFont(f1);
         l2.setFont(f1);
         l3.setFont(f);
         btn1.setFont(f1);
         btn2.setFont(f1);
         
         l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setForeground(Color.white);
         
         p1=new JPanel();
         p1.setLayout(new GridLayout(2,2,10,10));
         p1.add(l1);
         p1.add(btn1);
         p1.add(l2);
         p1.add(btn2);
         
          p2=new JPanel();
         p2.setLayout(new GridLayout(1,1,10,10));
         p2.add(l4);
         
          p3=new JPanel();
         p3.setLayout(new GridLayout(1,1,10,10));
         p3.add(l3);
         p3.setBackground(Color.blue);
         
         setLayout(new BorderLayout(10,10));
         add(p3,"North");
         add(p2,"West");
         
         add(p1,"Center");
         
         
         
         
    }
    public void actionPerformed(ActionEvent e)
    {
           
        if(e.getSource()==btn1)
        {
            //System.out.println("Admin login"); 
          new Admin().setVisible(true);
            this.setVisible(false);
            
        }
        
        if(e.getSource()==btn2)
        {
            //System.out.println("Librarian login");
         new Librarian().setVisible(true);
            this.setVisible(false);
        }
        
        
        
        
    }
            
    public static void main(String[] args) {
        
       new index() .setVisible(true);
    }
    
}
