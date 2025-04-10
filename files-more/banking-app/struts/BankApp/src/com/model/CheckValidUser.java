package com.model;

import java.sql.*;

import com.bean.LoginUser;

public class CheckValidUser {

	public boolean isUserValid(Connection con, LoginUser lu) throws SQLException
	{
		Statement st = con.createStatement();
		
		String sql = "SELECT name, password FROM BankUserInfo.Information";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
			if(rs.getString("name").equals(lu.getName()) && rs.getString("password").equals(lu.getPassword())) {
				System.out.println("Accepted");
				return true;
			}
		System.out.println("Rejected");
		return false;
	}
}
