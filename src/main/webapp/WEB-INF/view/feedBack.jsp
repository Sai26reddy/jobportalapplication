<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<title>Feedback Page</title>

<style>
body {
	background-image: url('Backdrop_Office-02.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	margin: 0;
	padding: 0;
}

.navbar {
	background-color: #ffaa00;
	padding: 10px;
	display: flex;
	justify-content: flex-end;
}

.feed-form {
	background-color: rgba(255, 255, 255, 0.8);
	padding: 20px;
	margin: 50px auto;
	width: 70%;
	border-radius: 20px;
}

textarea {
	width: 100%;
}

.stars {
	display: flex;
	font-size: larger;
	font-weight: bold;
}

input[type=submit] {
	padding: 4px;
	font-size: large;
	width: 30%;
}

.cmts {
	font-size: larger;
	font-weight: bold;
}

.btns {
	display: flex;
	justify-content: center;
}
</style>

</head>



<body>
	<div class="navbar">

		<div style="margin-right: 20px;">
			<img
				src="https://tse2.mm.bing.net/th/id/OIP.ED1s_EBJoe_u_H3hPAAEVwHaHa?pid=ImgDet&rs=1"
				height="30px" width="30px" style="border-radius: 50%;"> </a>

		</div>

	</div>



	<h1 style="text-align: center;">Feedback Form</h1>

	<div class="feed-form">

		<form action="/submitFeedBack/${feedbackId}">

			<label for="comments" class="cmts">Comments:</label>

			<textarea id="comments" name="comments" rows="5" cols="33" required></textarea>
			<br> <br>

			<div class="stars">
				<label for="rating">Star Rating:</label> 
				<input type="radio" name="star" id="star" value = 1> <label for="1">1&#11088;</label>

				<input type="radio" name="star" id="star" value = 2> <label for="2">2&#11088;</label>

				<input type="radio" name="star" id="star" value = 3> <label for="3">3&#11088;</label>

				<input type="radio" name="star" id="star" value = 4> <label for="4">4&#11088;</label>

				<input type="radio" name="star" id="star" value = 5> <label for="5">5&#11088;</label>
			</div>
			<br> <br>
			<div class="btns">
				<input type="submit" value="Submit">
			</div>
		</form>

	</div>
</body>
</html>