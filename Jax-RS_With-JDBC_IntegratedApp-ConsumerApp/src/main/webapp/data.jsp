<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div align="center" style="color: graytext; font-family: monospace;">
		<table border="1">
			<tr align="center">
				<td colspan="7"><h3>** ALL STUDENT DATA **</h3></td>
			</tr>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>COURSE</th>
				<th>FEE</th>
				<th>DISCOUNT</th>
				<th colspan="2">OPERATION</th>
			</tr>
			<c:forEach items="${list}" var="ob">
				<tr>
					<td>${ob.sid}</td>
					<td>${ob.sname}</td>
					<td>${ob.scourse}</td>
					<td>${ob.sfee}</td>
					<td>${ob.sdiscount}</td>
					<td><a href="delete?sid=${ob.sid}">DELETE</a></td>
					<td><a href="edit?sid=${ob.sid}">UPDATE</a></td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="7">${msg}</td>
			</tr>
		</table>
	</div>
</body>
</html>