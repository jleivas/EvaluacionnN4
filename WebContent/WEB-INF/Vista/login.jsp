<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesion</title>
</head>
<body>

<form action="logIN" method="post">
	Nombre de Usuario: <input type="text" name="usuario" /><br/>
	Contraseņa: <input type="password" name="contraseņa" /> <br/>
	<input type="submit" value="logIN" />
</form>

</body>
</html>