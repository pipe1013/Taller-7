<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <!--METADATA-->
    <!--charset para caracteres especiales-->
    <meta charset="utf-8">
    <!--autor-->
    <meta name="author" content="Felipe">
    <!--descripción-->
    <meta name="description" content="Formulario de registro de la empresa MY APP, donde se requiere datos para poder acceder">
    <!--keywords-->
    <meta name="keywords" content="registro de usuario,formulario de registro, crear cuenta, registro en linea ">
    <!--minimun responsive viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--TITTLE-->
    <title>Registro de categoria  MY APP</title>
    <!--FAVICON-->
    <link rel="icon" type="image/x-icon" href="img/icono.png">
    <!--CSS-->
    <!--bootstrap css/ icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <!--custom css-->
    <link rel="stylesheet" href="css/signin.css">
</head>
<body>
<!--login form-->
<main class="form-signin w-100 m-auto">
    <form action="registerCategory" method="post">
        <img class="mb-4" src="img/icono.png" alt="MY APP" width=100>
        <h4 class="text-secondary">MY -APP</h4>
        <h1 class="h5 mb-3 fw-normal">Categoría</h1>

        <div class="form-floating">
            <input type="number" name="category_id" class="form-control" id="floatingId"
                   placeholder="ingrese su categoria" required pattern="{60}">
            <label for="floatingId">Categoría:</label><br>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
        <div id="register" class="btn">
            <a href="index.jsp">Login</a>
            <a href="registro.jsp">Registrarse</a>
            <a href="product.jsp">Registrar Producto</a>
        </div>
        <p class="mt-3 mb-3 text-muted">Todos los Derechos Reservados MY APP
            © <%=displayDate()%>
        </p>

    </form>
</main>
<!--Bootstrap script-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<%!
    public String displayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYY");
        Date date = Calendar.getInstance().getTime();
        return dateFormat.format(date);
    }
%>
</body>
</html>
