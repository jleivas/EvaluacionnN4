<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Clientes</title>
    <link rel="stylesheet" href="<c:url value="/css/Listas.css"/>">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/js/wrapspeed.js"/>"></script>
</head>

<body onload="autoLoad()">
    <div style="position:fixed; z-index:0; top:0; left:0; width:100%; height:100%;">
        <canvas id="canvas" style="width:100%; height:100%;"></canvas>
        <script type="text/javascript">
            new WarpSpeed("canvas", {
                targetSpeed: 6.8,
                speedAdjFactor: 0.07,
                speedWhileLoading: 18
            });
        </script>
    </div>
    <main>
        <div class="box">
            <h3 class="title">Visualizar Actividades</h3>
            <p class="parable">Revisa nuestras actividades.</p>
            <div class="clientlist">
				<form action="VisActividad" method="post">
					<table>
						<tr>
							<th>Nombre Actividad:</th>
							<th>Nombre Cliente:</th>
							<th>Nombre Profesional:</th>
							<th>Fecha Visita:</th>
							<th>Situación Visita:</th>
							
						</tr>
						<c:forEach items="${listadoActividades}" var="act">
						<tr>
							<td>${act.getIdActividad()} </td>
							<td>${act.getIdCliente()}</td>
							<td>${act.getIdProf()}</td>
							<td>${act.getFechaVisita()}</td>
							<td>${act.isSituacionVisita()}</td>
                        </tr>
                        </c:forEach>

                    </table>
                    <div class="actions">
                        <a href="ActividadesController?action=EliminarRegistro&id=${act.getIdActividad()}">Eliminar</a> | <a href="${pageContext.request.contextPath}/ActualizarRegistro?id=${act.getIdActividad()}">Editar</a> | <a href="#">Crear Actividad</a>
                    </div>
                </form>
            </div>
       </div>
    </main>
</body>

</html>