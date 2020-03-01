<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet,java.util.ArrayList"  %>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%ArrayList ownerDetailList = (ArrayList)session.getAttribute("ownerDetailList"); %>
<% ResultSet messDetailList = (ResultSet)session.getAttribute("messDetailList"); %>

<% 
int ownerId = (Integer)ownerDetailList.get(0); 
String ownerName = (String)ownerDetailList.get(1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ownerHome</title>
<link rel="stylesheet" href="css/ownerHome.css">
</head>
<body>
<div class="btn"><br>
	<label ><%= ownerName %></label><button type="submit" >Log Out</button>
	</div>
	<hr>
	<br><br>
	<center><h1>MESS DETAILS</h1></center>
<form action="getmessdetail" method="post">
<% while(messDetailList.next()){
	if(messDetailList.getInt(2)==ownerId){ 
		%>
		<% String messId = String.valueOf(messDetailList.getInt(1)); 
		String messName = messDetailList.getString(3);
		String messAdd = messDetailList.getString(5);
		%>
		<center><h3 style="color:red"><%=messName + "\n" + messAdd %></h3>
		<input id="p" type="submit"  value=<%=messId %>  name="mess" style="width:500px;" /></center><br><br>
<%		}
	} 
	%> 
	
</form>
<a href="messDetail.jsp"><button>Add Mess Detail</button></a>
</body> 
</html>

