<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-image: url('https://static.vecteezy.com/system/resources/previews/023/433/238/non_2x/3d-illustration-of-cloud-server-connected-with-database-and-laptop-between-glowing-rays-on-purple-digital-circuit-background-vector.jpg'); /* Reemplaza 'tu-imagen-de-fondo.jpg' con la ruta correcta de tu imagen */
            background-size: cover;
            display: flex;
            margin: 0;
        }

        h2{
            margin: 0 0 15px 0;
        }

        form {
            width: 400px;
            margin: 330px 0 0 900px;
            border-radius: 15px;
            padding: 20px 20px;
            background-color: rgba(255, 255, 255, 0.61);
        }

        input {
            border-radius: 15px 0 0 15px;
            width: 250px;
            padding: 8px;
            height: 20px;
        }

        input[type="submit"] {
            height: 40px;
            border-radius: 0 15px 15px 0;
            width: 75px;
            background-color: #060843;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0a1080;
        }
    </style>
</head>
<body>
<form action="/borrarJuguete" method="POST">
    <h2>Ingrese el juguete que desea borrar de la Base de Datos: </h2>
    <input type="text" name="IDBorrar" id="IDBorrar" required>
    <input type="submit">
</form>

<%
    boolean jugueteBorrado;
    if (request.getAttribute("jugueteBorrado") != null) {
        jugueteBorrado = (boolean) request.getAttribute("jugueteBorrado");

        if (!jugueteBorrado) {
%>
<script> alert("El juguete no existe"); </script>
<%
        }
    }
%>
</body>
</html>