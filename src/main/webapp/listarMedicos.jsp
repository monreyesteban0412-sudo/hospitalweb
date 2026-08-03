<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hospital.model.Medico" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>Lista de Médicos</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">

</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary shadow">

    <div class="container">

        <span class="navbar-brand mb-0 h1">
            Sistema Hospitalario
        </span>

    </div>

</nav>

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <div>

            <h1>Gestión de Médicos</h1>

            <p class="text-muted mb-0">
                Consulta y administración del personal médico.
            </p>

        </div>

        <a href="registroMedico.jsp"
           class="btn btn-primary">

            Registrar Médico

        </a>

    </div>


    <div class="card shadow-sm">

        <div class="card-body">

            <div class="table-responsive">

                <table class="table table-hover align-middle">

                    <thead class="table-dark">

                        <tr>

                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Especialidad</th>
                            <th>Teléfono</th>
                            <th>Correo</th>
                            <th>Acciones</th>

                        </tr>

                    </thead>

                    <tbody>

                    <%

                        List<Medico> medicos =
                            (List<Medico>) request.getAttribute("medicos");

                        if (medicos != null && !medicos.isEmpty()) {

                            for (Medico medico : medicos) {

                    %>

                        <tr>

                            <td><%= medico.getId() %></td>

                            <td><%= medico.getNombre() %></td>

                            <td><%= medico.getApellido() %></td>

                            <td><%= medico.getEspecialidad() %></td>

                            <td><%= medico.getTelefono() %></td>

                            <td><%= medico.getCorreo() %></td>

                            <td>

                                <a href="EditarMedicoServlet?id=<%= medico.getId() %>"
                                   class="btn btn-warning btn-sm">

                                    Editar

                                </a>

                                <a href="EliminarMedicoServlet?id=<%= medico.getId() %>"
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('¿Está seguro de eliminar este médico?');">

                                    Eliminar

                                </a>

                            </td>

                        </tr>

                    <%

                            }

                        } else {

                    %>

                        <tr>

                            <td colspan="7"
                                class="text-center text-muted py-4">

                                No hay médicos registrados.

                            </td>

                        </tr>

                    <%

                        }

                    %>

                    </tbody>

                </table>

            </div>

            <a href="index.jsp"
               class="btn btn-secondary">

                Volver al inicio

            </a>

        </div>

    </div>

</div>

</body>

</html>