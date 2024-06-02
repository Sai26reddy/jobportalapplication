<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

<%@include file="/WEB-INF/css/contactus.css"%>
</style>
</head>
<body>
<small>Enter message (optional) and click button "Send"</small>
<div class="wrapper centered">
  <article class="letter">
    <div class="side">
      <h1>Contact us</h1>
      <p>
        <textarea placeholder="Your message"></textarea>
      </p>
    </div>
    <div class="side">
      <p>
        <input type="text" placeholder="Your name" >
      </p>
      <p>
        <input type="email" placeholder="Your email" >
      </p>
      <p>
        <button id="sendLetter">Send</button>
      </p>
    </div>
  </article>
  <div class="envelope front"></div>
  <div class="envelope back"></div>
</div>
<p class="result-message centered">Thank you for your message</p>
<script type="text/javascript">
function addClass() {
	  document.body.classList.add("sent");
	}

	sendLetter.addEventListener("click", addClass);
</script>
</body>
</html>