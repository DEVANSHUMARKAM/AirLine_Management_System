package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField  tfpnr;
    JLabel tfname,cancellationno, lblfcode, lbldate;
    JButton flight, fetchButton;
    JDateChooser dcdate;
    
    
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(300, 20, 500, 35);
        heading.setFont(new Font("Onyx", Font.BOLD, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        
        //Adhaar Number
        JLabel lbladhaar = new JLabel("PNR Number");
        lbladhaar.setBounds(60, 80, 170, 25);
        lbladhaar.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbladhaar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 200, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(440, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        //Passenger Name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 150, 150, 25);
        lblname.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setFont(new Font("Onyx", Font.BOLD, 20));
        tfname.setBounds(220, 150, 250, 25);
        add(tfname);
        
        //Nationality
        JLabel lblnationality = new JLabel("Cancellation");
        lblnationality.setBounds(60, 220, 150, 25);
        lblnationality.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblnationality);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(60, 240, 150,25);
        lblnumber.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblnumber);
        
        cancellationno = new JLabel(""+ random.nextInt(10000));
        cancellationno.setFont(new Font("Onyx", Font.BOLD, 20));
        cancellationno.setBounds(220, 240, 150, 25);
        add(cancellationno);
        
        //Address
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60, 300, 170, 25);
        lbladdress.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbladdress);
        
        lblfcode = new JLabel();
        lblfcode.setFont(new Font("Onyx", Font.BOLD, 20));
        lblfcode.setBounds(220, 300, 250, 25);
        add(lblfcode);
        
        //Gender
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60, 350, 150, 25);
        lblgender.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblgender);
        
        lbldate = new JLabel();
        lbldate.setFont(new Font("Onyx", Font.BOLD, 20));
        lbldate.setBounds(220, 350, 150, 25);
        add(lbldate);
       
        
        //Save button
        flight = new JButton("CANCEL");
        flight.setBackground(Color.black);
        flight.setForeground(Color.white);
        flight.setBounds(220, 400, 150, 30);
        flight.addActionListener(this);
        add(flight);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Cancel.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(490, 80, 410, 600);
        add(lblimage);
        
        setSize(920, 600);
        setLocation(300, 150);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fetchButton){
        String pnr = tfpnr.getText();
        
        try{
            Conn conn = new Conn();
            
            String query = "select * from reservation where PNR = '"+pnr+"'";
            
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                lblfcode.setText(rs.getString("flightcode"));
                lbldate.setText(rs.getString("ddate"));
            }else{
                
            JOptionPane.showMessageDialog(null,"Please Enter Correct PNR!!!");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource() == flight){
        String pnr = tfpnr.getText();
        String name = tfname.getText();
        String cancelno = cancellationno.getText();
        String fcode = lblfcode.getText();
        String date = lbldate.getText();
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";
            
            conn.s.executeUpdate(query);
            conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
            
            JOptionPane.showMessageDialog(null,"Ticket Cancelled!!!");
            setVisible(true);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }
    public static void main(String[] args){
        new Cancel();
    }
}
