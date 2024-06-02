
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

 

pageEncoding="ISO-8859-1"%>

 

<!DOCTYPE html>

 

<html>

 

<head>

 

<meta charset="ISO-8859-1">

 

<title>Dashboard</title>

 

<style><%@include file="/WEB-INF/css/anotherlogintransition.css"%>

<%@include file="/WEB-INF/css/freelancerhomepage.css"%>
 

*,

 

*::before,

 

*::after {

 

box-sizing: border-box;

 

}

 

 

 

body {

 

margin: 0;

 

font-family: Roboto, -apple-system, 'Helvetica Neue', 'Segoe UI', Arial, sans-serif;

 

background: #ffffff;

 

 

 

}

 

 

 

.forms-section {

 

display: flex;

 

flex-direction: column;

 

justify-content: center;

 

align-items: center;

 

}

 

 

 

.section-title {

 

font-size: 32px;

 

letter-spacing: 1px;

 

color: #000000;

 

}

 

 

 

.forms {

 

display: flex;

 

align-items: flex-start;

 

margin-top: 30px;

 

}

 

 

 

.form-wrapper {

 

animation: hideLayer .3s ease-out forwards;

 

}

 

 

 

.form-wrapper.is-active {

 

animation: showLayer .3s ease-in forwards;

 

}

 

 

 

@keyframes showLayer {

 

50% {

 

z-index: 1;

 

}

 

100% {

 

z-index: 1;

 

}

 

}

 

 

 

@keyframes hideLayer {

 

0% {

 

z-index: 1;

 

}

 

49.999% {

 

z-index: 1;

 

}

 

}

 

 

 

.switcher {

 

position: relative;

 

cursor: pointer;

 

display: block;

 

margin-right: auto;

 

margin-left: auto;

 

padding: 0;

 

text-transform: uppercase;

 

font-family: inherit;

 

font-size: 16px;

 

letter-spacing: .5px;

 

color: #000000;

 

background-color: transparent;

 

border: none;

 

outline: none;

 

transform: translateX(0);

 

transition: all .3s ease-out;

 

}

 

 

 

.form-wrapper.is-active .switcher-login {

 

color: #000000;

 

transform: translateX(90px);

 

}

 

 

 

.form-wrapper.is-active .switcher-signup {

 

color: #000000;

 

transform: translateX(-90px);

 

}

 

 

 

.underline {

 

position: absolute;

 

bottom: -5px;

 

left: 0;

 

overflow: hidden;

 

pointer-events: none;

 

width: 100%;

 

height: 2px;

 

}

 

 

 

.underline::before {

 

content: '';

 

position: absolute;

 

top: 0;

 

left: inherit;

 

display: block;

 

width: inherit;

 

height: inherit;

 

background-color: currentColor;

 

transition: transform .2s ease-out;

 

}

 

 

 

.switcher-login .underline::before {

 

transform: translateX(101%);

 

}

 

 

 

.switcher-signup .underline::before {

 

transform: translateX(-101%);

 

}

 

 

 

.form-wrapper.is-active .underline::before {

 

transform: translateX(0);

 

}

 

 

 

.form {

 

overflow: hidden;

 

min-width: 260px;

 

margin-top: 50px;

 

padding: 30px 25px;

 

border-radius: 5px;

 

transform-origin: top;

 

}

 

 

 

.form-login {

 

animation: hideLogin .3s ease-out forwards;

 

}

 

 

 

.form-wrapper.is-active .form-login {

 

animation: showLogin .3s ease-in forwards;

 

}

 

 

 

@keyframes showLogin {

 

0% {

 

background: #d7e7f1;

 

transform: translate(40%, 10px);

 

}

 

50% {

 

transform: translate(0, 0);

 

}

 

100% {

 

background-color: #fff;

 

transform: translate(35%, -20px);

 

}

 

}

 

 

 

@keyframes hideLogin {

 

0% {

 

background-color: #fff;

 

transform: translate(35%, -20px);

 

}

 

50% {

 

transform: translate(0, 0);

 

}

 

100% {

 

background: #d7e7f1;

 

transform: translate(40%, 10px);

 

}

 

}

 

 

 

.form-signup {

 

animation: hideSignup .3s ease-out forwards;

 

}

 

 

 

.form-wrapper.is-active .form-signup {

 

animation: showSignup .3s ease-in forwards;

 

}

 

 

 

@keyframes showSignup {

 

0% {

 

background: #d7e7f1;

 

transform: translate(-40%, 10px) scaleY(.8);

 

}

 

50% {

 

transform: translate(0, 0) scaleY(.8);

 

}

 

100% {

 

background-color: #fff;

 

transform: translate(-35%, -20px) scaleY(1);

 

}

 

}

 

 

 

