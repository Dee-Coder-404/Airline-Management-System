package ams;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener {
	
	JTextField tfnam,tfnationality,tadh,taddress,tphone,temail;
	JRadioButton lblmale,lblfemale;
	 
	public AddCustomer() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("ADD CUSTOMERS DETAILS");
		heading.setBounds(220, 20, 500, 35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(60, 80, 150, 25);
		lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblname.setForeground(Color.BLACK);
		add(lblname);
		 tfnam=new JTextField();
		tfnam.setBounds(220, 80, 150, 25);
		add(tfnam);
		
		JLabel lblnationality=new JLabel("Nationality ");
		lblnationality.setBounds(60, 130, 150, 25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblnationality.setForeground(Color.BLACK);
		add(lblnationality);
		 tfnationality=new JTextField();
		tfnationality.setBounds(220, 130, 150, 25);
		add(tfnationality);
		
		JLabel lbladhaar=new JLabel("Adhaar Number");
		lbladhaar.setBounds(60, 180, 150, 25);
		lbladhaar.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbladhaar.setForeground(Color.BLACK);
		add(lbladhaar);
	    tadh=new JTextField();
		tadh.setBounds(220, 180, 150, 25);
		add(tadh);
		
		
		JLabel lbladdress=new JLabel("Address");
		lbladdress.setBounds(60, 230, 150, 25);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbladdress.setForeground(Color.BLACK);
		add(lbladdress);
		taddress=new JTextField();
		taddress.setBounds(220, 230, 150, 25);
		add(taddress);
		
		JLabel lblgender=new JLabel("Gender");
		lblgender.setBounds(60, 280, 150, 25);
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblgender.setForeground(Color.BLACK);
		add(lblgender);
		
		ButtonGroup buttonGroup=new ButtonGroup();   //created for either two radio buttons should not be selected
		
		lblmale=new JRadioButton("Male");
		lblmale.setBounds(220, 280, 70, 25);
		lblmale.setBackground(Color.WHITE);
		add(lblmale);
		
		lblfemale=new JRadioButton("Female");
		lblfemale.setBounds(300, 280, 70, 25);
		lblfemale.setBackground(Color.WHITE);
		add(lblfemale);
		
		buttonGroup.add(lblfemale);
		buttonGroup.add(lblmale);
		
		
		JLabel lblphone=new JLabel("Phone Number");
		lblphone.setBounds(60, 330, 150, 25);
		lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblphone.setForeground(Color.BLACK);
		add(lblphone);
		tphone=new JTextField();
		tphone.setBounds(220, 330, 150, 25);
		add(tphone);
		
		JLabel lblemail=new JLabel("Email ID");
		lblemail.setBounds(60, 380, 150, 25);
		lblemail.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblemail.setForeground(Color.BLACK);
		add(lblemail);
		temail=new JTextField();
		temail.setBounds(220, 380, 150, 25);
		add(temail);
		
		
		JButton saveButton=new JButton("SAVE");
		saveButton.setBackground(Color.BLACK);
		saveButton.setForeground(Color.WHITE);
		saveButton.setBounds(220, 430, 150, 30);
		saveButton.addActionListener(this);
		add(saveButton);
		
		ImageIcon imgIcon=new ImageIcon(ClassLoader.getSystemResource("ams/icons/emp.png"));
		JLabel lblimg=new JLabel(imgIcon);
		lblimg.setBounds(480, 80, 280, 400);
		add(lblimg);
		
		setSize(900,600);
		setLocation(300,150);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new AddCustomer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name=tfnam.getText();
		String nationality=tfnationality.getText();
		String aadhaar= tadh.getText();
		String address=taddress.getText();
		String phone=tphone.getText();
		String email=temail.getText();
		String gender=null;
		if(lblmale.isSelected()) {
			gender="Male";
		}else {
			gender="Female";
		}
		try {
			Conn conn=new Conn();
			
			String query="insert into passenger values('"+name+"','"+nationality+"','"+phone+"',"
					+ "'"+address+"','"+aadhaar+"','"+gender+"','"+email+"')";
			conn.stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Passenger Details Saved Successfully");
			setVisible(false);
		} catch (Exception e2) {
			
		}
	}

}
