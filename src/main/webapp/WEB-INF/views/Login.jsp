<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            background-image: url('https://c.pxhere.com/photos/bc/ae/lego_toys_build_building_blocks_play_children_colorful_lego_blocks-667619.jpg!d'); /* Reemplaza 'tu-imagen-de-fondo.jpg' con la ruta correcta de tu imagen */
            background-size: cover;
            background-position: center;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            background-color: rgba(255, 255, 255, 0.7);
            width: 500px;
            height: 300px;
            border-radius: 10px;
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input {
            width: 65%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #9d81ff;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #5145a0;
        }
    </style>

</head>
<body>

<form action="/verificarCredenciales" method="post">
    <h1>Bienvenido a Jugueton</h1>
    <label for="usuario">Usuario:</label>
    <input type="text" id="usuario" name="usuario" required><br>

    <label for="password">Contrasenia:</label>
    <input type="password" id="password" name="password" required><br>

    <input type="submit" value="Login">
</form>

<%
    boolean error_login;
    if (request.getAttribute("error") != null) {
        error_login = (boolean) request.getAttribute("error");

        if (error_login) {
%>
<script>
    alert("Credenciales incorrectas");
</script>
<%
        }
    }
%>
</body>
</html>