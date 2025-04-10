<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bean.RegisterUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Personal Information</title>
</head>
<body>
	<% RegisterUser ru = (RegisterUser)request.getAttribute("personalDetails");%>
	<h1 align="center">Congradulations, <%out.println(ru.getName()); %>, you have create a new account!</h1>
	<h2 align="center">Here is your new account information:</h2>
	<table border="1" cellpadding="5" width="300">
		<tr>
			<td><% out.println("Name: ");%></td>
			<td><% out.println(ru.getName());%></td>
		</tr>
		<tr>
			<td><% out.println("Address: ");%></td>
			<td><% out.println(ru.getAddress());%></td>
		</tr>
		<tr>
			<td><% out.println("Balance: $");%></td>
			<td><% out.println(ru.getInitDeposit());%></td>
		</tr>
	</table>
	<br>
	<center><% out.println("<A HREF = 'LoginPage.html'> Click here to go back to the User Information page </A>");%></center>
</body>
</html>