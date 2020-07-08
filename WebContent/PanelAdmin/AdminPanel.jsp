<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel del Administrador</title>
    <link rel="stylesheet" href="<c:url value="/css/Paneles.css"/>">
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
            <h3 class="title">Bienvenido, #</h3>
            <p class="parable">Este es tu menú de <strong>Administrador</strong></p>
            <div>
                <div>
                    <input class="menu-button" type="button" value="Mostrar listado de clientes" onclick="window.location='ClienteController?action=mostrarRegistros';" />
                    <!-- <a href="ClienteController?action=mostrarRegistros">Mostrar listado de clientes</a> --->
                </div>
                <div>
                    <input class="menu-button" type="button" value="Mostrar listado de profesionales" onclick="window.location='ProfesionalController?action=mostrarRegistros';" />
                    <!-- <a href="${pageContext.request.contextPath}/ListarProfesionales.jsp">Mostrar listado de profesionales</a> --->
                </div>
                <div>
                    <input class="menu-button" type="button" value="Mostrar listado de actividades" onclick="window.location='ActividadesController?action=mostrarRegistros';" />
                    <!-- <a href="${pageContext.request.contextPath}/ListarActividades.jsp">Mostrar listado de actividades</a> -->
                </div>
            </div>
            <div class="logout">
                <a href="../Home.jsp">Cerrar Sesion</a>
            </div>
        </div>
    </main>
    </body>

</html>