package com.masai.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MakeConnection {
static String URL,USER,PASS;
static{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rs=ResourceBundle.getBundle("amit");
		URL=rs.getString("URL");
		USER=rs.getString("USER");
		PASS=rs.getString("PASS");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
static Connection makeConnection() throws SQLException {
	return DriverManager.getConnection(URL,USER,PASS);
}
}
