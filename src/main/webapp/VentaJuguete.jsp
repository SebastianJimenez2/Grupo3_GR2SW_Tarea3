<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Venta de juguete</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-image: url('https://elsumario.com/wp-content/uploads/2017/09/cuarto-de-juegos-grande-1.jpg');
            background-size: cover;
            background-position: center;
            color: #000;
            font-family: 'Arial', sans-serif;
        }

        #seccionJuguetes {
            background-color: rgba(255, 255, 255, 0.7);
            padding: 55px 55px;
            border-radius: 10px;
        }

        #seccionJuguetes h2 {
            font-size: 15px;
        }

        input[type="submit"] {
            background-color: #3673f8;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #263a6c;
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

    </style>
</head>

<body>
<form action="/vender-juguete" method="post">
    <div id="seccionJuguetes">
        <h1>Venta de Juguete</h1>
        <h2>ID del Juguete</h2>
        <input class="inputClass" type="text" id="IDJuguete" name="IDJuguete" pattern="[0-9]+" required>
        <h2>Cantidad vendida</h2>
        <input class="inputClass" type="text" id="cantidad" name="cantidad" pattern="[0-9]+" required>

        <input id="botonVender" type="submit" value="Vender">
    </div>
</form>

<%
    boolean error_cantidaInsuficiente;
    if (request.getAttribute("errorCantidadInsuficiente") != null) {
        error_cantidaInsuficiente = (boolean) request.getAttribute("errorCantidadInsuficiente");

        if (error_cantidaInsuficiente) {
%>
<script>
    alert("Cantidad insuficiente para dicho juguete");
</script>
<%
        }
    }
%>

<%
    boolean error_jugueteNoExiste;
    if (request.getAttribute("errorJugueteNoExiste") != null) {
        error_jugueteNoExiste = (boolean) request.getAttribute("errorJugueteNoExiste");

        if (error_jugueteNoExiste) {
%>
<script>
    alert("El juguete que deseas vender no existe");
</script>
<%
        }
    }
%>
</body>
</html>