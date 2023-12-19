<%@ page import="com.example.tarea3.model.JuguetesEntity" %>
<%@ page import="jakarta.persistence.TypedQuery" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="java.math.BigDecimal" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Venta de Juguete</title>
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
            color: #333;
        }

        label {
            text-align: left;
        }

        .cuadro {
            display: inline-block;
            border: 1px solid #ccc;
            background-color: rgb(255, 255, 255);
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 10px;
            width: 95%;
            text-align: left;
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
    <% int cantidad = Integer.parseInt(request.getParameter("cantidad")); %>
    <% int nuevaCantidad = (int) request.getAttribute("nuevaCantidad"); %>
    <% BigDecimal precioUnitario = (BigDecimal) request.getAttribute("precioUnitario"); %>

    <div class="titulo">
        <h1>Comprobante de Juguete Vendido</h1>
    </div>

    <label>ID del Juguete:</label>
    <br>
    <div class="cuadro">
        <label><%= idJuguete %>
        </label>
    </div>
    <br>

    <label>Cantidad vendida:</label>
    <br>
    <div class="cuadro">
        <label><%= cantidad %>
        </label>
    </div>

    <label>Cantidad Restante:</label>
    <div class="cuadro">
        <label><%= nuevaCantidad %></label>
    </div>
    <br>

    <label>Precio total de la venta:</label>
    <br>
    <div class="cuadro">
        <label><%= cantidad * precioUnitario.intValue() %></label>
    </div>
</div>
</body>
</html>