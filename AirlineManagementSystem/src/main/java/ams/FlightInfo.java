package ams;

import java.awt.Color;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FlightInfo extends JFrame {

	public FlightInfo() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		// to show the data in form of tabel
		JTable table=new JTable();
		
		try {
			Conn conn=new Conn();
			String query="select * from flight";
			ResultSet rs=conn.stm.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0, 0, 800, 500);	
		add(jsp);
	
		
		setSize(800,500);
		setLocation(400, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FlightInfo();
	}

}
