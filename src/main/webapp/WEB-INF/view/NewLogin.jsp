
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

 

pageEncoding="ISO-8859-1"%>

 

<!DOCTYPE html>

 

<html>

 

<head>

 

<meta charset="ISO-8859-1">

 

<title>Dashboard</title>

 

<style><%@include file="/WEB-INF/css/anotherlogintransition.css"%>

<%@include file="/WEB-INF/css/freelancerhomepage.css"%>
 



</style>

 

</head>

 

<body>

 

<!-- <div class="container">

<div class="login-wrap"> -->

 
<!-- <a class="btn btn-light" href="#login-show" role="button">Login</a> -->

<img alt="findyourcareer" src="logo3.png" height="223px">

<div class="topnav" id="myTopnav">

<a class="active" href="NewLogin.jsp">Home</a>

<a href="/viewActiveJobs">All Jobs</a> 

<div class="dropdown">
    <button class="dropbtn">Your Jobs
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="/viewAppliedJobs">Applied Jobs</a>
      <a href="/viewBookMarkedJobs">BookMarked Jobs</a>
      <a href="/ongoingJobs">Ongoing Jobs</a>
      <a href="/getCompletedJobs">Completed Jobs</a>
    </div>
  </div>
<a href="/viewAllFeedbacks">Feedbacks</a>

<a href="/aboutus">About Us</a>

<a href="/contactus">Contact Us </a>
<a href="/profile">Profile</a>
<a class="btn btn-light" href="/freeLancerLogout">Logout</a>

</div>
<img alt="lo2.png" src="lo2.png">

<br>

<div class= 'container'>

<div class="container_content">

<div class="container_content_inner">

<div class="title">

<br>

<h3>Job Management</h3>

</div>

<div class="par">

<p align="justify">

Our website offers a user-friendly interface that empowers businesses to oversee every aspect of job management seamlessly. It provides tools to create and publish job listings, attracting top talent. The platform’s integrated applicant tracking system simplifies the selection process by allowing recruiters to review, shortlist, and communicate with candidates within a single system.Through its comprehensive dashboard, the platform enables HR teams to monitor the progress of various job openings, assess team performance, and optimize hiring strategies. Overall, your website significantly enhances the efficiency and effectiveness of job management tasks.

</p>

</div>

</div>

</div>

<div class="container_outer_img">

<div class="img-inner">

<img src='fr.png' alt="" class="container_img"/>

</div>

</div>

</div>

<div class="overlay"></div>
<br>

<div class= 'container'>

<div class="container_content">

<div class="container_content_inner">

<div class="title">

<br>

<h3>Applicant Management</h3>

</div>

<div class="par">

<p align="justify">

Our website serves as a powerful applicant management solution, streamlining the entire candidate lifecycle. It allows recruiters to easily post job openings, attracting a pool of potential candidates. The platform's intuitive interface enables efficient applicant tracking, letting you review, evaluate, and communicate with candidates seamlessly. Automated notifications keep both applicants and hiring teams informed at every stage, enhancing engagement. Your website's central dashboard offers insights into applicant pipelines, helping you make informed decisions and optimize your hiring process. With its comprehensive tools, your website transforms applicant management into a streamlined and efficient experience.Your website revolutionizes applicant management by providing a unified platform for seamless recruitment. Through intuitive job posting and application submission, it attracts potential candidates effortlessly. The website's integrated system simplifies applicant tracking, allowing recruiters to efficiently review, communicate, and evaluate applicants.

</p>

</div>

</div>

</div>

<div class="container_outer_img">

<div class="img-inner">

<img src='am.png' alt="" class="container_img"/>

</div>

</div>

</div>

<div class="overlay"></div>

 

 

 

 

 

 

<br>

<div class= 'container'>

<div class="container_content">

<div class="container_content_inner">

<div class="title">

<br>

<h3>About Online Job Portal</h3>

</div>

<div class="par">

