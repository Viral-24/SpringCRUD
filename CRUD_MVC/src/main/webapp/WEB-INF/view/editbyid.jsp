<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>	
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit title here</title>
</head>
<body>


	<form action="editbyid{id}" method="POST">
	User ID:	<input type="text" name="uid" value="${List.getId()}"><br><br>
  	User Name:	<input type="text" name="uname" value="${List.getName()}"><br><br>
    User Email:	<input type="text" name="uemail" value="${List.getEmail()}"><br><br>
    User Name:	<input type="text" name="uaddr" value="${List.getAddr()}"><br><br>
    User Email:	<input type="text" name="uphone" value="${List.getPhone()}"><br><br>
    
    <input type="submit" value="submit">
		
	</form>
</body>
</html>