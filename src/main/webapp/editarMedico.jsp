<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hospital.model.Medico" %>

<%
    Medico medico = (Medico) request.getAttribute("medico");
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>Editar Médico</title>

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

    <div class="row justify-content-center">

        <div class="col-md-8">

            <div class="card shadow-sm">

                <div class="card-body">

                    <h2 class="mb-4">
                        Editar Médico
                    </h2>

                    <form action="ActualizarMedicoServlet" method="post">

                        <input type="hidden"
                               name="id"
                               value="<%= medico.getId() %>">

                        <div class="mb-3">

                            <label class="form-label">
                                Nombre
                            </label>

                            <input type="text"
                                   name="nombre"
                                   class="form-control"
                                   value="<%= medico.getNombre() %>"
                                   required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Apellido
                            </label>

                            <input type="text"
                                   name="apellido"
                                   class="form-control"
                                   value="<%= medico.getApellido() %>"
                                   required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Especialidad
                            </label>

                            <input type="text"
                                   name="especialidad"
                                   class="form-control"
                                   value="<%= medico.getEspecialidad() %>"
                                   required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Teléfono
                            </label>

                            <input type="text"
                                   name="telefono"
                                   class="form-control"
                                   value="<%= medico.getTelefono() %>">

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Correo
                            </label>

                            <input type="email"
                                   name="correo"
                                   class="form-control"
                                   value="<%= medico.getCorreo() %>">

                        </div>

                        <button type="submit"
                                class="btn btn-success">

                            Guardar cambios

                        </button>

                        <a href="ListarMedicosServlet"
                           class="btn btn-secondary">

                            Cancelar

                        </a>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

</body>

</html>