@keyframes hideSignup {

 

0% {

 

background-color: #fff;

 

transform: translate(-35%, -20px) scaleY(1);

 

}

 

50% {

 

transform: translate(0, 0) scaleY(.8);

 

}

 

100% {

 

background: #d7e7f1;

 

transform: translate(-40%, 10px) scaleY(.8);

 

}

 

}

 

 

 

.form fieldset {

 

position: relative;

 

opacity: 0;

 

margin: 0;

 

padding: 0;

 

border: 0;

 

transition: all .3s ease-out;

 

}

 

 

 

.form-login fieldset {

 

transform: translateX(-50%);

 

}

 

 

 

.form-signup fieldset {

 

transform: translateX(50%);

 

}

 

 

 

.form-wrapper.is-active fieldset {

 

opacity: 1;

 

transform: translateX(0);

 

transition: opacity .4s ease-in, transform .35s ease-in;

 

}

 

 

 

.form legend {

 

position: absolute;

 

overflow: hidden;

 

width: 1px;

 

height: 1px;

 

clip: rect(0 0 0 0);

 

}

 

 

 

.input-block {

 

margin-bottom: 20px;

 

}

 

 

 

.input-block label {

 

font-size: 14px;

 

color: #a1b4b4;

 

}

 

 

 

.input-block input {

 

display: block;

 

width: 100%;

 

margin-top: 8px;

 

padding-right: 15px;

 

padding-left: 15px;

 

font-size: 16px;

 

line-height: 40px;

 

color: #3b4465;

 

background: #eef9fe;

 

border: 1px solid #cddbef;

 

border-radius: 2px;

 

}

 

 

 

.form [type='submit'] {

 

opacity: 0;

 

display: block;

 

min-width: 120px;

 

margin: 30px auto 10px;

 

font-size: 18px;

 

line-height: 40px;

 

border-radius: 25px;

 

border: none;

 

transition: all .3s ease-out;

 

}

 

 

 

.form-wrapper.is-active .form [type='submit'] {

 

opacity: 1;

 

transform: translateX(0);

 

transition: all .4s ease-in;

 

}

 

 

 

.btn-login {

 

color: #fbfdff;

 

background: #a7e245;

 

transform: translateX(-30%);

 

}

 

 

 

.btn-signup {

 

color: #a7e245;

 

background: #fbfdff;

 

box-shadow: inset 0 0 0 2px #a7e245;

 

transform: translateX(30%);

 

}

 

* {

margin: 0;

padding: 0;

box-sizing: border-box;

}

 

:root {

--secondary-color: #151226;

--contrast-color: #BF307F;

}

.overlay {

position: absolute;

top: 0;

left: 0;

right: 0;

bottom: 0;

height: 100%;

z-index: -10;

background-color: var(--contrast-color);

}

 

.container {

display: flex;

height: 100vh;

justify-content: space-around;

align-items: center;

color: #fff;

animation: expand .8s ease forwards;

background-color: var(--secondary-color);

position: relative;

font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

transition: all .8s ease;

}

 

.container_content {

width: 50%;

}

 

.container_content_inner {

width: 80%;

margin-left: 80px;

}

 

.container_outer_img {

margin: 50px;

width: 50%;

overflow: hidden;

}

 

.container_img {

width: 100%;

animation: slideIn 2.5s ease-in-out forwards;

}

 

.par {

height: auto;

overflow: hidden;

}

 

p{

line-height: 28px;

transform: translateY(300px);

animation: slideUp 1.2s ease-in-out forwards 1.2s;

}

 

.btns {

height: 100%;

position: relative;

width: 150px;

overflow: hidden;

}

 

.btns_more {

background: transparent;

border: 1px solid var(--contrast-color);

border-radius: 50px;

padding: 8px 12px;

color: #BF307F;

font-size: 16px;

text-transform: uppercase;

position: relative;

margin-top: 15px;

outline: none;

transform: translateY(50px);

animation: slideUp 1.2 ease-in-out forwards 1.4s;

}

 

.title {

overflow: hidden;

height: auto;

}

 

h1 {

font-size: 40px;

color: var(--contrast-color);

margin-bottom: 20px;

transform: translateY(100px);

animation: slideUp 1.2s ease forwards .9s;

}

 

@keyframes slideIn {

0% {

transform: translateX(500px) scale(.2);

}

100% {

transform: translateX(0px) scale(1);

}

}

 

@keyframes slideUp {

0% {

transform: translateY(300px);

}

100% {

transform: translateY(0px);

}

}

 

@keyframes expand {

0% {

transform: translateX(1400px);

}

100% {

transform: translateX(0px);

}

}


</style>

 

</head>

 

<body>

 

