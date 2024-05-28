<%--
  Created by IntelliJ IDEA.
  User: edgep
  Date: 26/05/2024
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Canchas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


    <style>
        .futbol {
            height: 400px;
        }

        .altura{
            height: 400px;
        }

    </style>
</head>
<body>
<jsp:include page="Header.jsp" />

<h1 class="text-3xl font-bold underline">Nuestras canchas</h1>
<div class="container mt-4">
<div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach var="cancha" items="${canchas}">
        <div class="col">
            <div class="card h-100" >
                <img class="card-img-top futbol" src="./images/${cancha.imagen}"/>
                <div class="card-body">
                    <h5 class="card-title">${cancha.nombre}</h5>
                    <p class="card-text">${cancha.descripcion}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Horario ${cancha.horario}</li>
                    <li class="list-group-item">Capacidad futbol ${cancha.capacidad}</li>
                    <li class="list-group-item">Precio x hora S/. ${cancha.precio}</li>
                    <li class="list-group-item">Dimensiones ${cancha.longitud}m x ${cancha.ancho}m</li>

                </ul>
                <div>
                    <a href="#" class="btn btn-primary w-100">Go somewhere</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</div>


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<!--

<form action="/nuevoProyecto/ControladorCanchas" method="get">
    <input type="hidden" name="instruccion" value="gestionarCanchas">
    <input type="submit" value="Gestionar las canchas">
</form>
-->

<a href="vistaAniadirCancha.jsp">Gestionar Canchas</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
