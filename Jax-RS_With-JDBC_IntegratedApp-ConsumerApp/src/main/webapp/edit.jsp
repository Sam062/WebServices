<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h2 align="center" style="color: graytext; font-family: monospace;">**
		STUDENT EDIT PAGE **</h2>
	<div align="center">
		<form action="update" method="POST">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="number" name="sid" value="${sob.sid}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="sname" value="${sob.sname}"
						required="required"></td>
				</tr>
				<tr>
					<td>COURSE</td>
					<td><input type="text" name="scourse" value="${sob.scourse}"
						required="required"></td>
				</tr>
				<tr>
					<td>FEE</td>
					<td><input type="text" name="sfee" value="${sob.sfee}"
						required="required"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="UPDATE"></td>
				</tr>
				<tr align="center">
					<td colspan="2" rowspan="5"><h3>${msg}</h3></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>