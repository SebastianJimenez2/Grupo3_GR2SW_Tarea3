<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        body {
            background-image: url('https://static.vecteezy.com/system/resources/previews/002/757/571/non_2x/closed-padlock-on-digital-background-cyber-security-vector.jpg'); /* Reemplaza 'tu_imagen_de_fondo.jpg' con la ruta de tu imagen */
            background-size: cover;
        }

        #contenedor {
            align-items: center;
            margin-left: 900px;
            margin-top: 210px;
            text-align: center;
        }

        form {
            width: 300px;
            padding: 20px;
            border: 1px solid #1e7100;
            border-radius: 8px;
            background-color: rgba(255, 255, 255, 0.652);
        }

        label {
            text-align: left;
            color: rgb(0, 0, 0);
            display: block;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: rgb(66, 218, 32);
        }

        input[type="submit"]:hover {
            background-color: rgb(125, 161, 47);
        }
    </style>
</head>
<body>
<div id="contenedor">
    <form action="/aniadir-admin" method="POST">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre">

        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido">

        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario">

        <label for="contrasena">Contrasenia:</label>
        <input type="password" id="contrasena" name="contrasena">

        <label for="confirmarContrasena">Confirmar contrasenia:</label>
        <input type="password" id="confirmarContrasena" name="confirmarContrasena">

        <input type="submit" name="" id="">
    </form>
</div>

<%
    boolean errorCamposVacios;
    if (request.getAttribute("errorCamposVacios") != null) {
        errorCamposVacios = (boolean) request.getAttribute("errorCamposVacios");

        if (errorCamposVacios) {
%>
<script>
    alert("Debe rellenar todos los campos antes de enviar");
</script>
<%
        }
    }
%>

<%
    boolean errorUsuarioRepetido;
    if (request.getAttribute("errorUsuarioRepetido") != null) {
        errorUsuarioRepetido = (boolean) request.getAttribute("errorUsuarioRepetido");

        if (errorUsuarioRepetido) {
%>
<script>
    alert("Ese usuario ya existe");
</script>
<%
        }
    }
%>

<%
    boolean errorContrasenasDiferentes;
    if (request.getAttribute("errorContrasenasDiferentes") != null) {
        errorContrasenasDiferentes = (boolean) request.getAttribute("errorContrasenasDiferentes");

        if (errorContrasenasDiferentes) {
%>
<script>
    alert("Las contrasenas no coinciden");
</script>
<%
        }
    }
%>
</body>
</html>