
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<style type="text/css">

<%@include file="/WEB-INF/css/RecruiterSignUp.css"%>

</style>

<title>Recruiter Sign Up</title>

</head>

<body>

<div class="Main-container">

        <div class="container-login">

            <div class="wrap-login">

 

                <div class="login-pic">

                    <img src="lappic.png" alt="IMG">

                </div>

 

                <form action="/requestadmin" method="post" class="login-form">

                    <span class="login-form-title">Sign Up</span>

 

                    <div class="wrap-input">

                        <input type="text" class="input" name="firstName" placeholder="First Name" required>

                        <span class="focus-input"></span>

                        <span class="symbol-input">

                            <i class="fa fa-envelope" aria-hidden="true"></i>

                        </span>

                    </div>

                    <div class="wrap-input">

                        <input type="text" class="input" name="lastName" placeholder="Last Name" required>

                        <span class="focus-input"></span>

                        <span class="symbol-input">

                            <i class="fa fa-envelope" aria-hidden="true"></i>

                        </span>

                    </div>

                    <div class="wrap-input">

                        <input type="text" class="input" name="mail" placeholder="Email" required>

                        <span class="focus-input"></span>

                        <span class="symbol-input">

                            <i class="fa fa-envelope" aria-hidden="true"></i>

                        </span>

                    </div>

                    <div class="wrap-input">

                        <input type="text" class="input" name="coverLetter" placeholder="Cover Letter" required>

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

                    <div class="wrap-input">

                        <input type="password" class="input" name="confirmPassword" placeholder="Confirm Password" required>

                        <span class="focus-input"></span>

                        <span class="symbol-input">

                            <i class="fa fa-lock" aria-hidden="true"></i>

                        </span>

                    </div>

 

                    <div class="login-form-btn-container">

                        <button class="login-form-btn">Sign Up</button>

                    </div>

 

                  

                  

                </form>

 

            </div>

        </div>

    </div>

 

</body>

</html>