<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bean.PersonalInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Personal Information</title>
</head>
<body>
	<% PersonalInfo pf = (PersonalInfo)request.getAttribute("personalDetails");%>
	<center><h1>Welcome <%out.println(pf.getUserName()); %> </h1></center>
	<table border="1" cellpadding="5" width="300">
		<tr>
			<td><% out.println("ID: ");%></td>
			<td><% out.println(pf.getUserID());%></td>
		</tr>
		<tr>
			<td><% out.println("Address: ");%></td>
			<td><% out.println(pf.getAddress());%></td>
		</tr>
		<tr>
			<td><% out.println("Balance: $");%></td>
			<td><% out.println(pf.getBalance());%></td>
		</tr>
	</table>
	<br>
	<center><% out.println("<A HREF = 'UserInfo.html'> Click here to go back to the User Information page </A>");%></center>
</body>
</html>