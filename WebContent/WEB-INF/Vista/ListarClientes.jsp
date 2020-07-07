<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Clientes</title>
</head>
<body>
<h1>Listado de Clientes</h1>
<form action="CreacionCliente" method="post">
	<table>
	<tr>
		<th>ID</th>
		<th>Nombre Cliente</th>
	</tr>

<c:forEach items="${listadoClientes}" var="user">
	<tr>
		<td>${user.getIdCliente()} </td>
		<td>${user.getNombre()}</td>
		<td>
			<a href="${pageContext.request.contextPath}/EliminarRegistro?id=${user.getIdCliente()}">Eliminar</a>
			&nbsp;
			<a href="${pageContext.request.contextPath}/ActualizarRegistro?id=${user.getIdCliente()}">Editar</a>
		</td>
	</tr>
</c:forEach>	
	
</table>

<a href="${pageContext.request.contextPath}/CrearCliente">Crear Cliente</a>
	
</form>
</body>
</html>