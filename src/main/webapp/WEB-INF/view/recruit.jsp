<!DOCTYPE html>



<html>



<head>



<title>Navigation Bar</title>



<style>
body {
	background-image:
		url('https://img.freepik.com/free-vector/resume-cv-job-flat-set-with-isolated-compositions-people-looking-employment-sending-email-letters-vector-illustration_1284-84159.jpg?w=1380&t=st=1692707907~exp=1692708507~hmac=b30f702634343c734dc62a43370b028757a23ad6d1f319483211ba879310b3f7');
	/* width : 100%;

height : 100%; */
	background-size: cover;
	background-repeat: no-repeat;
}

/* Add some basic styling to the navigation bar */
.navbar {
	width: 100%;
	background-color: #555;
	overflow: auto;
}

/* Navigation links */
.navbar a {
	float: left;
	padding: 14px;
	color: white;
	text-decoration: none;
	font-size: 16px;
	width: 14%;
	/* Four equal-width links. If you have two links, use 50%, and 33.33% for three links, etc.. */
	text-align: center; /* If you want the text to be centered */
}

/* Add a background color on mouse-over */
.navbar a:hover {
	background-color: #000;
}

/* Style the current/active link */

/* .navbar a.active {

  background-color: #04AA6D;

} */

/* Add responsiveness - on screens less than 500px, make the navigation links appear on top of each other, instead of next to each other */
@media screen and (max-width: 500px) {
	.navbar a {
		float: none;
		display: block;
		width: 100%;
		text-align: left;
		/* If you want the text to be left-aligned on small screens */
	}
}

/* ul.navbar {

 

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

 

} */
</style>



</head>



<body>



	<!-- <h2 align="center">Welcome to Recruiter Signin Page</h2> -->

	<%-- <ul class="navbar">

 

 

<li class="navitem"><a href="viewpostedjobsss/${user_id}">Posted Jobs</a></li>

 

<li class="navitem"><a href="postthejob/${user_id}">New Requirement</a></li>

 

<li class="navitem"><a href="feedBack.jsp">Feedbacks</a></li>

 

<li class="navitem"><a href="bookMarkedFreeLancers.jsp">Bookmarked FreeLancers</a></li>

 

<li class="navitem"><a href="logout.jsp">Logout</a></li>

 

<li class="navitem"><a href="aboutus.jsp">About us</a></li>

 

</ul> --%>



	<div class="navbar">
		<a class="active" href="/viewpostedjobs">Posted Jobs</a> 
		<a href="/postthejob">New Requirements</a> 
		<a href="/viewAllPendingFeedBacks">Feedbacks</a> 
		<a href="/bookmarkedfreelancers">Bookmarked FreeLancers</a> 
		<a href="/logout">Logout</a> 
		<a href="/aboutus.jsp">Aboutus</a>

	</div>

</body>



</html>