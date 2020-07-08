<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reportar Accidente</title>
    <link rel="stylesheet" href="../css/ClienteCU1.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
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
            <h3 class="title">Reportar Accidente</h3>
            <p class="parable">¿Hubo un accidente? Cuentanos al respecto.</p>
            <c:forEach items="${elMensaje}"/>
      
            <div class="label-input">
                <label for="fechaAsesoria">Fecha de Accidente:</label><br>
                <input type="text" placeholder="Ingrese fecha del accidente" name="fechaAccidente" required>
            </div>
            <div class="label-textarea">
                <label for="tipoAsesoria">Tipo de Accidente</label>
                <textarea name="tipoAccidente" placeholder="Ingresa una descripcion de como ocurrió el accidente" cols="49" rows="10"></textarea>
            </div>
            <div>
                <input class="submit-button" type="submit" value="Reportar Accidente" onclick="window.location='CrearReporte.java';" />
            </div>
        </div>
    </main>
</body>

</html>