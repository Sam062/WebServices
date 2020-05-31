<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Register</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div align="center" style="color: graytext; font-family: monospace;">
		<fieldset>
			<form action="save" method="POST">
				<h1>** PRODUCT ENTRY PAGE **</h1>
				<table>
					<tr>
						<td>PRODUCT NAME</td>
						<td><input type="text" name="prodName"></td>
					</tr>
					<tr>
						<td>PRODUCT COST</td>
						<td><input type="text" name="prodCost" required="required"></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" value="SUBMIT"></td>
					</tr>
					<tr align="center">
						<td colspan="2">${msg}</td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>