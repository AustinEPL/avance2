<%--
  Created by IntelliJ IDEA.
  User: edgep
  Date: 26/05/2024
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>
        .container {
            max-width: 50%;
            margin: auto;
        }
    </style>

</head>
<body>
<jsp:include page="headerAdmin.jsp" />

<div class="container">
    <header>

        <div class="row align-items-center">
            <div class="col">

                <h1 class="mt-5">Añadir Cancha</h1>
            </div>
            <div class="col-auto">
                <a href="panel">Volver</a>
            </div>
        </div>

    <form action="/nuevoProyecto/panel" method="post" class="row g-3" enctype="multipart/form-data" >
        <input type="hidden" name="instruccion" value="aniadirCancha">
        <div class="form-group">
            <label for="nombre">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="form-group">
            <label for="direccion">Dirección</label>
            <input type="text" class="form-control" id="direccion" name="direccion" required>
        </div>

        <div class="col-md-6">
            <label for="horario_inicio">Horario de Inicio</label>
            <select class="form-control" id="horario_inicio" name="horario-inicio" required>
                <option value="06:00 AM">06:00 AM</option>
                <option value="07:00 AM">07:00 AM</option>
                <option value="08:00 AM">08:00 AM</option>
                <option value="09:00 AM">09:00 AM</option>
                <option value="10:00 AM">10:00 AM</option>
                <option value="11:00 AM">11:00 AM</option>
                <option value="12:00 PM">12:00 PM</option>
            </select>
        </div>
        <div class="col-md-6">
            <label for="horario_fin">Horario de Fin</label>
            <select class="form-control" id="horario_fin" name="horario-fin" required>
                <option value="07:00 PM">07:00 PM</option>
                <option value="08:00 PM">08:00 PM</option>
                <option value="09:00 PM">09:00 PM</option>
                <option value="10:00 PM">10:00 PM</option>
                <option value="11:00 PM">11:00 PM</option>
                <option value="12:00 AM">12:00 AM</option>
            </select>
        </div>

        <div class="form-group col-md-3">
            <label for="precio">Precio por Hora (S/.)</label>
            <input type="number" step="0.01" class="form-control" id="precio" name="precio" required>
        </div>
        <div class="form-group col-md-3">
            <label for="longitud">Longitud (m)</label>
            <input type="number" class="form-control" id="longitud" name="longitud" required>
        </div>
        <div class="form-group col-md-3">
            <label for="ancho">Ancho (m)</label>
            <input type="number" class="form-control" id="ancho" name="ancho" required>
        </div>

        <div class="form-group col-md-3">
            <label for="capacidad">Capacidad</label>
            <select class="form-control" id="capacidad" name="capacidad" required>
                <option value="7">Fútbol 7</option>
                <option value="9">Fútbol 9</option>
                <option value="11">Fútbol 11</option>
            </select>
        </div>
        <div class="form-group">
            <label for="descripcion">Descripción</label>
            <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required></textarea>
        </div>

        <div class="form-group mb-3">
            <label for="formFile" class="form-label">Seleccione la imagen de la Cancha</label>
            <input class="form-control" type="file" id="formFile" required name="rutaImagen">
        </div>
        <input type="submit" class="btn btn-primary" value="Añadir cancha" />
    </form>
</div>

</body>
</html>
