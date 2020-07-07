<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Cliente</title>
</head>
<body>
<h1>Ingresar Cliente</h1>

<c:if test="${confirm != null}">
	<c:out value="${confirm}" />
</c:if>

<form action="CreacionCliente" method="post">
	Nombre Cliente: <input type="text" name="nombre" /><br/>
	Nombre de Usuario: <input type="text" name="usuario" /><br/>
	Contraseña: <input type="password" name="password" /> <br/>
	<input type="submit" value="Registrar" />
</form>
</body>
</html>