package ams;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Home extends JFrame implements ActionListener {
	JButton resetButton;
	JButton submit;
	JButton close;

	JTextField tfusername, tfpswd;

	public Home() {

		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ams/icons/desktop.jpg"));
		JLabel imageJLabel=new JLabel(i1);
		imageJLabel.setBounds(0, 0, 1600, 1000);
		add(imageJLabel);
		
		JLabel heading=new JLabel("KINGFISHER AIR LINES WELCOMES YOU...");
		heading.setBounds(500, 10, 900, 40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma",Font.PLAIN,36));
		imageJLabel.add(heading);  // add the font upon the image so call through image instance
		
		
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu details=new JMenu("Details");
		menuBar.add(details);
		
		JMenuItem flightDetails=new JMenuItem("Flight Details");
		flightDetails.addActionListener(this);
		details.add(flightDetails);
		
		
		JMenuItem customerDetails=new JMenuItem("Customer Details");
		customerDetails.addActionListener(this);
		details.add(customerDetails);
		
		JMenuItem bookFlight=new JMenuItem("Book Flight Ticket");
		bookFlight.addActionListener(this);
		details.add(bookFlight);
		
		JMenuItem journeyDetails=new JMenuItem("Journey Details");
		journeyDetails.addActionListener(this);
		details.add(journeyDetails);
		
		
		JMenuItem cancelDetails=new JMenuItem("Ticket Cancellation");
		cancelDetails.addActionListener(this);
		details.add(cancelDetails);
		
		JMenu ticket=new JMenu("Ticket");
		menuBar.add(ticket);
		
		JMenuItem boardingPass=new JMenuItem("Boarding Pass");
		boardingPass.addActionListener(this);
		ticket.add(boardingPass);
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); // to full screen
		setVisible(true); // to show the frame by default is false
	}

	public void actionPerformed(ActionEvent ae) {
		String text=ae.getActionCommand();
		
		if(text.equals("Customer Details")) {
			new AddCustomer();
		}
		else if (text.equals("Flight Details")) {
			new FlightInfo();
		}else if(text.equals("Journey Details")) {
			new JourneyDetails();
		}else if (text.equals("Book Flight Ticket")){
			new BookFlight();
		}else if (text.equals("Ticket Cancellation")) {
			new Cancel();
		}else if (text.equals("Boarding Pass")) {
			new BoardingPass();
		}
	}

	public static void main(String[] args) {

		new Home();
	}

}
