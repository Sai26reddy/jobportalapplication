<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="adminlogin">
<table align="center" border="3px">
<tr> 
<td>User Id:</td>
<td>
<input type="text" name="user_id">
</td>
</tr>
<tr> 
<td>Password:</td>
<td>
<input type="password" name="password">
</td>
</tr>
<tr> 
<td colspan="2" align="center">
<input type="submit" value="Submit">
</td>
</tr>
<h6>Invalid Credentials</h6>
</table>
</body>
</html>