<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Juguete</title>
    <style>
        body {
            background-image: url('https://png.pngtree.com/background/20230626/original/pngtree-toys-galore-in-a-3d-rendered-kid-s-play-room-picture-image_4057482.jpg');
            background-size: cover;
            background-position: center;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        #contenedor {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            width: 300px;
        }

        h1 {
            color: #333; /* Color del texto */
        }

        label {
            text-align: left;
        }

        .cuadro {
            display: inline-block;
            border: 1px solid #ccc; /* Color del borde */
            background-color: rgb(255, 255, 255);
            padding: 10px; /* Espaciado interno */
            border-radius: 5px;
            margin-bottom: 10px; /* Espaciado inferior */
            width: 95%; /* Ajusta según sea necesario */
            text-align: left; /* Alinear el texto a la izquierda */
            margin-left: auto;
            margin-right: auto;
        }

        .titulo {
            background-color: rgba(255, 255, 255, 0);
            text-align: center;
        }
    </style>
</head>

<body>
<div id="contenedor">
    <% String idJuguete = request.getParameter("IDJuguete"); %>
    <% String precioJuguete = request.getParameter("PrecioJuguete"); %>
    <% String cantidad = request.getParameter("Cantidad"); %>

    <div class="titulo">
        <h1>Comprobante de Juguete Registrado</h1>
    </div>

    <label>ID del Juguete:</label>
    <br>
    <div class="cuadro">
        <label><%= idJuguete %>
        </label>
    </div>
    <br>

    <label>Precio:</label>
    <br>
    <div class="cuadro">
        <label><%= precioJuguete %>
        </label>
    </div>
    <br>

    <label>Cantidad:</label>
    <br>
    <div class="cuadro">
        <label><%= cantidad %>
        </label>
    </div>
</div>
</body>
</html>