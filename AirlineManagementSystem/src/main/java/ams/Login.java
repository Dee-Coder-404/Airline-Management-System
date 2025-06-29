package ams;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JButton resetButton;
	JButton submit;
	JButton close;

	JTextField tfusername, tfpswd;

	public Login() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		setSize(400, 250); // to set length and width of the frame
		setLocation(600, 250); // to open the interface at particular lengths
		setVisible(true); // to show the frame by default is false

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(20, 20, 100, 20);
		add(lblusername);

		tfusername = new JTextField();
		tfusername.setBounds(130, 20, 200, 20);
		add(tfusername);

		JLabel Password = new JLabel("Password");
		Password.setBounds(20, 60, 100, 20);
		add(Password);

		tfpswd = new JTextField();
		tfpswd.setBounds(130, 60, 200, 20);
		add(tfpswd);

		resetButton = new JButton("Reset");
		resetButton.setBounds(40, 120, 120, 20);
		resetButton.addActionListener(this);
		add(resetButton);

		submit = new JButton("Submit");
		submit.setBounds(190, 120, 120, 20);
		submit.addActionListener(this);
		add(submit);

		close = new JButton("Close");
		close.setBounds(120, 160, 120, 20);
		close.addActionListener(this);
		add(close);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String username = tfusername.getText();
			String pswd = tfpswd.getText();

			try {
				Conn conn = new Conn();
				String query = "select * from login where username='" + username + "'and password='" + pswd + "'";
				ResultSet rSet = conn.stm.executeQuery(query);

				if (rSet.next()) {
					new Home();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid ID or Password?");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		} else if (ae.getSource() == resetButton) {
			tfusername.setText("");
			tfpswd.setText("");
		} else if (ae.getSource() == close) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {

		new Login();
	}

}
