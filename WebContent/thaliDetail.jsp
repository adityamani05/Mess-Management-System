<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet,java.util.ArrayList"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%ResultSet allthali = (ResultSet)session.getAttribute("allthali"); %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ownerHome</title>
<link rel="stylesheet" href="css/ownerHome.css">
</head>
<body>
<div class="btn"><br>
	<label ><%="HELLO" %></label><button type="submit" >Log Out</button>
	</div>
	<hr>
	<br><br>
	<center><h1>Thali Detail</h1></center>
<form action="popup.html" method="post">
<% while(allthali.next()){
	%>
		<center><h3 style="color:red"><%=allthali.getString(3) + "," + allthali.getString(4) %></h3>
		<input id="p" type="submit"  value=<%=allthali.getString(5) %>  name="thali" style="width:500px;" /></center><br><br>
	<% 
	} 
	%>  
</form>
</body> 
</html>

