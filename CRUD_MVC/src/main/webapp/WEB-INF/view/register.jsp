<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2  align="center">Register Page</h2>
<form action="save" method="Post">
	<table align="center">
	<tr>
	<td>ID </td>
	<td><input type="Number" name="uid" placeholder="Enter ID"></td>
	<tr></tr>
	</tr>
	<tr>
	<td>Name</td>
	<td><input type="text" name="uname" placeholder="Enter Name"></td>
	</tr>
	<tr></tr>
	<tr>
	<td>Email</td>
	<td><input type="text" name="uemail" placeholder="Enter Email"></td>
	</tr>
	<tr></tr>
	<tr>
	<td>Address</td>
	<td><input type="text" name="uaddr" placeholder="Enter Address"></td>
	</tr>
	<tr></tr>
	<tr>
	<td>Phone</td>
	<td><input type="text" name="uphone" placeholder="Enter Phone"></td>
	</tr>
	<tr> <td alngi="center"><input type="Submit" values="Save"></td></tr>
	</table>
	
</form>

</body>
</html>