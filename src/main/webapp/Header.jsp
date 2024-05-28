
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Horarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Reservar</a>
                </li>
                <li class="nav-item">
                  <form action="/nuevoProyecto/login" method="post">
                      <input type="hidden" name="instruccion" value="mostrarLogin">
                      <input type="submit" value="Ingresar">
                  </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
