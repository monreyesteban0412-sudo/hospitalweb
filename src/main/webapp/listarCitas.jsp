<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hospital.model.Cita" %>

<!DOCTYPE html>

<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Lista de Citas</title>


<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">


</head>

<body>

<div class="container mt-5">


<h2 class="mb-4">Citas Médicas</h2>

<a href="RegistrarCitaServlet"
   class="btn btn-primary mb-3">
    Registrar nueva cita
</a>

<table class="table table-bordered table-striped">

    <thead class="table-dark">

        <tr>
            <th>ID</th>
            <th>Paciente</th>
            <th>Médico</th>
            <th>Especialidad</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>

    </thead>

    <tbody>

    <%
        List<Cita> citas =
            (List<Cita>) request.getAttribute("citas");

        if (citas != null && !citas.isEmpty()) {

            for (Cita cita : citas) {
    %>

        <tr>

            <td>
                <%= cita.getId() %>
            </td>

            <td>
                <%= cita.getPacienteNombre() %>
                <%= cita.getPacienteApellido() %>
            </td>
            
            <td>
                <%= cita.getMedicoNombre() %>
                <%= cita.getMedicoApellido() %>
            </td>
            
            <td>
                <%= cita.getEspecialidad() %>
            </td>

            <td>
                <%= cita.getFecha() %>
            </td>

            <td>
                <%= cita.getHora() %>
            </td>

            <td>
                <%= cita.getEstado() %>
            </td>

            <td>

                <a href="EditarCitaServlet?id=<%= cita.getId() %>"
                   class="btn btn-warning btn-sm">
                    Editar
                </a>

                <a href="EliminarCitaServlet?id=<%= cita.getId() %>"
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('¿Está seguro de eliminar esta cita?');">
                    Eliminar
                </a>

            </td>

        </tr>

    <%
            }

        } else {
    %>

        <tr>

            <td colspan="8"
                class="text-center">
                No hay citas registradas.
            </td>

        </tr>

    <%
        }
    %>

    </tbody>

</table>

<a href="index.jsp"
   class="btn btn-secondary">
    Volver al inicio
</a>


</div>

</body>

</html>
