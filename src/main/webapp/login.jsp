<%--
  Created by IntelliJ IDEA.
  User: edgep
  Date: 26/05/2024
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login para Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<form action="/nuevoProyecto/login" method="post" class="col-md-6 mx-auto mt-5">
    <div class="mb-3">
        <input type="hidden" name="instruccion" value="autenticar">
        <label for="exampleFormControlInput1" class="form-label">Email address</label>
        <input required type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" name="email">
        <label for="inputPassword5" class="form-label">Password</label>
        <input required type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock" name="password">
        <br>
        <input class="btn btn-primary" type="submit" value="Ingresar">
    </div>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
