<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hospital.model.Paciente" %>

<%
    Paciente paciente = (Paciente) request.getAttribute("paciente");
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <title>Editar Paciente</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <link rel="stylesheet" href="css/style.css">

</head>

<body class="bg-light">

<div class="container mt-5">
    
    <div class="card shadow">

        <div class="card-header bg-primary text-white">
            <h3 class="mb-0">
                Gestión de Pacientes
            </h3>
        </div>

        <div class="card-body">
            
            <p class="text-muted mb-4">
                
                Modifique la información del paciente y presione <strong>Actualizar</strong> para guardar los cambios.
            
            </p>

            <form action="ActualizarPacienteServlet" method="post">

                <input type="hidden" name="id" value="<%= paciente.getId() %>">

                <div class="mb-3">
                    <label class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control"
                           value="<%= paciente.getNombre() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Apellido</label>
                    <input type="text" name="apellido" class="form-control"
                           value="<%= paciente.getApellido() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Documento</label>
                    <input type="text" name="documento" class="form-control"
                           value="<%= paciente.getDocumento() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Teléfono</label>
                    <input type="text" name="telefono" class="form-control"
                           value="<%= paciente.getTelefono() %>">
                </div>

                <div class="mb-3">
                    <label class="form-label">Correo</label>
                    <input type="email" name="correo" class="form-control"
                           value="<%= paciente.getCorreo() %>">
                </div>

            
        <div class="d-flex justify-content-end gap-2 mt-4">
                    
        <a href="ListarPacientesServlet"
                    class="btn btn-secondary">
                    Cancelar
        </a>
                
            <button type="submit"
                class="btn btn-success">
                Actualizar Paciente
            </button>
        </div>

            </form>

        </div>

    </div>

</div>

</body>
</html>