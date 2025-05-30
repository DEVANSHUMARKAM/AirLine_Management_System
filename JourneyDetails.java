package airlinemanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
    JTable table;
    JTextField pnr;
    JButton show;
    
    public JourneyDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Oxyn", Font.BOLD, 25));
        lblpnr.setBounds(50,50,240, 25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(250, 50, 120, 30);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(400, 50, 120, 30);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100, 800, 150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        
        
        setSize(800, 500);
        setLocation(400, 150);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No information found!!!");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new JourneyDetails();
    }
    
}
