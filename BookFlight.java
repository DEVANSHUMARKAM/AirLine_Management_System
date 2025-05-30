package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField  tfadhaar;
    JLabel tfname,tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton bookflight, flight, fetchButton;
    Choice source , destination;
    JDateChooser dcdate;
    
    
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("BOOK YOUR FLIGHT");
        heading.setBounds(300, 20, 500, 35);
        heading.setFont(new Font("Onyx", Font.BOLD, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        //Adhaar Number
        JLabel lbladhaar = new JLabel("AADHAAR");
        lbladhaar.setBounds(60, 80, 170, 25);
        lbladhaar.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbladhaar);
        
        tfadhaar = new JTextField();
        tfadhaar.setBounds(220, 80, 200, 25);
        add(tfadhaar);
        
        fetchButton = new JButton("Fetch");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(440, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        //Passenger Name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setFont(new Font("Onyx", Font.BOLD, 20));
        tfname.setBounds(220, 130, 250, 25);
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
        
        
        
        //Address
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(60, 230, 170, 25);
        lbladdress.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setFont(new Font("Onyx", Font.BOLD, 20));
        tfaddress.setBounds(220, 230, 250, 25);
        add(tfaddress);
        
        //Gender
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setFont(new Font("Onyx", Font.BOLD, 20));
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);
       
        JLabel lblsource = new JLabel("SOURCE");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(215, 330, 200, 25);
        add(source);
        
        JLabel lbldest = new JLabel("DESTINATION");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbldest);

        destination = new Choice();
        destination.setBounds(215, 380, 200, 25);
        add(destination);


        try{
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        
        //Save button
        flight = new JButton("FIND FLIGHTS");
        flight.setBackground(Color.black);
        flight.setForeground(Color.white);
        flight.setBounds(220, 430, 150, 30);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(60, 465, 150, 30);
        lblfname.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setFont(new Font("Onyx", Font.BOLD, 20));
        labelfname.setBounds(220, 465, 100, 30);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(60, 510, 150, 30);
        lblfcode.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setFont(new Font("Onyx", Font.BOLD, 20));
        labelfcode.setBounds(220, 510, 150, 30);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("DATE OF TRAVEL");
        lbldate.setBounds(60, 555, 200, 30);
        lbldate.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbldate);
        
        
        dcdate = new JDateChooser();
        dcdate.setBounds(250, 555, 200, 30);
        add(dcdate);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Images/Bookflight.jpg"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(500, 100, 320, 600);
        add(lblimage);
        
        bookflight = new JButton("BOOK FLIGHT");
        bookflight.setBackground(Color.black);
        bookflight.setForeground(Color.white);
        bookflight.setBounds(230, 650, 250, 50);
        bookflight.addActionListener(this);
        add(bookflight);
        
        
        
        
        setSize(900, 800);
        setLocation(300, 150);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fetchButton){
        String aadhaar = tfadhaar.getText();
        
        try{
            Conn conn = new Conn();
            
            String query = "select * from passenger where aadhaar = '"+aadhaar+"'";
            
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
            }else{
                
            JOptionPane.showMessageDialog(null,"Please Enter Correct aadhaar!!!");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource() == flight){
        String src = source.getSelectedItem();
        String dest = destination.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";
            
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));
            }else{
                
            JOptionPane.showMessageDialog(null,"Please Enter Correct source and destination!!!");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }else{
        Random random = new Random();
        String aadhaar = tfadhaar.getText();
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String flightname = labelfname.getText();
        String flightcode = labelfcode.getText();
        String src = source.getSelectedItem();
        String des = destination.getSelectedItem();
        String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
         
                 try{
            Conn conn = new Conn();
            
            String query = "insert into reservation values('PNR-"+random.nextInt(100000)+"', 'Ticket-"+random.nextInt(10000)+"','"+aadhaar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Ticket Booked Successfully!!!");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }

    public static void main(String[] args){
        new BookFlight();
    }

}
