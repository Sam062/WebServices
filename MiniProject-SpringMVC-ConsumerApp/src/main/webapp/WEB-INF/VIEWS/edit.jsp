<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
	<%@include file="menu.jsp"%>
	<div align="center" style="color: graytext; font-family: monospace;">
		<fieldset>
			<form action="update" method="POST">
				<h1>-- PRODUCT EDIT PAGE --</h1>
				<table>
					<tr>
						<td>PRODUCT ID</td>
						<td><input type="text" name="prodId" value="${ob.prodId}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>PRODUCT NAME</td>
						<td><input type="text" name="prodName" value="${ob.prodName}"
							required="required"></td>
					</tr>
					<tr>
						<td>PRODUCT COST</td>
						<td><input type="text" name="prodCost" value="${ob.prodCost}"
							required="required"></td>
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