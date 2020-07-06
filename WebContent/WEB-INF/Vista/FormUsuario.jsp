<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FormUsuario</title>
</head>
<body>
<h1>Creación Usuario</h1>

<c:if test="${confirm != null}">
	<c:out value="${confirm}" />
</c:if>

<form action="CreacionUsuario" method="post">
	Nombre de Usuario: <input type="text" name="usuario" /><br/>
	Contraseña: <input type="password" name="contraseña" /> <br/>
	<input type="submit" value="Agregar usuario" />
</form>
</body>
</html>