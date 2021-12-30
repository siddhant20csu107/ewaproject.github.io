<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<%@ include file = "header.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  overflow-x: hidden;
  overflow-y: hidden;
}

* {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
}

.hero{
	height: 100%;
	width: 100%;
	background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url("https://t4.ftcdn.net/jpg/01/19/11/55/360_F_119115529_mEnw3lGpLdlDkfLgRcVSbFRuVl6sMDty.jpg");
 	background-position: center;
 	background-size: cover;
 	position: absolute;
}

.form-box{
	width: 380px;
	height: 460px;
	position: relative;
	margin: 6% auto;
	background: white;
	padding: 5px;
	overflow: hidden;
}
.button-box{
	width: 220px;
	margin: 30px auto;
	position: relative;
	box-shadow: 0 0 20px 9px #ff61241f;
	border-radius: 30px;
}

.toggle-btn{
	padding: 10px 30px;
	cursor: pointer;
	background: transparent;
	border: 0;
	outline: none;
	position: relative;
}
#btn{
	top: 0;
	left: 0;
	position: absolute;
	width: 110px;
	height: 100%;
	background: linear-gradient(to right, #ff105f,#ffad06);
	border-radius: 30px;
	transition: .5s;
}

.input-group{
	top: 180px;
	position: absolute;
	width: 280px;
	transition: .5s;
}

.input-field{
	width: 100%;
	padding: 10px 0;
	margin: 5px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1px solid #999;
	outline: none;
	background: transparent;
}

.submit-btn{
	width: 85%;

	padding: 10px 30px;
	cursor: pointer;
	display: block;
	margin: auto;
	background: linear-gradient(to right, #ff105f,#ffad06);
	border: 0;
	outline: none;
	border-radius: 30px;
}

.check-box{
	margin: 30px 10px 30px 0;
}
span{
	color: #777;
	font-size: 12.5px;
	bottom: 68px;
	position: absolute;
}
#login{
	left:50px;
}
#register{
	left:450px;
}
</style>

<title>UIDAI</title>
</head>
<body style="">
	<div class = "hero">
		<div class = "form-box">
			<div class = "button-box">
				<div id="btn"></div>
				<button type = "button" class = "toggle-btn" onclick="login()">Log in</button>
				<button type = "button" class = "toggle-btn"onclick="register()">Register</button>
			</div>
			<form id ="login"class="input-group" action="LoginServlet" method = "post">
				<input type = "text" class = "input-field" placeholder = "Mobile Number (In Numbers Only) " name = "mobile"  maxlength="10" minlength="10" pattern="[0-9]*" required>
				<input type = "password" class = "input-field" placeholder = "Enter Password" name = "upass" required>
				<input type = "checkbox" class = "check-box"><span>Remember Password</span>
				<button type="submit" class="submit-btn">Login Me</button>
			</form>
			<form id="register" class="input-group" action="RegistrationServlet" method = "post">
				<input type = "text" class = "input-field" placeholder = "New Mobile Number (In Numbers Only)" name = "mobile"  maxlength="10" minlength="10" pattern="[0-9]*" required>
				<input type = "password" class = "input-field" placeholder = "Enter Password" name = "upass" required>
				<input type = "checkbox" class = "check-box" required><span>I agree to the terms & conditions</span>
				<button type="submit" class="submit-btn">Register Me</button>    
			</form>
		</div>
	</div>
	
	<script>
		var x = document.getElementById("login");
		var y = document.getElementById("register");
		var z = document.getElementById("btn");
		
		function register(){
			x.style.left = "-400px";
			y.style.left = "50px";
			z.style.left = "110px";
		}
		function login(){
			x.style.left = "50px";
			y.style.left = "450px";
			z.style.left = " 0px";
		}
		
	</script>
	
	
</body>

</html>