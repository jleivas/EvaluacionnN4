<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actividades</title>
</head>
<body>

<form action="VisActividad" method="post">
	<table>
	<tr>
		<th>Nombre Actividad:</th>
		<th>Nombre Cliente:</th>
		<th>Nombre Profesional:</th>
		<th>Fecha Visita:</th>
		<th>Situación Visita:</th>
		<th>Precio:</th>
	</tr>

<c:forEach items="${listadoActividades}" var="act">
	<tr>
		<td>${act.getIdCliente()} </td>
		<td>${act.getNombre()}</td>
			<a href="${pageContext.request.contextPath}/EliminarRegistro?id=${act.getIdActividad()}">Eliminar</a>
			&nbsp;
			<a href="${pageContext.request.contextPath}/ActualizarRegistro?id=${act.getIdActividad()}">Editar</a>
		</td>
	</tr>
</c:forEach>	
	
</table>

</body>
</html>