package ams;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class BoardingPass extends JFrame implements ActionListener {
	
	JTextField tfpnr;
	JLabel tfnam,tfnationality,tfname,tfdate,tcode,tfsource,tfdest;
	JButton sButton;
	 
	public BoardingPass() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("KINGFISHER AIRLINES");
		heading.setBounds(360, 10, 450, 35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.BLACK);
		add(heading);
		
		
		JLabel subheading=new JLabel("BOARDING PASS");
		subheading.setBounds(400, 50, 300, 30);
		subheading.setFont(new Font("Tahoma",Font.PLAIN,28));
		subheading.setForeground(Color.BLUE);
		add(subheading);
		
		JLabel lblpnr=new JLabel("PNR Details");
		lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpnr.setForeground(Color.BLACK);
		lblpnr.setBounds(60, 100, 150, 25);
		add(lblpnr);
		tfpnr=new JTextField(); 
		tfpnr.setBounds(220, 100, 150, 25);
		add(tfpnr);
		
		sButton=new JButton("Submit");
		sButton.setBounds(380, 100, 120, 25);
		sButton.setBackground(Color.BLACK);
		sButton.setForeground(Color.WHITE);
		sButton.addActionListener(this);
		add(sButton);
		
		
		JLabel lblname=new JLabel("NAME");
		lblname.setBounds(60, 140, 150, 25);
		lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblname.setForeground(Color.BLACK);
		add(lblname);
		tfnam=new JLabel(); // to get the data from the userdata
		tfnam.setBounds(220, 140, 150, 25);
		add(tfnam);
		
		JLabel lblnationality=new JLabel("NATIONALITY ");
		lblnationality.setBounds(60, 180, 150, 25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblnationality.setForeground(Color.BLACK);
		add(lblnationality);
		 tfnationality=new JLabel();
		tfnationality.setBounds(220, 180, 150, 25);
		add(tfnationality);
		
		
		JLabel lblsource=new JLabel("SOURCE");
		lblsource.setBounds(60, 220, 150, 25);
		lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblsource.setForeground(Color.BLACK);
		add(lblsource);
		tfsource=new JLabel();
		tfsource.setBounds(220, 220, 150, 25);
		add(tfsource);
		
		JLabel lbldestination=new JLabel("DESTINATION");
		lbldestination.setBounds(380, 220, 150, 25);
		lbldestination.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbldestination.setForeground(Color.BLACK);
		add(lbldestination);
		tfdest=new JLabel();
		tfdest.setBounds(550, 220, 150, 25);
		add(tfdest);
		
		
		JLabel lblfname=new JLabel("Flight Name");
		lblfname.setBounds(60, 260, 150, 25);
		lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblfname.setForeground(Color.BLACK);
		add(lblfname);
		tfname=new JLabel();
		tfname.setBounds(220, 260, 150, 25);
		add(tfname);
		
		JLabel lblcode=new JLabel("Flight Code");
		lblcode.setBounds(380, 260, 150, 25);
		lblcode.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblcode.setForeground(Color.BLACK);
		add(lblcode);
		tcode=new JLabel();
		tcode.setBounds(550, 260, 150, 25);
		add(tcode);
		
		JLabel lbldate=new JLabel("Journey Date");
		lbldate.setBounds(60, 300, 150, 25);
		lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbldate.setForeground(Color.BLACK);
		add(lbldate);
		// jarcalendar external jar file is added for dropdown of calendar
		
		 tfdate=new JLabel();
		tfdate.setBounds(220, 300, 150, 25);
		add(tfdate);
		
		
		// to scale a photos
		ImageIcon imgIcon1=new ImageIcon(ClassLoader.getSystemResource("ams/icons/kingfisher.png"));
		Image imgIcon=imgIcon1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
		ImageIcon imgIcon2=new ImageIcon(imgIcon);
		JLabel lblimg=new JLabel(imgIcon2);
		lblimg.setBounds(600, 0, 300, 300);
		add(lblimg);
		
		
		setSize(1000,450);
		setLocation(300,150);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new BoardingPass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==sButton) {
		String pnr= tfpnr.getText();
		
		try {
			Conn conn=new Conn();
			String query="select * from reservation where PNR= '"+pnr+"'";
			
			ResultSet rSet= conn.stm.executeQuery(query);
			if(rSet.next()) {
				tfnam.setText(rSet.getString("name"));
				tcode.setText(rSet.getString("flightcode"));
				tfdate.setText(rSet.getString("ddate"));
				tfnationality.setText(rSet.getString("nationality"));
				tfname.setText(rSet.getString("flightname"));
				tfsource.setText(rSet.getString("src"));
				tfdest.setText(rSet.getString("des"));
			}else {
				JOptionPane.showMessageDialog(null, "Please enter correct PNR Details ");
				}
			}
		catch (Exception e2) {
			e2.printStackTrace();
		}	
		
	}
		}
}
