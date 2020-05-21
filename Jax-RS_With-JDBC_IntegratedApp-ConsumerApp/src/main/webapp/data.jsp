<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div align="center" style="color: graytext;font-family: monospace;">
		<table border="1">
			<tr align="center">
				<td colspan="5"><h3>** ALL STUDENT DATA **</h3></td>
			</tr>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>COURSE</th>
				<th>FEE</th>
				<th>DISCOUNT</th>
			</tr>
			<c:forEach items="${list}" var="ob">
				<tr>
					<td>${ob.sid}</td>
					<td>${ob.sname}</td>
					<td>${ob.scourse}</td>
					<td>${ob.sfee}</td>
					<td>${ob.sdiscount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>