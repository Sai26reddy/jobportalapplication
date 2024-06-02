<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

</head>

<body align="center">
<%


response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");


%>


<h1>Recruiter details</h1>

<table border="2px">

<thead>

<tr>

<th>Recruiter firstName</th>

<th>Recruiter lastName</th>

<th>Recruiter coverLetter</th>

</tr>

</thead>

<tbody>

<c:forEach var = "rec" items = "${ar}">

<tr>

<td>${rec.firstName}</td>

<td>${rec.lastName}</td>

<td>${rec.coverLetter}</td>

<td><a href="acceptrecruiters/${rec.firstName}">Accept</a></td>

<td><a href="deleteRecruiter/${rec.firstName}">Delete</a></td>

</tr>

</c:forEach>

</tbody>

</table>

</body>

</html>