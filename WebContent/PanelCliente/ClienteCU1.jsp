<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicita una Asesoria</title>
    <link rel="stylesheet" href="<c:url value="/css/ClienteCU1.css"/>">
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
            <h3 class="title">Solicita una Asesoria</h3>
            <p class="parable">Solicita información de como prevenir un accidente.</p>
            <div class="label-input">
                <label for="fechaAsesoria">Fecha de Asesoria:</label><br>
                <input type="text" placeholder="Ingrese fecha deseada para su asesoria" name="nombre" required>
            </div>
            <div class="label-textarea">
                <label for="tipoAsesoria">Tipo de Asesoria</label>
                <textarea name="descripcion" placeholder="Ingresa una descripcion del tipo de asesoria que desea recibir." cols="49" rows="10"></textarea>
            </div>
            <div>
                <input class="submit-button" type="submit" value="Solicitar Asesoria" onclick="window.location='#';" />
            </div>
        </div>
    </main>
</body>

</html>