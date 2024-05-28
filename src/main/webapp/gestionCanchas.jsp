<%--
  Created by IntelliJ IDEA.
  User: edgep
  Date: 27/05/2024
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Panel de administracion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>

        .img{
            height: 50px;
        }


    </style>

</head>
<body>
<jsp:include page="headerAdmin.jsp" />

<div class="container">


<h1>Panel de adminstracion</h1>

<h2>Nuestras canchas</h2>

<form method="post" action="/nuevoProyecto/panel">
    <input type="hidden" name="instruccion" value="aniadir">
    <input type="submit" value="Agregar nueva cancha">
</form>

<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Dirección</th>
        <th>Horario</th>
        <th>Precio</th>
        <th>Longitud</th>
        <th>Ancho</th>
        <th>Descripción</th>
        <th>Capacidad</th>
        <th>Imagen</th>
        <th>Actualizar</th>
        <th>Eliminar</th>
    </tr>
    </thead>

    <tbody>
        <c:forEach var="temp" items="${canchas}">
            <tr>

            <td>${temp.id}</td>
            <td>${temp.nombre}</td>
            <td>${temp.direccion}</td>
            <td>${temp.horario}</td>
            <td>${temp.precio}</td>
            <td>${temp.longitud}</td>
            <td>${temp.ancho}</td>
            <td>${temp.descripcion}</td>
            <td>${temp.capacidad}</td>
                <td>
                <img class="img" src="./images/${temp.imagen}">
                </td>

            <td>
                <form action="/nuevoProyecto/panel/actualizar" method="post">
                    <input type="hidden" name="instruccion" value="actualizarCancha">
                    <input type="hidden" name="id" value="${temp.id}">
                    <input type="submit" value="Actualizar">
                </form>
            </td>

            <td>
                <form action="/nuevoProyecto/panel" method="post">
                    <input type="hidden" name="instruccion" value="eliminarCancha">
                    <input type="hidden" name="id" value="${temp.id}">
                    <input type="submit" value="Eliminar">
                </form>
            </td>
    </tr>


        </c:forEach>




    </tbody>


</table>

</div>

</body>
</html>
