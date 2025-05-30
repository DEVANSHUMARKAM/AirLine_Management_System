package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField  tfpnr;
    JLabel tfname,tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton fetchButton;
    
    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("BOARDING PASS");
        heading.setBounds(300, 20, 510, 45);
        heading.setFont(new Font("Onyx", Font.BOLD, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lbladhaar = new JLabel("PNR Details");
        lbladhaar.setBounds(60, 100, 170, 25);
        lbladhaar.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbladhaar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 200, 25);
        add(tfpnr);
        
        fetchButton = new JButton("ENTER");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(440, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        //Passenger Name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setFont(new Font("Onyx", Font.BOLD, 20));
        tfname.setBounds(220, 140, 250, 25);
        add(tfname);
        
        //Nationality
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setFont(new Font("Onyx", Font.BOLD, 20));
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("SOURCE");
        lbladdress.setBounds(60, 230, 170, 25);
        lbladdress.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setFont(new Font("Onyx", Font.BOLD, 20));
        lblsrc.setBounds(220, 230, 250, 25);
        add(lblsrc);
        
        //Gender
        JLabel lblgender = new JLabel("DESTINATION");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setFont(new Font("Onyx", Font.BOLD, 20));
        lbldest.setBounds(220, 280, 150, 25);
        add(lbldest);
        
        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(60, 330, 150, 30);
        lblfname.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setFont(new Font("Onyx", Font.BOLD, 20));
        labelfname.setBounds(220, 330, 100, 30);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(350, 330, 150, 30);
        lblfcode.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setFont(new Font("Onyx", Font.BOLD, 20));
        labelfcode.setBounds(500, 330, 100, 30);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("DATE");
        lbldate.setBounds(60, 380, 200, 30);
        lbldate.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setFont(new Font("Onyx", Font.BOLD, 20));
        labeldate.setBounds(220, 380, 200, 30);
        add(labeldate);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/devAirlines.jpg"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 0, 300, 400);
        add(lblimage);
        
 
        
        
        
        
        setSize(900, 500);
        setLocation(300, 150);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();
        
        try{
            Conn conn = new Conn();
            
            String query = "select * from reservation where PNR = '"+pnr+"'";
            
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("src"));
                lbldest.setText(rs.getString("des"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
            }else{
                
            JOptionPane.showMessageDialog(null,"Please Enter Correct PNR!!!");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new BoardingPass();
    }

}
