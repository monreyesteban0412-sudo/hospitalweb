<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hospital.model.Paciente" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <title>Lista de Pacientes</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <link rel="stylesheet" href="css/style.css">
    
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

    <div class="d-flex justify-content-between align-items-center">

        <h3 class="mb-0">Gestión de Pacientes</h3>

        <a href="registroPaciente.jsp"
           class="btn btn-light btn-sm">

            Nuevo Paciente

        </a>

    </div>

</div>

        <div class="card-body">

            <table class="table table-striped table-hover">

                <thead class="table-dark">

                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Documento</th>
                    <th>Teléfono</th>
                    <th>Correo</th>
                    <th>Acciones</th>
                </tr>

                </thead>

                <tbody>

                <%
                    List<Paciente> lista =
                            (List<Paciente>) request.getAttribute("listaPacientes");

                    if (lista != null) {

                        for (Paciente p : lista) {
                %>

                <tr>

                    <td><%= p.getId() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getApellido() %></td>
                    <td><%= p.getDocumento() %></td>
                    <td><%= p.getTelefono() %></td>
                    <td><%= p.getCorreo() %></td>

                    <td class="text-center">

                        <div class="d-flex justify-content-center gap-2">
                            
                            <a href="EditarPacienteServlet?id=<%= p.getId() %>"
                                class="btn btn-warning btn-sm">
                                Editar
                            </a>
                            
                            <a href="EliminarPacienteServlet?id=<%= p.getId() %>"
                                class="btn btn-danger btn-sm"
                                onclick="return confirm('¿Está seguro de eliminar este paciente?');">
                                Eliminar
                            </a>
                        </div>
                    </td>

                </tr>

                <%
                        }
                    }
                %>

                </tbody>

            </table>

            <a href="index.jsp" class="btn btn-secondary">
                Volver al Inicio
            </a>

        </div>

    </div>

</div>

</body>
</html>