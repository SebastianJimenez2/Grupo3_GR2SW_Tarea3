<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion de Juguete</title>
    <style>
        body {
            background-image: url('https://png.pngtree.com/background/20230626/original/pngtree-toys-galore-in-a-3d-rendered-kid-s-play-room-picture-image_4057482.jpg'); /* Reemplaza 'tu-imagen-de-fondo.jpg' con la ruta correcta de tu imagen */
            background-size: cover;
            background-position: center;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: rgba(255, 255, 255, 0.7);
            padding: 20px;
            border-radius: 10px;
            width: 400px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-top: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        h1 {
            text-align: center;
        }

        input[type="submit"] {
            background-color: #3673f8;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #263a6c;
        }
    </style>
</head>
<body>
<form action="/registrar-juguete" method="post">
    <h1>Registro de Juguete</h1>
    <label for="IDJuguete">ID del Juguete:</label>
    <input type="number" id="IDJuguete" name="IDJuguete" required>

    <label for="PrecioJuguete">Precio:</label>
    <input type="number" id="PrecioJuguete" name="PrecioJuguete" required>

    <label for="Cantidad">Cantidad:</label>
    <input type="text" id="Cantidad" name="Cantidad" required>

    <input type="submit" value="Registrar">
</form>

<%
    boolean error;
    if (request.getAttribute("error2") != null) {
        error = (boolean) request.getAttribute("error2");

        if (error == false) {
%>
<script>
            alert("Juguete registrado con exito");
</script>
<%
        } else {
%>
<script>
            alert("Ya existe un juguete con ese ID");
</script>
<%
        }
    }
%>

</body>
</html>
