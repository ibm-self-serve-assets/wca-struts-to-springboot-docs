package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.RegisterUser;

public class RegPerInfo {
	public void registerPersonalInfo(Connection con, RegisterUser ru) {
		PreparedStatement pst = null;
		
		try {
			String sql = "INSERT INTO BankUserInfo.Information (name,password,address,balance) VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, ru.getName());
			pst.setString(2, ru.getPassword());
			pst.setString(3, ru.getAddress());
			pst.setString(4, ru.getInitDeposit());
			pst.executeUpdate();
	
			System.out.println("You have successfully entered your info " + pst);
		} catch(SQLException se) {
			System.out.println("what the hell man!?");
		}
	}
}