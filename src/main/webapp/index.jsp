<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    HttpSession sesion = request.getSession();
%>

<c:if test="${not empty sessionScope.admin}">
    <h1><c:out value="${admin.nombre}"/>
    </h1>
</c:if>
<c:if test="${empty sessionScope.admin}">
    <c:redirect url="login.jsp" />
</c:if>
<br/>
<form method="post" action="/nuevoProyecto/login">
    <input type="hidden" name="instruccion" value="cerrar_sesion">
    <input type="submit" value="Cerrar sesion">
</form>

</body>
</html>