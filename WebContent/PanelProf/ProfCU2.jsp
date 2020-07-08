<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ingresa una Actividad</title>
    <link rel="stylesheet" href="<c:url value="/css/ProfCU2.css"/>">
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
            <h3 class="title">Ingresa una Actividad</h3>
            <p class="parable">¿Se te ocurrió como prevenir un riesgo? Ingresa tu idea aquí.</p>
            <div class="label-input">
                <label for="nombre">Nombre de Actividad:</label><br>
                <input type="text" placeholder="Ingresa tu nombre" name="nombre" required>
            </div>
            <div class="label-textarea">
                <label for="descripcion">Descripcion de Actividad</label>
                <textarea name="descripcion" placeholder="Ingresa una breve descripcion de la actividad" cols="49" rows="10"></textarea>
            </div>
            <div class="label-input">
                <label for="fecha">Fecha</label><br>
                <input type="text" placeholder="Ingresa fecha de Actividad" name="fecha" required>
            </div>
            <div class="label-input">
                <label for="precio">Precio</label><br>
                <input type="text" placeholder="Ingresa precio estimado a cobrar" name="precio" required>
            </div>
            <div>
                <input class="submit-button" type="submit" value="Ingresar Actividad" onclick="window.location='index.html';" />
            </div>
        </div>
    </main>
</body>

</html>