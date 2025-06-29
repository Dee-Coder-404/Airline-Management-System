package ams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Conn {
	
	private static String url = "jdbc:mysql://localhost:3306/airlinemanagementsystem"; 
	private static String user = "root";
	private static String pswd = "9030"; 

	 public Connection connection;
	 public Statement stm;

	public Conn() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        connection = DriverManager.getConnection(url, user, pswd);
	        stm=connection.createStatement();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
}
