<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Thali</title>
<link rel="stylesheet" href="css/addThali.css">
</head>
<body>

<body>	<form action="addthali" method="post">
	<div class="btn"><br>
	<label1>.User</label1>
	<label >.Guest</label><button type="submit" name="">Log Out</button>
	</div>
	<hr>
	<br><br>
	<div class="login-box">
	<h1>Thali Discription</h1>

	<div class="textbox">
		Thali Name <br>
		<input type="text" placeholder="Thali Name" name="thaliName" value="">
	</div>
	
	<div class="box">
		Thali Detail <br>
		<textarea style="font-size:0.8em;" rows="10" name="thaliDes">
		</textarea>
	</div>
	<div class="textbox">
		Price <br>
		<input type="number" placeholder="Price" name="thaliPrice" value="">
	</div>
	<input class="btn" type="submit" value="Add Thali">
	</div>
	</form>
</body>
</html>