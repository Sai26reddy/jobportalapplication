<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<style>

/* Add some basic styling to the navigation bar */

ul.navbar {

list-style-type: none;

margin: 0;

padding: 0;

overflow: hidden;

background-color: #333;

}

 

li.navitem {

float: left;

}

 

li.navitem a {

display: block;

color: white;

text-align: center;

padding: 14px 16px;

text-decoration: none;

}

 

li.navitem a:hover {

background-color: #555;

}

</style>

</head>

<body align="center">
<%


response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");


%>


<ul class="navbar">

<li class="navitem"><a href="jobs.jsp" style="background-color:grey">Posted Jobs</a></li>

<li class="navitem"><a href="postJob.jsp" >New Requirement</a></li>

<li class="navitem"><a href="feedBack.jsp">Feedbacks</a></li>

<li class="navitem"><a href="bookMarkedFreeLancers.jsp">Bookmarked FreeLancers</a></li>

<li class="navitem"><a href="logout.jsp">Logout</a></li>

</ul>

<table border="2px">

<thead>

<tr>

 

<th>Id</th>

<!-- <th>Job Role</th> -->

<th>Skill</th>

<!-- <th>Posted by</th> -->

<!-- <th>Posted Date</th> -->

<th>Freelancer Name</th>

<!-- <th>Job Applications</th> -->

<th>Delete</th>



 

</tr>

</thead>

<tbody>

 

<c:forEach var = "bmfl" items = "${bmfl}">

 

<tr>

 

<td>${bmfl.id}</td>


<td>${bmfl.skill.name}</td>
 

<td>${bmfl.freeLancer.firstName}</td>

 

<%-- <td>${job.recruiter.firstName}</td> --%>

 

<%-- <td>${job.postedDate}</td> --%>

<!--  <td></td> -->

<%-- <td>${job.awardedTo}</td> --%>

 

<%-- <td>${job.jobApplications}</td> --%>





<%-- <td>

<a href="/view-applications/${job.id}">View Applications</a>

</td> --%>

<td>

<a href="/delete/${bmfl.id}">Delete</a>

</td>

</tr>

 

</c:forEach>

</table>

</body>

</html>