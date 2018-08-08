package com.mindtree.establish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.service.MyException;

public class Conn {

	Connection con;
	public Conn() throws MyException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/diagnostic_dB","root","Welcome123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException ex)
		{
			//ex.printStackTrace();
			throw new MyException("Error with connectivity");
		}
	}
	
	public Connection getConnection() {
		return con;
		
	}
	
	public void closeConnection() throws SQLException
	{
		try {
		
	}
	finally {
		con.close();
	}
		
	}
}
