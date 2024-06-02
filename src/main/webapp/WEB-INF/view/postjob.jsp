<!DOCTYPE html>
<html>
<head>
<title>Navigation Bar</title>
<style>
body {
	background-size: cover;
}

.navbar {
	width: 100%;
	background-color: #555;
	overflow: auto;
}

/* Navigation links */
.navbar a {
	float: left;
	padding: 12px;
	color: white;
	text-decoration: none;
	font-size: 17px;
	width: 14%;
	/* Four equal-width links. If you have two links, use 50%, and 33.33% for three links, etc.. */
	text-align: center; /* If you want the text to be centered */
}

/* Add a background color on mouse-over */
.navbar a:hover {
	background-color: #000;
}

/* Style the current/active link */
.navbar a.active {
	background-color: #000;
}

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

table {
	border-collapse: collapse;
	width: 60%;
	margin: auto;
	border: 3px solid black;
	margin-top: 50px;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

td input[type="text"] {
	width: 100%;
	padding: 5px;
	box-sizing: border-box;
}

td[colspan="2"] {
	text-align: center;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	cursor: pointer;
	border-radius: 5px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<h2 align="center">Enter Requirements Details</h2>
	<form method="post" action="/postajob">
		<table align="center" border="3px">
			<tr>
				<td>Job Title:</td>
				<td><input type="text" name="jobTitle" required=""></td>
			</tr>
			<tr>
				<td>Skill Required:</td>
				<td><input type="text" name="skill" required=""></td>
			</tr>
			<tr>
				<td>Skill Description:</td>

				<td><input type="text" name="skilldescription" required="">
				</td>
			</tr>
			<tr>
				<td>Experience:</td>

				<td><input type="text" name="experience" required=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit"></td>
			</tr>
		</table>
		</form>
</body>
</html>