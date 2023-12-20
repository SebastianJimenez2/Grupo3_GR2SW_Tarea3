<%@ page import="com.example.tarea3.model.JuguetesEntity" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reporte de juguetes</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-image: url('https://s1.1zoom.me/big0/88/Toys_Trains_Colored_background_607681_1280x853.jpg');
            background-size: cover;
            background-position: center;
            padding: 10px 0;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto; /* Añadido para centrar la tabla */
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        }

        th, td {
            padding: 15px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #060843;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        h2 {
            font-size: 30px;
            color: #060843;
            text-align: center;
        }
    </style>

<body>
<h2>Lista de disponibilidad de productos</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Cantidad</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<JuguetesEntity> juguetesList = (List<JuguetesEntity>) request.getAttribute("juguetesList");
        for (JuguetesEntity juguete : juguetesList) {
    %>
    <tr>
        <td><%= juguete.getId() %></td>
        <td><%= juguete.getCantidad() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
