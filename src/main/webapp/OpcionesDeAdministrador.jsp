<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenida</title>
    <script>
        function reporte() {
            window.location.href = 'ReporteJuguetes.jsp';
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

        function buscarJuguete() {
            window.location.href = 'BusquedaJuguete.jsp';
        }

        function borrarJuguete() {
            window.location.href = 'BorrarJuguete.jsp';
        }
    </script>
    <style>
        h2 {
            font-size: 50px;
            color: #060843;
            margin-top: 180px;
            text-align: center;
            padding: 0;
            margin: 0;
        }

        body {
            background-image: url('https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2023/10/24/surtido-juguetes-aldi.jpeg');
            background-size: cover;
            background-position: center;
            margin: 0;
            text-align: center;
        }

        button {
            height: 200px;
            width: 200px;
            background-color: #76C5F5;
            border: 5px solid #13567F;
            margin: 30px;
        }

        img {
            height: 80px;
            width: 80px;
        }

        .botones {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around
        }

        .botones2 {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around
        }

        .contenedor {
            background-color: rgba(255, 253, 253, 0.57);
            border-radius: 15px;
            width: 1300px;
            margin: 90px 0 0 50px;
            padding: 25px 0 25px 0;
        }
    </style>
</head>

<body>
<div class="contenedor">
    <h2>Bienvenido estimado usuario</h2>
    <div class="botones">
        <button onclick="registrar()"><img
                src="https://cdn-icons-png.flaticon.com/512/3200/3200751.png"
                alt="Ícono"/><br>REGISTRAR JUGUETE
        </button>

        <button onclick="vender()"><img
                src="https://cdn-icons-png.flaticon.com/512/1992/1992622.png"
                alt="Ícono"/><br>VENDER
            JUGUETE
        </button>

        <form action="/stock" method="POST">
            <button onclick="reporte()"><img
                    src="https://cdn-icons-png.flaticon.com/512/2615/2615119.png"
                    alt="Ícono"/><br>VER
                INFORME DE STOCK
            </button>
        </form>
    </div>

    <div class="botones2">
        <button onclick="registrarAdmin()"><img
                src="https://cdn-icons-png.flaticon.com/512/3534/3534139.png"
                alt="Ícono"/><br>REGISTRAR NUEVO ADMIN
        </button>

        <button onclick="buscarJuguete()"><img
                src="https://cdn-icons-png.flaticon.com/512/639/639375.png"
                alt="Ícono"/><br>BUSCAR INF. JUGUETE
        </button>

        <button onclick="borrarJuguete()"><img
                src="https://cdn.icon-icons.com/icons2/1880/PNG/512/iconfinder-trash-4341321_120557.png"
                alt="Ícono"/><br>BORRAR JUGUETE DE LA BDD
        </button>
    </div>

    <%
        boolean jugueteBorrado;
        if (request.getAttribute("jugueteBorrado") != null) {
            jugueteBorrado = (boolean) request.getAttribute("jugueteBorrado");

            if (jugueteBorrado) {
    %>
    <script> alert("El juguete ha sido borrado"); </script>
    <%
            }
        }
    %>

</div>
</body>
</html>