<!-- <div class="container">

<div class="login-wrap"> -->

 
<!-- <a class="btn btn-light" href="#login-show" role="button">Login</a> -->

<img alt="findyourcareer" src="logo3.png" height="223px">

<div class="topnav" id="myTopnav">

<a class="active" href="/WEB-INF/view/LoginNewNew.jsp">Home</a>

<a href="/viewActiveJobs">All Jobs</a> 

<div class="dropdown">
    <button class="dropbtn">Your Jobs
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#login-show">Applied Jobs</a>
      <a href="#login-show">BookMarked Jobs</a>
      <a href="#login-show">Ongoing Jobs</a>
      <a href="#login-show">Completed Jobs</a>
    </div>
  </div>
<a href="#login-show">Feedbacks</a>

<a href="/aboutus">About Us</a>

<a href="/contactus">Contact Us </a>

 
<a class="btn btn-light" href="#login-show" role="button">Login</a>

</div>

 

<img alt="lo2.png" src="lo2.png">

<br>

<div class= 'container'>

<div class="container_content">

<div class="container_content_inner">

<div class="title">

<br>

<!-- <h3>About Online Job Portal</h3>

</div>

<div class="par">

<p align="justify">My job portal website is a dynamic online platform designed to facilitate seamless connections between job seekers and employers. By offering a user-friendly interface, personalized profiles, and advanced search functionalities, it empowers job seekers to explore relevant job listings based on their qualifications and preferences. Employers, in turn, can efficiently post job openings, review applicant profiles, and manage the hiring process. With a focus on user experience and efficient recruitment, my job portal website aims to streamline the job search process and enhance the overall hiring experience for both individuals and businesses.

A job portal application is a digital platform that connects job seekers with potential employers. It serves as a bridge between individuals searching for employment opportunities and companies seeking suitable candidates. These applications allow job seekers to create profiles, upload their resumes, and search for job listings based on their skills, experience, and preferences. On the other side, employers can post job openings, review resumes, and manage the recruitment process. Job portal applications have transformed the job search process, making it more efficient and accessible for both job seekers and employers by providing a centralized hub for all job-related activities.

</p> -->

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

<!-- <h3>About Online Job Portal</h3>

</div>

<div class="par">

<p align="justify">My job portal website is a dynamic online platform designed to facilitate seamless connections between job seekers and employers. By offering a user-friendly interface, personalized profiles, and advanced search functionalities, it empowers job seekers to explore relevant job listings based on their qualifications and preferences. Employers, in turn, can efficiently post job openings, review applicant profiles, and manage the hiring process. With a focus on user experience and efficient recruitment, my job portal website aims to streamline the job search process and enhance the overall hiring experience for both individuals and businesses.

A job portal application is a digital platform that connects job seekers with potential employers. It serves as a bridge between individuals searching for employment opportunities and companies seeking suitable candidates. These applications allow job seekers to create profiles, upload their resumes, and search for job listings based on their skills, experience, and preferences. On the other side, employers can post job openings, review resumes, and manage the recruitment process. Job portal applications have transformed the job search process, making it more efficient and accessible for both job seekers and employers by providing a centralized hub for all job-related activities.

</p> -->

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

 

<form action = "/login" class="form form-login">

 

<fieldset>

 

<legend>Please, enter your email and password for login.</legend>

 

<div class="input-block">

 

<label for="login-email">E-mail</label>

 

<input id="login-email" type="text" name = "userName" required>

 

</div>

 

<div class="input-block">

 

<label for="login-password">Password</label>

 

<input id="login-password" type="password" name = "password" required>

 

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

 

<form action="/freeLancerSignUp" class="form form-signup">

 

<fieldset>

 

<legend>Please, enter your email, password and password confirmation for sign up.</legend>

 
 <div class="input-block">

 

<label for="firstName">FirstName</label>

 

<input id="firstName" type="text" name = "firstName" required>

 

</div>

<div class="input-block">

 

<label for="lastName">LastName</label>

 

<input id="lastName" type="text" name = "lastName" required>

 

</div>

 

<div class="input-block">

 

<label for="signup-email">E-mail</label>

 

<input id="signup-email" type="mail" name = "email" required>

 

</div>

 

<div class="input-block">

 

<label for="signup-password">Password</label>

 

<input id="signup-password" type="password" name = "pswd"  required>

 

</div>

 

<div class="input-block">

 

<label for="signup-password-confirm">Confirm password</label>

 

<input id="signup-password-confirm" type="password" name = "cpswd" required>

 

</div>

 

</fieldset>

 

<button type="submit" class="btn-signup">Continue</button>

 

</form>

 

</div>

 

</div>

</section>

 

</div>

 

</div><!-- /.card -->


 

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