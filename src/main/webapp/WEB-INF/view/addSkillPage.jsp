<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
	<style><%@include file="/WEB-INF/css/addSkill.css"%></style>
</head>
<body>
	<div class="container">
	<h1>Add Skill</h1>
	<form action="/updateSkillExperience" method = "post">
		<input type="text" name="skillName"><br>
		<textarea name = "description" rows="4" cols="50"></textarea><br>
		<input type="number" name = "experience"/><br>
		<input type="submit" value="addSkill">
	</form>
	</div>
</body>
</html>

