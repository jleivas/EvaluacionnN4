<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel del Cliente</title>
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
            <p class="parable">Este es tu menú de <strong>Cliente</strong></p>
            <div>
                <div>
                    <input class="menu-button" type="button" value="Solicitar Asesoria Especial" onclick="window.location='ClienteCU1.jsp';" />
                </div>
                <div>
                    <input class="menu-button" type="button" value="Reportar Accidente" onclick="window.location='ClienteCU2.jsp';" />
                </div>
            </div>
            <div class="logout">
                <a href="../Home.jsp">Cerrar Sesion</a>
            </div>
        </div>
    </main>
    </body>

</html>