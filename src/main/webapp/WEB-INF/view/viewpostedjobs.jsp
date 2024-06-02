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
	<c:forEach var="job" items="${job}">
		<div class="slide-right">
		<div class="job-card">
			  <div class="job-details">
			    <div class="job-role">Job Role : ${job.jobRole}</div>
			    <div class="job-role">Skill ${job.skill.name}</div>
			     <div class="job-role">awarded to : ${job.awardedTo.firstName}</div>
			  </div>
			  <div class="buttons">
			    <a href="/view-applications/${job.id}"><button class="btn-delete">view Applicants</button></a>
				<a href="/deletepostedjob/${job.id}"><button class="btn-delete">Delete</button></a>
			  </div>

		</div>
		</div>

      </c:forEach>
</body>
</html>