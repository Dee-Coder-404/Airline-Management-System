package ams;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener {
	
	JTextField tadh;
	JLabel tfnam,tfnationality,taddress,tgender,tfname,tcode;
	JButton bookflight,fButton,flight;
	Choice source,destination;
	JDateChooser dateChooser;
	 
	public BookFlight() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("BOOK FLIGHT");
		heading.setBounds(420, 20, 500, 35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		
		JLabel lbladhaar=new JLabel("Adhaar Number");
		lbladhaar.setBounds(40, 80, 150, 25);
		lbladhaar.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbladhaar.setForeground(Color.BLACK);
		add(lbladhaar);
	    tadh=new JTextField();
		tadh.setBounds(220, 80, 150, 25);
		add(tadh);
		
		
		fButton=new JButton("Fetch");
		fButton.setBounds(380, 80, 120, 25);
		fButton.setBackground(Color.BLACK);
		fButton.setForeground(Color.WHITE);
		fButton.addActionListener(this);
		add(fButton);
		
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(60, 130, 150, 25);
		lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblname.setForeground(Color.BLACK);
		add(lblname);
		tfnam=new JLabel(); // to get the data from the userdata
		tfnam.setBounds(220, 130, 150, 25);
		add(tfnam);
		
		JLabel lblnationality=new JLabel("Nationality ");
		lblnationality.setBounds(60, 180, 150, 25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblnationality.setForeground(Color.BLACK);
		add(lblnationality);
		 tfnationality=new JLabel();
		tfnationality.setBounds(220, 180, 150, 25);
		add(tfnationality);
		
		
		JLabel lbladdress=new JLabel("Address");
		lbladdress.setBounds(60, 230, 150, 25);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbladdress.setForeground(Color.BLACK);
		add(lbladdress);
		taddress=new JLabel();
		taddress.setBounds(220, 230, 150, 25);
		add(taddress);
		
		JLabel lblgender=new JLabel("Gender");
		lblgender.setBounds(60, 280, 150, 25);
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblgender.setForeground(Color.BLACK);
		add(lblgender);
		tgender=new JLabel();
		tgender.setBounds(220, 280, 150, 25);
		add(tgender);
		
		JLabel lblsource=new JLabel("Source");
		lblsource.setBounds(60, 330, 150, 25);
		lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblsource.setForeground(Color.BLACK);
		add(lblsource);
		
		// choice is to create dropdown to select flights
		source=new Choice();
		source.setBounds(220, 330, 120, 25);
		add(source);
	
		JLabel lbldestination=new JLabel("Destination");
		lbldestination.setBounds(60, 380, 150, 25);
		lbldestination.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbldestination.setForeground(Color.BLACK);
		add(lbldestination);
		
		destination=new Choice();
		destination.setBounds(220, 380, 120, 25);
		add(destination);
		
		// to get values from the database to the drop down box
		try {
			Conn conn=new Conn();
			
			String query="select * from flight";
			ResultSet rSet=conn .stm.executeQuery(query);
			
			while (rSet.next()) {
				source.add(rSet.getString("source"));
				destination.add(rSet.getString("destination"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		flight=new JButton("Fetch Flights");
		flight.setBackground(Color.BLACK);
		flight.setForeground(Color.WHITE);
		flight.setBounds(380, 380, 120, 25);
		flight.addActionListener(this);
		add(flight);
		
		
		JLabel lblfname=new JLabel("Flight Name");
		lblfname.setBounds(60, 430, 150, 25);
		lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblfname.setForeground(Color.BLACK);
		add(lblfname);
		tfname=new JLabel();
		tfname.setBounds(220, 430, 150, 25);
		add(tfname);
		
		JLabel lblcode=new JLabel("Gender");
		lblcode.setBounds(60, 480, 150, 25);
		lblcode.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblcode.setForeground(Color.BLACK);
		add(lblcode);
		tcode=new JLabel();
		tcode.setBounds(220, 480, 150, 25);
		add(tcode);
		
		JLabel lbldate=new JLabel("Journey Date");
		lbldate.setBounds(60, 530, 150, 25);
		lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbldate.setForeground(Color.BLACK);
		add(lbldate);
		// jarcalendar external jar file is added for dropdown of calendar
		
		 dateChooser=new JDateChooser();
		dateChooser.setBounds(220, 530, 150, 25);
		add(dateChooser);
		
		
		// to scale a photos
		ImageIcon imgIcon1=new ImageIcon(ClassLoader.getSystemResource("ams/icons/details.jpg"));
		Image imgIcon=imgIcon1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
		ImageIcon imgIcon2=new ImageIcon(imgIcon);
		JLabel lblimg=new JLabel(imgIcon2);
		lblimg.setBounds(550, 80, 500, 410);
		add(lblimg);
		
		bookflight=new JButton("Book Flight");
		bookflight.setBounds(220, 580, 150, 25);
		bookflight.setBackground(Color.BLACK);
		bookflight.setForeground(Color.WHITE);
		bookflight.addActionListener(this);
		add(bookflight);
		
		
		setSize(1100,750);
		setLocation(200,50);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new BookFlight();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==fButton) {
		String aadhaar= tadh.getText();
		
		try {
			Conn conn=new Conn();
			String query="select * from passenger where aadhar= '"+aadhaar+"'";
			
			ResultSet rSet= conn.stm.executeQuery(query);
			if(rSet.next()) {
				tfnam.setText(rSet.getString("name"));
				tfnationality.setText(rSet.getString("nationality"));
				taddress.setText(rSet.getString("address"));
				tgender.setText(rSet.getString("gender"));
			}else {
				JOptionPane.showMessageDialog(null, "Please enter correct Aadhaar Details ");
			}
			}
		catch (Exception e2) {
			
		}	
		
		
	}else if (e.getSource()==flight) {
				String src= source.getSelectedItem();
				String dest=destination.getSelectedItem();
				
				try {
					Conn conn=new Conn();
					String query="select * from flight where source= '"+src+"'and destination='"+dest+"'";
					
					ResultSet rSet= conn.stm.executeQuery(query);
					if(rSet.next()) {
						tfname.setText(rSet.getString("f_name"));
						tcode.setText(rSet.getString("f_code"));
	
					}else {
						JOptionPane.showMessageDialog(null, "No flights Found ");
					}
				
				}catch (Exception e2) {
					e2.printStackTrace();
				}	
		}else {
			Random random=new Random();
			String aadhaar=tadh.getText();
			String name=tfnam.getText();
			String nationality=tfnationality.getText();
			String flightName=tfname.getText();
			String flightCode=tcode.getText();
			String src= source.getSelectedItem();
			String dest=destination.getSelectedItem();
			String date= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			
			try {
				Conn conn=new Conn();
				String query="insert into reservation values('PNR-"+random.nextInt(1000000)+"','TIC"+random.nextInt(10000)+"','"+aadhaar+"','"+name+"','"+nationality+"','"+flightName+"','"+flightCode+"','"+src+"','"+dest+"','"+date+"')";
				 conn.stm.executeUpdate(query);
				 JOptionPane.showMessageDialog(null, "Ticket Booked Successfully ");
				 setVisible(false);
				
				}
			catch (Exception e2) {
				e2.printStackTrace();
			}	

		}
		}
}
