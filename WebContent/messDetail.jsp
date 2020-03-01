<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>messDetail</title>
<link rel="stylesheet" href="css/messDetail.css">
</head>
<body>
	<form action="messdetail" method="post" >
	<div class="login-box">
	<h1>Mess Detail</h1>
	<div class="textbox">
		Mess Name <br>
		<input type="text"  name="messName" value="">
	</div>
	
	<div class="textbox">
		Mess Phone No. <br>
		<input type="text"  name="messPhoneNo" value="">
	</div>
	<div class="textbox">
		Mess Location <br>
		<input type="text"  name="messLocation" value="">
	</div>
	<div class="textbox">
		City <br>
		<select>
		<option value="City" name="city">Pune</option>
		</select>
	</div>
	<input class="btn" type="submit" name="" value="Add">
	</div>
	</form>
</body>
</html>