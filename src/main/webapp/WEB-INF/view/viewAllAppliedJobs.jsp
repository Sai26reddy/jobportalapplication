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
	<c:forEach items = "${jobApplications}" var = "Appliedjob">
	<div class="slide-right">
		<div class="job-card">
			  <div class="job-details">
			    <div class="job-role">Job Role : ${Appliedjob.job.jobRole}</div>
			    <div class="skills">Required Skill : ${Appliedjob.job.skill.name}</div>
			    <div class="posted-by">Posted by: ${Appliedjob.job.recruiter.firstName}</div>
			  </div>
			  <div class="buttons">
			    <a href = "/deleteappliedJob/${Appliedjob.id}"><button class="btn-delete">Delete</button></a>
			  </div>
		</div>
	</div>
      </c:forEach>
</body>
</html>