<p align="justify">My job portal website is a dynamic online platform designed to facilitate seamless connections between job seekers and employers. By offering a user-friendly interface, personalized profiles, and advanced search functionalities, it empowers job seekers to explore relevant job listings based on their qualifications and preferences. Employers, in turn, can efficiently post job openings, review applicant profiles, and manage the hiring process. With a focus on user experience and efficient recruitment, my job portal website aims to streamline the job search process and enhance the overall hiring experience for both individuals and businesses.

A job portal application is a digital platform that connects job seekers with potential employers. It serves as a bridge between individuals searching for employment opportunities and companies seeking suitable candidates. These applications allow job seekers to create profiles, upload their resumes, and search for job listings based on their skills, experience, and preferences.

</p>

<!-- <h3>Applicant Management</h3>

</div>

<div class="par">

<p align="justify">

Our website serves as a powerful applicant management solution, streamlining the entire candidate lifecycle. It allows recruiters to easily post job openings, attracting a pool of potential candidates. The platform's intuitive interface enables efficient applicant tracking, letting you review, evaluate, and communicate with candidates seamlessly. Automated notifications keep both applicants and hiring teams informed at every stage, enhancing engagement. Your website's central dashboard offers insights into applicant pipelines, helping you make informed decisions and optimize your hiring process. With its comprehensive tools, your website transforms applicant management into a streamlined and efficient experience.Your website revolutionizes applicant management by providing a unified platform for seamless recruitment. Through intuitive job posting and application submission, it attracts potential candidates effortlessly. The website's integrated system simplifies applicant tracking, allowing recruiters to efficiently review, communicate, and evaluate applicants.

</p> -->

</div>

</div>

</div>

<div class="container_outer_img">

<div class="img-inner">

<img src='gp.png' alt="" class="container_img"/>

</div>

</div>

</div>

<div class="overlay"></div>

 

 

 

<!-- </div>/.login-wrap -->

 

 

 

 

 

<div class="card login-form" id="login-show">

 

<div class="card-body">

 

 

<section class="forms-section">

 

<h1 class="section-title"></h1>

 

<div class="forms">

 

<div class="form-wrapper is-active">

 

<button type="button" class="switcher switcher-login">

 

<b>Login</b>

 

<span class="underline"></span>

 

</button>

 

<form action = "" class="form form-login">

 

<fieldset>

 

<legend>Please, enter your email and password for login.</legend>

 

<div class="input-block">

 

<label for="login-email">E-mail</label>

 

<input id="login-email" type="email" required>

 

</div>

 

<div class="input-block">

 

<label for="login-password">Password</label>

 

<input id="login-password" type="password" required>

 

</div>

 

</fieldset>

 

<button type="submit" class="btn-login">Login</button>

 

</form>

 

</div>

 

<div class="form-wrapper">

 

<button type="button" class="switcher switcher-signup">

 

<b>Sign Up</b>

 

<span class="underline"></span>

 

</button>

 

<form class="form form-signup">

 

<fieldset>

 

<legend>Please, enter your email, password and password confirmation for sign up.</legend>

 

<div class="input-block">

 

<label for="signup-email">E-mail</label>

 

<input id="signup-email" type="email" required>

 

</div>

 

<div class="input-block">

 

<label for="signup-password">Password</label>

 

<input id="signup-password" type="password" required>

 

</div>

 

<div class="input-block">

 

<label for="signup-password-confirm">Confirm password</label>

 

<input id="signup-password-confirm" type="password" required>

 

</div>

 

</fieldset>

 

<button type="submit" class="btn-signup">Continue</button>

 

</form>

 

</div>

 

</div>

</section>

 

</div>

 

</div><!-- /.card -->

 

 

 

</div><!-- /.container -->

 

 

<script>

 

const switchers = [...document.querySelectorAll('.switcher')]

 

 

 

switchers.forEach(item => {

 

item.addEventListener('click', function() {

 

switchers.forEach(item => item.parentElement.classList.remove('is-active'))

 

this.parentElement.classList.add('is-active')

})

})

</script>

</body>
</html>