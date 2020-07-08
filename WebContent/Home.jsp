<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>No más accidentes</title>
    <link rel="stylesheet" href="css/Home.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script type="text/javascript" src="js/warpspeed.js"></script>
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
            <h3 class="title">No más accidentes!</h3>
            <p class="parable">Tu portal de prevención de riesgos..</p>
            
            <c:if test="${error != null}">
			<c:out value="${error}" />
			</c:if>
			<c:if test="${confirm != null}">
			<c:out value="${confirm}" />
			</c:if>

			<form action="${pageContext.request.contextPath }/Login" method="post">
			
            <div class="login-input">
                <label for="username">Ingresa tu usuario:</label>
                <input type="text" name="usuario" required>
            </div>
            <div class="login-input">
                <label for="password">Ingresa tu contraseña:</label>
                <input type="password" name="password" required>
            </div>
            <div>
                <input class="login-button" type="submit" value="Entrar"/>
            </div>
            </form>

            <div class="register">
                Registrate aquí:
                <a href="ClienteController?action=agregarRegistro">Cliente</a>
            </div>
        </div>
    </main>
</body>

</html>