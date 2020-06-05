<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">-- USER REGISTRATION PAGE --</h1>
	<hr>

	<div align="center" style="font-family: monospace;">
		<form:form modelAttribute="userReg" method="POST" action="show">

			<label> PRODUCT ID : </label>
			<form:input path="pid" /><br>

			<label> PRODUCT NAME : </label>
			<form:input path="pname" /><br>

			<label>PRODUCT COST : </label>
			<form:input path="pcost" /><br>

			<input type="submit" value="SUBMIT">
		</form:form>
	</div>


</body>
</html>