package ams;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.View;

import org.w3c.dom.xpath.XPathNSResolver;

import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
	JTable table;
	JButton viewButton;
	JTextField pnr;
	public JourneyDetails() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblpnr=new JLabel("PNR NUMBER");
		lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpnr.setBounds(50, 50, 100, 25);
		add(lblpnr);
		
		pnr=new JTextField();
		pnr.setBounds(160, 50, 120, 25);
		add(pnr);
		
		viewButton =new JButton("VIEW");
		viewButton.setBackground(Color.BLACK);
		viewButton.setForeground(Color.WHITE);
		viewButton.setBounds(250, 50, 120, 25);
		viewButton.addActionListener(this);
		add(viewButton);
		
		
		// to show the data in form of tabel
		table=new JTable();
		
		
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0, 100, 800, 150);
		jsp.setBackground(Color.WHITE);
		add(jsp);
	
		
		setSize(800,500);
		setLocation(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new JourneyDetails();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Conn conn=new Conn();
			String query="select * from reservation where PNR ='"+pnr.getText()+"'";
			ResultSet rs=conn.stm.executeQuery(query);
			if(!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "INVALID PNR");
			}
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e1) {
			e1.printStackTrace();
			}		
	}

}
