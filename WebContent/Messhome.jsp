<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"  import="java.util.ArrayList" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ArrayList detailOfMess = (ArrayList)session.getAttribute("detailOfMess"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MessHome</title>
<link rel="stylesheet" href="css/messHome.css">
</head>
<body>	
<label><%=detailOfMess.get(2) %></label>
<hr>
	<div class="wrapper">
	<div class="btn">
	<a href="addThali.jsp"><button>Add New Thali</button></a><br><br>
	<a href="#"><button  type="submit" name="">Order List</button></a><br><br>
	<a href="#"><button  type="submit" name="">Subscription List</button></a><br><br>
	<a href="#"><button  type="submit" name="">Menu List</button></a>
	</div>
	</div>
</body>
</html>