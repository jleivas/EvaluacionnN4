<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario Profesional</title>
    <link rel="stylesheet" href="../css/FormProf.css">
    <script type="text/javascript" src="../js/warpspeed.js"></script>
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
            <h3 class="title">Ingresar Profesional</h3>
            <p class="parable">Danos tus datos y te daremos acceso.</p>
            
            <c:if test="${confirm != null}">
			<c:out value="${confirm}" />
			</c:if>
			
			<form action="CreacionProf" method="post">
	            <div class="label-input">
	                <label for="name">Nombre:</label><br>
	                <input type="text" placeholder="Ingresa tu nombre" name="nombre" required>
	            </div>
	            <div class="label-input">
	                <label for="Nombre">Usuario deseado:</label><br>
	                <input type="text" placeholder="Ingresa tu usuario" name="usuario" required>
	            </div>
	            <div class="label-input">
	                <label for="psw">Contraseña</label><br>
	                <input type="password" placeholder="Ingresa tu contraseña" name="password" required>
	            </div>
	            <div>
	                <input class="submit-button" type="submit" value="Enviar e ir al Inicio"/>
	            </div>
            </form>
        </div>
    </main>
</body>

</html>