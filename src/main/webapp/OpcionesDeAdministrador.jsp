<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenida</title>
    <script>
        function reporte() {
            window.location.href = 'reporteJuguetes.jsp';
        }
        function registrar() {
            window.location.href = 'GestionJuguete.jsp';
        }
        function vender() {
            window.location.href = 'VentaJuguete.jsp';
        }
        function registrarAdmin() {
            window.location.href = 'Registrarse.jsp';
        }
    </script>
    <style>
        h2{
            font-size: 50px;
            color: #060843;
            margin-top: 20px;
            text-align:center;
        }

        body {
            background-image: url('https://previews.123rf.com/images/vejaa/vejaa1709/vejaa170900008/85331359-fondo-de-juguetes-para-ni%C3%B1os-con-oso-de-peluche-y-bloques-de-colores.jpg');
            background-size: cover;
            background-position: center;
            margin: 0;
            text-align:center;
        }

        button{
            height: 150px;
            weight: 100px;
            background-color: #76C5F5;
            border: 5px solid #13567F;
            margin: 30px;
        }

        img{
            height: 80px;
            weight: 80px;
        }
    </style>
</head>

<body>
<h2>Bienvenido estimado usuario</h2>
<div>
    <button onclick="registrar()"><img src="https://cdn-icons-png.flaticon.com/512/3200/3200751.png" alt="Ícono" /><br>REGISTRAR JUGUETE</button><br>
    <button onclick="vender()"><img src="https://cdn-icons-png.flaticon.com/512/1992/1992622.png" alt="Ícono" /><br>VENDER JUGUETE</button><br>
    <button onclick="reporte()"><img src="https://cdn-icons-png.flaticon.com/512/2615/2615119.png" alt="Ícono" /><br>VER INFORME DE STOCK</button><br>
    <button onclick="registrarAdmin()"><img src="https://cdn-icons-png.flaticon.com/512/2615/2615119.png" alt="Ícono" /><br>REGISTRAR NUEVO ADMIN</button><br>
</div>
</body>
</html>