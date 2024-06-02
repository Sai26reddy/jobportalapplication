<%@page import="com.digit.jobPortalApplication.model.BookMarkJob"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<%@ include file="/WEB-INF/css/viewAllJobs.css" %>
<%@ include file="/WEB-INF/css/logintransition.css" %>
<%@ include file="/WEB-INF/css/freelancerhomepage.css" %>

*,
*::before,
*::after {
    box-sizing: border-box;
}

 

body {
    margin: 0;
    font-family: Roboto, -apple-system, 'Helvetica Neue', 'Segoe UI', Arial, sans-serif;
    background: #3b4465;
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
    color: #fff;
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
    color: #999;
    background-color: transparent;
    border: none;
    outline: none;
    transform: translateX(0);
    transition: all .3s ease-out;
}

 

.form-wrapper.is-active .switcher-login {
    color: #fff;
    transform: translateX(90px);
}

 

.form-wrapper.is-active .switcher-signup {
    color: #fff;
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
</style>
</head>
<body>
	<c:forEach items = "${listOfAllJobs}" var = "job">
	<div class="slide-right">
		<div class="job-card">
		    <div class="job-details">
		      <div class="job-role">JobRole : ${job.jobRole}</div>
		      <div class="skills">Skills Required:${job.skill.name}</div>
		      <div class="posted-by">Posted by: ${job.recruiter.firstName}</div>
		    </div>
		    <div class="buttons">
		      <c:choose>
					<c:when test = "${isLogin}">
						<a href = "/applyJob/${job.id}"><button class="btn">Apply</button></a>
					</c:when>
					<c:otherwise>
						<a href = "#login-show"><button class="btn">Apply</button></a>
					</c:otherwise>
				</c:choose>
		      	<c:set var = "found" value = "false"></c:set>
				<c:forEach items="${bookmarkjobs}" var="item">
					<c:if test="${item.job==job}">
						<c:set var="found" value="true" />
					</c:if>
				</c:forEach>
				<c:choose>
					<c:when test = "${found eq 'true'}">
						<button class="btn dis" disabled>BookMark</button>
					</c:when>
					<c:otherwise>
						<c:choose>
					<c:when test = "${isLogin}">
						<a href = "/bookMarkJob/${job.id}"><button class="btn">BookMark</button></a>
					</c:when>
					<c:otherwise>
						<a href = "#login-show"><button class="btn">BookMark</button></a>
					</c:otherwise>
				</c:choose>
					</c:otherwise>
				</c:choose>
		    </div>
  </div>
  </div>

      </c:forEach>


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

 

<input id="login-email" type="email" name = "userName" required>

 

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

 

<input id="signup-email" type="email" name = "email" required>

 

</div>

 

<div class="input-block">

 

<label for="signup-password">Password</label>

 

<input id="signup-password" type="password" name = "pswd" required>

 

</div>

 

<div class="input-block">

 

<label for="signup-password-confirm">Confirm password</label>

 

<input id="signup-password-confirm" type="password"  name = "cpswd" required>

 

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