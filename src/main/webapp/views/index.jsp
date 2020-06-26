<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	welcome page for home controller
	
	<form action="addAliens">
		Enter your id: <input type="text" name="aid"><br>
		Enter your name: <input type="text" name="aname"><br>	
		<input type="submit">
	</form>
	<hr>
	<form action="fetchAlien" method="get">
		Enter the id: <input type="text" name="aid">
		<input type="submit">
	</form>
</body>
</html>