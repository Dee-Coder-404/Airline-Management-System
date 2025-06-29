package ams;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Cancel extends JFrame implements ActionListener {
	
	JTextField tfpnr,tfcode,jdate;
	JLabel tfnam,cancelno;
	JButton cancel,fButton;
	 
	public Cancel() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		Random random= new Random();
		
		JLabel heading=new JLabel("CANCEL FLIGHT TICKET");
		heading.setBounds(180, 20, 250, 25);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ams/icons/cancel.jpg"));
		Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel i4=new JLabel(i3);
		i4.setBounds(470, 120, 250, 250);
		add(i4);
		
		JLabel lblpnr=new JLabel("PNR Number");
		lblpnr.setBounds(40, 80, 150, 25);
		lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpnr.setForeground(Color.BLACK);
		add(lblpnr);
	    tfpnr=new JTextField();
		tfpnr.setBounds(220, 80, 150, 25);
		add(tfpnr);
		
		
		fButton=new JButton("Show Details");
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
		
		JLabel lblcancel=new JLabel("Cancellation Number ");
		lblcancel.setBounds(60, 180, 150, 25);
		lblcancel.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblcancel.setForeground(Color.BLACK);
		add(lblcancel);
		
		cancelno=new JLabel(""+random.nextInt(100000000));
		cancelno.setBounds(220, 180, 150, 25);
		add(cancelno);
		
		
		JLabel lblcode=new JLabel("Flight Code");
		lblcode.setBounds(60, 230, 150, 25);
		lblcode.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblcode.setForeground(Color.BLACK);
		add(lblcode);
		tfcode=new JTextField();
		tfcode.setBounds(220, 230, 150, 25);
		add(tfcode);
		
		JLabel lbldate=new JLabel("Date of Journey");
		lbldate.setBounds(60, 280, 150, 25);
		lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbldate.setForeground(Color.BLACK);
		add(lbldate);
		jdate=new JTextField();
		jdate.setBounds(220, 280, 150, 25);
		add(jdate);
		
		
		cancel=new JButton("CANCEL");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(220, 330, 120, 25);
		cancel.addActionListener(this);
		add(cancel);
		
		
		setSize(800,450);
		setLocation(350,150);
		setVisible(true);
	
	}

	public static void main(String[] args) {
		
		new Cancel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==fButton) {
		String pnr= tfpnr.getText();
		
		try {
			Conn conn=new Conn();
			String query="select * from reservation where PNR= '"+pnr+"'";
			
			ResultSet rSet= conn.stm.executeQuery(query);
			if(rSet.next()) {
				tfnam.setText(rSet.getString("name"));
				tfcode.setText(rSet.getString("flightcode"));
				jdate.setText(rSet.getString("ddate"));
			}else {
				JOptionPane.showMessageDialog(null, "Please enter correct PNR Details ");
				}
			}
		catch (Exception e2) {
			
		}	
		
		
	}else if (e.getSource()==cancel) {
				String name= tfnam.getText();
				String pnr=tfpnr.getText();
				String cancelDb=cancelno.getText();
				String fcodeString=tfcode.getText();
				String date=jdate.getText();
				try {
					Conn conn=new Conn();
					
					String query="insert into cancel values('"+pnr+"','"+name+"','"+cancelDb+"','"+fcodeString+"'.'"+date+"')";
					conn.stm.executeUpdate(query);
					String query2="delete from reservation where PNR='"+pnr+"'";
					conn.stm.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Ticket Cancelled Succuessfully!!! ");
					setVisible(false);
				}catch (Exception e2) {
					e2.printStackTrace();
				}	
		}
		}
}