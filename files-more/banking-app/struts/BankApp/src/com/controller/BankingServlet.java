package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LoginUser;
import com.bean.PersonalInfo;
import com.bean.RegisterUser;
import com.dao.DAO;
import com.model.CheckValidUser;
import com.model.RegPerInfo;
import com.model.SetPerInfo;

public class BankingServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO(getServletConfig().getInitParameter("DB_DRIVER"),
				getServletConfig().getInitParameter("DB_URL"),
				getServletConfig().getInitParameter("DB_USER"),
				getServletConfig().getInitParameter("DB_PASS"));	
		Connection con = dao.getDBConnection();
				
		if(request.getParameter("operation").equals("loginUser"))
		{
			LoginUser loginUser = new LoginUser(request.getParameter("name"), request.getParameter("password"));
			CheckValidUser checkuser = new CheckValidUser();
			try {
				if(checkuser.isUserValid(con, loginUser)) {
					getServletConfig().getServletContext().setAttribute("userName", request.getParameter("name"));
					response.sendRedirect("UserInfo.html");
				} else {
					response.sendRedirect("Welcome.html");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(request.getParameter("operation").equals("registerUser"))
		{
			RegisterUser ru = new RegisterUser(request.getParameter("name"), request.getParameter("password"), request.getParameter("address"), request.getParameter("initDeposit"));
			RegPerInfo rpi = new RegPerInfo();
			rpi.registerPersonalInfo(con, ru);
			request.setAttribute("personalDetails", ru);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayRegInfo.jsp");
			rd.forward(request, response);		
		}
		else if(request.getParameter("operation").equals("Personal Information"))
		{
			PersonalInfo pf = new PersonalInfo();
			pf.setUserName((String)getServletConfig().getServletContext().getAttribute("userName"));
			SetPerInfo df = new SetPerInfo();
			pf = df.queryPersonalInfo(con, pf);
			request.setAttribute("personalDetails", pf);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayPerInfo.jsp");
			rd.forward(request, response);		
		}
		else if(request.getParameter("operation").equals("Update Information"))
		{
			PersonalInfo pf = new PersonalInfo();
			pf.setUserName((String)getServletConfig().getServletContext().getAttribute("userName"));
			SetPerInfo df = new SetPerInfo();
			pf = df.queryPersonalInfo(con, pf);
			request.setAttribute("personalDetails", pf);
			RequestDispatcher rd = request.getRequestDispatcher("UpdatePerInfo.jsp");
			rd.forward(request, response);		
		}
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}
}