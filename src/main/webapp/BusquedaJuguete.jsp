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
            background-image: url('https://img.freepik.com/vector-gratis/fondo-juguetes-navidad-dibujados-mano_23-2148758008.jpg?w=1800&t=st=1703735844~exp=1703736444~hmac=cab7fd2bc356246ba565917cb8798019d30b3e8f71af5883bbd6340e139860c4');
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

        th:nth-child(1), td:nth-child(1) {
            width: 33%;
        }

        th:nth-child(2), td:nth-child(2) {
            width: 33%;
        }

        th:nth-child(3), td:nth-child(3) {
            width: 34%;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        h2 {
            font-size: 30px;
            color: #060843;
            text-align: center;
        }

        .buscador {
            margin: 35px 0 0 145px;
        }

        input {
            border-radius: 15px 0 0 15px;
            width: 250px;
            padding: 8px;
            height: 45px;
        }

        input[type="submit"] {
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

<body>
<div class="buscador">
    <h3>Ingrese el ID del juguete a buscar: </h3>
    <form action="/jugueteID" method="POST">
        <input type="text" id="IDJuguete" name="IDJuguete" required>
        <input type="submit">
    </form>
</div>

<h2>Informacion sobre el juguete</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Precio</th>
        <th>Cantidad</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<JuguetesEntity> juguetesList = (List<JuguetesEntity>) request.getAttribute("jugueteBuscado");
        if (juguetesList != null && !juguetesList.isEmpty()) {
            for (JuguetesEntity juguete : juguetesList) {
    %>
    <tr>
        <td><%= juguete.getId() %>
        </td>
        <td><%= juguete.getPrecio() %>
        </td>
        <td><%= juguete.getCantidad() %>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">Registro no identificado</td>
    </tr>
    <%
        }
    %>
    </tbody>

</table>
</body>