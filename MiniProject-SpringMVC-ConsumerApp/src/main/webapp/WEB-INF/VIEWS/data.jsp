<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

	<%@include file="menu.jsp"%><br>
	<div align="center" style="font-family: sans-serif; color: blue;">
		<table border="1">
			<tr align="center">
				<th colspan="8">--- PRODUCT DATA ---</th>
			</tr>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>COST</th>
				<th>DISCOUNT</th>
				<th>GST</th>
				<th>TOTAL</th>
				<th colspan="2">OPERATIONS</th>
			</tr>
			<c:forEach items="${list}" var="ob">
				<tr>
					<td>${ob.prodId}</td>
					<td>${ob.prodName}</td>
					<td>${ob.prodCost}</td>
					<td>${ob.prodDiscount}</td>
					<td>${ob.prodGst}</td>
					<td>${ob.totalToPay}</td>
					<td><a href="editPage?id=${ob.prodId}">EDIT</a></td>
					<td><a href="delete?id=${ob.prodId}">DELETE</a></td>
				</tr>
			</c:forEach>
			<tr align="center">
				<th colspan="8">${msg}</th>
			</tr>
		</table>
	</div>
</body>
</html>