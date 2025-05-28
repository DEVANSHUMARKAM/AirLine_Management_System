
package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname, tfphone, tfadhaar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD PASSENGER DETAILS");
        heading.setBounds(260, 20, 500, 35);
        heading.setFont(new Font("Onyx", Font.BOLD, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        //Passenger Name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 250, 25);
        add(tfname);
        
        //Nationality
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
        //Adhaar Number
        JLabel lbladhaar = new JLabel("AADHAAR");
        lbladhaar.setBounds(60, 180, 170, 25);
        lbladhaar.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbladhaar);
        
        tfadhaar = new JTextField();
        tfadhaar.setBounds(220, 180, 200, 25);
        add(tfadhaar);
        
        //Address
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(60, 230, 170, 25);
        lbladdress.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 250, 25);
        add(tfaddress);
        
        //Gender
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblgender);
       
        ButtonGroup gendergroup = new ButtonGroup();
        
        //Male
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(220, 280, 100, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        //Female
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(350, 280, 100, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        //Others
//        JRadioButton rbothers = new JRadioButton("OTHERS");
//        rbothers.setBounds(480, 280, 100, 25);
//        rbothers.setBackground(Color.white);
//        add(rbothers);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
//        gendergroup.add(rbothers);
        
        //Phone number
        JLabel lblphone = new JLabel("PH. NUMBER");
        lblphone.setBounds(60, 330, 170, 25);
        lblphone.setFont(new Font("Onyx", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
//        //Email address
//        JLabel lblemail = new JLabel("EMAIL");
//        lblemail.setBounds(60, 380, 200, 25);
//        lblemail.setFont(new Font("Onyx", Font.BOLD, 20));
//        add(lblemail);
//        
//        tfemail = new JTextField();
//        tfemail.setBounds(220, 380, 170, 25);
//        add(tfemail);
        
        //Save button
        JButton save = new JButton("SAVE");
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.setBounds(220, 450, 150, 30);
        save.addActionListener(this);
        add(save);
        
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Passenger.jpg"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(500, 80, 320, 500);
        add(lblimage);
        
        
        
        
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhaar = tfadhaar.getText();
//        String email = tfemail.getText();
        String gender = null;
        if(rbmale.isSelected()){
            gender = "MALE";
        }else{
            gender = "FEMALE";
        }
        
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"','"+nationality+"','"+aadhaar+"','"+phone+"','"+address+"','"+gender+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Passenger Details added successfully!!!");
            
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new AddCustomer();
    }

}
