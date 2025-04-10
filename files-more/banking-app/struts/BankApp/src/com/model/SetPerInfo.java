package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.PersonalInfo;

public class SetPerInfo {
	public PersonalInfo queryPersonalInfo(Connection con, PersonalInfo pf) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = con.prepareStatement("SELECT * FROM BankUserInfo.Information WHERE name = ?");
			pst.setString(1, pf.getUserName());
			rs = pst.executeQuery();
			
			rs.next();
			pf.setUserID(rs.getInt("userID"));
			pf.setAddress(rs.getString("address"));
			pf.setBalance(rs.getInt("balance"));
			pf.setPassword(rs.getString("password"));
		} catch(SQLException se) {
			System.out.println(se);
		}
		return pf;
	} 	
}