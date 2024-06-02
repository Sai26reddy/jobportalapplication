
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

    

<title>Recruiter Login</title>

<style>

<%@include file="/WEB-INF/css/RecruiterLogIn.css"%>

</style>

</head>

<body>

<body>

    <div class="Main-container">

        <div class="container-login">

            <div class="wrap-login">

 

                <div class="login-pic">

                    <img src="lappic.png" alt="IMG">

                </div>

 

                <form action="/recruitersignin" method="post" class="login-form">

                    <span class="login-form-title">Login</span>

 

                    <div class="wrap-input">

                        <input type="text" class="input" name="user_id" placeholder="UserId" required>

                        <span class="focus-input"></span>

                        <span class="symbol-input">

                            <i class="fa fa-envelope" aria-hidden="true"></i>

                        </span>

                    </div>

                    <div class="wrap-input">

                        <input type="password" class="input" name="password" placeholder="Password" required>

                        <span class="focus-input"></span>

                        <span class="symbol-input">

                            <i class="fa fa-lock" aria-hidden="true"></i>

                        </span>

                    </div>

 

                    <div class="login-form-btn-container">

                        <button class="login-form-btn">Login</button>

                    </div>

 

                  <div class="text-center p-t-1">

                      <a href="/recruiterSignUpPage" class="txt2">Create Your Account <i class="fa fa-long-arrow-right " aria-hidden="true"></i></a>

                  </div>
			    </form>
		    </div>

        </div>

    </div>

 

</body>

 

</body>

</html>