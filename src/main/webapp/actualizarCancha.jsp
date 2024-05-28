<%--
  Created by IntelliJ IDEA.
  User: edgep
  Date: 27/05/2024
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Actualizar Cancha</title>
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
<jsp:include page="headerAdmin.jsp"/>

<div class="container">

    <div class="row align-items-center">
        <div class="col">

        <h1 class="mt-5">Actualizar Cancha</h1>
        </div>
            <div class="col-auto">
        <a href="panel">Volver</a>
        </div>
    </div>


    <form action="/nuevoProyecto/panel/actualizar" method="post" class="row g-3" enctype="multipart/form-data">
        <input type="hidden" name="instruccion" value="actualizar">
        <input type="hidden" name="ida" value="${cancha.id}">

        <div class="form-group">
            <label for="nombre">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" value="${cancha.nombre}" required>
        </div>
        <div class="form-group">
            <label for="direccion">Dirección</label>
            <input type="text" class="form-control" id="direccion" name="direccion" value="${cancha.direccion}"
                   required>
        </div>
        <!--Modificar los select con JSTL -->
        <c:set var="horaInicio" value="${cancha.horario}"/>
        <c:set var="arregloHoraInicio" value="${fn:split(horaInicio,' ')}"/>
        <c:set var="inicio1" value="${fn:split(arregloHoraInicio[0],':' )}"/>
        <c:set var="inicio2" value="${fn:split(arregloHoraInicio[3],':' )}"/>

        <div class="col-md-6">
            <label for="horario_inicio">Horario de Inicio</label>
            <select class="form-control" id="horario_inicio" name="horario-inicio" required>
                <c:forEach var="hora" begin="7" end="12">
                    <option value="<c:choose><c:when test='${hora < 10}'>0${hora}:00 AM</c:when><c:when test='${hora < 12}'>${hora}:00 AM</c:when><c:otherwise>${hora}:00 PM</c:otherwise></c:choose>"
                            <c:if test="${inicio1[0] == hora}">selected</c:if>>
                        <c:choose><c:when test='${hora < 10}'>0${hora}:00 AM</c:when><c:when test='${hora < 12}'>${hora}:00 AM</c:when><c:otherwise>${hora}:00 PM</c:otherwise></c:choose>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-6">
            <label for="horario_fin">Horario de Fin</label>
            <select class="form-control" id="horario_fin" name="horario-fin" required>

                <!-- Seleccionar una opcion-->
                <c:forEach var="hora" begin="7" end="12">
                    <option value="<c:choose><c:when test='${hora < 10}'>0${hora}:00 PM</c:when><c:when test='${hora < 12}'>${hora}:00 PM</c:when><c:otherwise>${hora}:00 AM</c:otherwise></c:choose>"
                            <c:if test="${inicio2[0] == hora}">selected</c:if>>
                        <c:choose><c:when test='${hora < 10}'>0${hora}:00 PM</c:when><c:when test='${hora < 12}'>${hora}:00 PM</c:when><c:otherwise>${hora}:00 AM</c:otherwise></c:choose>
                    </option>
                </c:forEach>

            </select>
        </div>

        <div class="form-group col-md-3">
            <label for="precio">Precio por Hora (S/.)</label>
            <input type="number" step="0.01" class="form-control" id="precio" name="precio" required
                   value="${cancha.precio}">
        </div>
        <div class="form-group col-md-3">
            <label for="longitud">Longitud (m)</label>
            <input type="number" class="form-control" id="longitud" name="longitud" required value="${cancha.longitud}">
        </div>
        <div class="form-group col-md-3">
            <label for="ancho">Ancho (m)</label>
            <input type="number" class="form-control" id="ancho" name="ancho" required value="${cancha.ancho}">
        </div>

        <div class="form-group col-md-3">

            <c:set var="capa" value="${cancha.capacidad}"/>
            <label for="capacidad">Capacidad</label>
            <select class="form-control" id="capacidad" name="capacidad" required>
                <c:forEach var="capacidad" begin="7" end="11" step="2">
                    <option value="${capacidad}"
                            <c:if test="${capacidad==capa}">selected</c:if>
                    >
                        Fútbol ${capacidad}
                    </option>
                </c:forEach>

            </select>
        </div>
        <div class="form-group">
            <label for="descripcion">Descripción</label>
            <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required
                      >${cancha.descripcion}</textarea>
        </div>

        <div class="form-group mb-3">
            <label for="formFile" class="form-label">Seleccione la imagen de la Cancha</label>
            <input class="form-control" type="file" id="formFile" name="rutaImagen">
        </div>
        <input type="submit" class="btn btn-primary" value="Añadir cancha"/>
    </form>
</div>

</body>
</html>
