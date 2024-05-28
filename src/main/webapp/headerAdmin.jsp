<%--
  Created by IntelliJ IDEA.
  User: edgep
  Date: 27/05/2024
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
        ul li{
            margin:0 10px;
        }

        #btn{
            height: 100%;
            background: none;
            border: none;
            padding: 0;
            font: inherit;
            cursor: pointer;
            color: inherit; /* Para que el texto sea del mismo color que el texto circundante */
            text-decoration: none; /* Otra opción: mostrar el texto subrayado */

        }

</style>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Administracion</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="panel">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Gestión de canchas</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Reservas</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/nuevoProyecto/panel/registrar">Gestión de trabajadores</a>
                </li>
                <li class="nav-item">
                    <form action="/nuevoProyecto/login" method="post">
                        <input type="hidden" name="instruccion" value="cerrar_sesion">
                        <input  id="btn" type="submit" value="Cerrar sesion">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
