<%--
  Created by IntelliJ IDEA.
  User: edgep
  Date: 28/05/2024
  Time: 00:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar</title>
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
<div class="container">
    <h1 class="text-center mt-5">Registro de Administrador</h1>
<form action="/nuevoProyecto/panel/registrar" method="POST" class="row g-3">
    <input type="hidden" name="instruccion" value="registrarA">
    <div class=" col-md-6">
        <label for="nombre" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="nombre" name="nombre" required>
    </div>
    <div class="col-md-6">
        <label for="apellidos" class="form-label">Apellidos</label>
        <input type="text" class="form-control" id="apellidos" name="apellidos" required>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Contraseña</label>
        <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <div class="mb-3 col-md-6">
        <label for="dni" class="form-label">DNI</label>
        <input type="number" class="form-control" id="dni" name="dni" required>
    </div>
    <div class="mb-3 col-md-6">
        <label for="celular" class="form-label">Celular</label>
        <input type="tel" class="form-control" id="celular" name="celular" required>
    </div>
    <div class="mb-3">
        <label for="cargo" class="form-label">Cargo</label>
        <select class="form-select" id="cargo" name="cargo" required>
            <option value="" selected disabled>Seleccione un cargo</option>
            <option value="empleado">Empleado</option>
            <option value="admin">Administrador</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Registrar</button>
</form>
</div>
</body>
</html>
