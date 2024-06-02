<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<style><%@include file="/WEB-INF/css/viewAllJobs.css"%></style>

</head>

<body>

    <c:forEach items = "${listOfAllJobs}" var = "job">

        <div class="job-card">

            <div class="job-details">

              <div class="job-role">JobRole : ${job.jobRole}</div>

              <div class="skills">Skills Required:${job.skill.name}</div>

              <div class="posted-by">Posted by: ${job.recruiter.firstName}</div>

            </div>

            <div class="buttons">

              <a href = "/applyJob/${job.id}"><button class="btn">Apply</button></a>

               <a href = "/bookMarkJob/${job.id}"><button class="btn">BookMark</button></a>

            </div>

  </div>

 

      </c:forEach>

</body>

</html>