package com.foodApp.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static Connection con=null;
	static String url="jdbc:mysql://localhost:3306/foodapp";
	static String password="root";
	static String user="root";
	
     //method that will return connection object 
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException|SQLException e) {
			
			e.printStackTrace();
		}		
		return con;
	}
	
}