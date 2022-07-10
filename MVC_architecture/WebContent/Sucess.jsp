<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<body bgcolor="yellow">
	<h1>Registration SucessFull</h1>
	<!-- Fetch Employee object From scope -->
	<%
		String un = (String) request.getAttribute("UserName");
	%>
	<font color="red" size="6">Register UserName is <%=un%></font>
</body>
</html>