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
	<c:forEach items = "${feedbacks}" var = "feedback">
		<div class="slide-right">
		<div class="job-card">
			  <div class="job-details">
			    <div class="job-role">Posted by: ${feedback.recruiter.firstName}</div>
			    <div class="skills">Rating :${feedback.rating}</div>
			    <div class="posted-by">comments: ${feedback.comment}</div>
			  </div>
		</div>
	</div>
      </c:forEach>
</body>
</html>