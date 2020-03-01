<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet,java.util.ArrayList"  %>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%ResultSet allMess = (ResultSet)session.getAttribute("allMess"); %>


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
	<center><h1>MESS DETAILS</h1></center>
<form action="getallthali" method="post">
<% while(allMess.next()){
	%>
		<center><h3 style="color:red"><%=allMess.getString(3) + "," + allMess.getString(5) %></h3>
		<input id="p" type="submit"  value=<%=allMess.getString(1) %>  name="mess" style="width:500px;" /></center><br><br>
	<% 
	} 
	%>  
</form>
</body> 
</html>

