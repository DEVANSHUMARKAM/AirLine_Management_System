package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    public Home() {
        // Get the default graphics device
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        // Get the current display mode
        DisplayMode dm = gd.getDisplayMode();

        // Get the screen width and height
        int screenWidth = dm.getWidth();
        int screenHeight = dm.getHeight();

        // Load the image
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("/airlinemanagementsystem/Homepage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Scale the image to fit the screen dimensions
        Image scaledImage = image.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);

        // Create a JLabel to hold the image
        JLabel label = new JLabel(new ImageIcon(scaledImage));

        // Set the layout to null for absolute positioning
        setLayout(null);
        label.setBounds(0, 0, screenWidth, screenHeight);
        add(label);

        // Set the frame properties
        setTitle("Full Screen Image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame
        setUndecorated(true); // Remove window decorations
        setVisible(true);
        
        
        JLabel heading = new JLabel("DEV AIRLINES WELCOMES YOU");
        heading.setBounds(600, 400, 1000, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Onyx", Font.BOLD, 40));
        label.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        
        JMenuItem flightdetails = new JMenu("Flight Details");
        details.add(flightdetails);
        
        JMenuItem customerdetails = new JMenu("Add Customer Details");
        details.add(customerdetails);
        
        JMenuItem bookflight = new JMenu("Book Flight");
        details.add(bookflight);
        
        JMenuItem journeydetails = new JMenu("Journey Details");
        details.add(journeydetails);
        
        JMenuItem ticketcancellation = new JMenu("Cancel Ticket");
        details.add(ticketcancellation);
        
        JMenuItem ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingpass = new JMenu("Boarding Pass");
        ticket.add(boardingpass);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Placeholder for action events
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}