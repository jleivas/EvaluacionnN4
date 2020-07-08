<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Profesionales</title>
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
            <h3 class="title">Lista de Profesionales</h3>
            <p class="parable">Revisa los datos de nuestros profesionales en tiempo real.</p>
            <div class="clientlist">
                <form action="ProfesionalController" method="post">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Usuario</th>
                        </tr>
                        <c:forEach items="${listadoProfesionales}" var="user">
                            <tr>
                                <td>${user.getIdProf()} </td>
                                <td>${user.getNombre()}</td>
                                <td>${user.getUsuario()}</td>
                            </tr>
                        </c:forEach>

                    </table>
                    <div class="actions">
                        <a href="ProfesionalController?action=eliminarRegistro&idCliente=${user.getIdProf()}">Eliminar</a> | <a href="${pageContext.request.contextPath}/ActualizarProfesional?idCliente=${user.getIdProf()}">Editar</a> | <a href="ProfesionalController?action=agregarRegistro">Crear Profesional</a>
                    </div>
                    
                </form>
               		<div class="submit-button">
                	<a href="${pageContext.request.contextPath}/PanelAdmin/AdminPanel.jsp">Salir</a>	
            		</div>
            		
            </div>
        </div>
    </main>
</body>

</html>