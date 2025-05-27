package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener {
    
    public Home(){
        setLayout(null);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Homepage.jpg"));
        JLabel image = new JLabel(I1);
        image.setBounds(0,0, 1600, 800);
        add(image);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args){
        new Home();
    }
}
