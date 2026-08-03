
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Sistema Hospitalario</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <link rel="stylesheet" href="css/style.css">
    
</head>

<body>

<nav class="navbar navbar-dark bg-primary shadow">

    <div class="container">

        <span class="navbar-brand mb-0 h1">
            Sistema Hospitalario
        </span>

    </div>

</nav>

<div class="container mt-5">

    <div class="text-center mb-5">

        <h1>Panel Principal</h1>

        <p class="text-muted">
            Gestión integral del sistema hospitalario
        </p>

    </div>

    <div class="row justify-content-center">

        <div class="col-md-8">

            <div class="card mb-4">

                <div class="card-body">

                    <h3>Gestión dePacientes</h3>

                    <p class="text-muted">

                        Administre la información de los pacientes registrados en el sistema.

                    </p>

                    <a href="ListarPacientesServlet"
                       class="btn btn-primary">

                        Administrar pacientes

                    </a>

                </div>

            </div>

            <div class="card mb-4">

                <div class="card-body">

                    <h3>Médicos</h3>

                    <div class="card mb-4">

    <div class="card-body">

        <h3>Médicos</h3>

        <p class="text-muted">

            Administración del personal médico.

        </p>

        <a href="ListarMedicosServlet"
           class="btn btn-primary">

            Administrar médicos

        </a>

    </div>

</div>

            <div class="card mb-4">

                <div class="card-body">

                    <h3>Citas</h3>

                    <p class="text-muted">

                        Gestión de citas médicas.

                    </p>

                    <button class="btn btn-secondary" disabled>

                        Próximamente

                    </button>

                </div>

            </div>

        </div>

    </div>

</div>

<footer>

    Sistema Hospitalario | ADSO - SENA | Versión 1.0

</footer>

</body>