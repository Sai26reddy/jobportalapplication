<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="/WEB-INF/css/viewAllJobs.css"%></style>
</head>
<body>
	<c:forEach var="ja" items="${jobApplications}">
		<div class="slide-right">
		<div class="job-card">
			  <div class="job-details">
			    <div class="job-role">FreeLancer Name : ${ja.key.freeLancer.firstName}</div>
			    <c:forEach var="skillExperience" items="${ja.value}">
			    <div class="skills">Skills :${skillExperience.skill.name}</div>
			    </c:forEach>
			    <div class="posted-by">Applied date :${ja.key.appliedDate}</div>
			  </div>
			  <div class="buttons">
			    <a href="/bookMarkFreeLancer/${ja.key.id}"><button class="btn">BookMark</button></a>
			    <a  href="/accept/${ja.key.id}/${ja.key.freeLancer.id}"><button class="btn">Accept</button></a>
			    <a href="/reject/${ja.key.id}"><button class="btn-delete">Reject</button></a>
			  </div>

		</div>
		</div>

      </c:forEach>
</body>
</html>