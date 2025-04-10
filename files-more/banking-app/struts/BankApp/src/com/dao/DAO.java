package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
	String DB_DRIVER;
	String DB_URL;
	String DB_PASS;
	String DB_USER;

	public DAO(String DB_DRIVER, String DB_URL, String DB_USER, String DB_PASS)
	{
		this.DB_DRIVER = DB_DRIVER;
		this.DB_URL = DB_URL;
		this.DB_USER = DB_USER;
		this.DB_PASS = DB_PASS;
	}
	
	public Connection getDBConnection()
	{
		Connection con = null;
		try {
			Class.forName(DB_DRIVER);			
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);			
			
		} catch(SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		
		}//End try
		return con;
	}
}
