<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hospital.model.Paciente" %>
<%@ page import="com.hospital.model.Medico" %>

<!DOCTYPE html>

<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Registrar Cita</title>


<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">


</head>

<body>

<div class="container mt-5">


<h2 class="mb-4">Registrar Cita Médica</h2>

<form action="CitaServlet" method="post">

    <div class="mb-3">
        <label for="pacienteId" class="form-label">
            Paciente
        </label>

        <select name="pacienteId"
                id="pacienteId"
                class="form-select"
                required>

            <option value="">Seleccione un paciente</option>

            <%
                List<Paciente> pacientes =
                    (List<Paciente>) request.getAttribute("pacientes");

                if (pacientes != null) {
                    for (Paciente paciente : pacientes) {
            %>

                <option value="<%= paciente.getId() %>">
                    <%= paciente.getNombre() %>
                    <%= paciente.getApellido() %>
                    - Documento: <%= paciente.getDocumento() %>
                </option>

            <%
                    }
                }
            %>

        </select>
    </div>


    <div class="mb-3">

        <label for="medicoId" class="form-label">
            Médico
        </label>

        <select name="medicoId"
                id="medicoId"
                class="form-select"
                required>

            <option value="">Seleccione un médico</option>

            <%
                List<Medico> medicos =
                    (List<Medico>) request.getAttribute("medicos");

                if (medicos != null) {
                    for (Medico medico : medicos) {
            %>

                <option value="<%= medico.getId() %>">
                    Dr. <%= medico.getNombre() %>
                    <%= medico.getApellido() %>
                    - <%= medico.getEspecialidad() %>
                </option>

            <%
                    }
                }
            %>

        </select>

    </div>


    <div class="mb-3">

        <label for="fecha" class="form-label">
            Fecha
        </label>

        <input type="date"
               name="fecha"
               id="fecha"
               class="form-control"
               required>

    </div>


    <div class="mb-3">

        <label for="hora" class="form-label">
            Hora
        </label>

        <input type="time"
               name="hora"
               id="hora"
               class="form-control"
               required>

    </div>


    <div class="mb-3">

        <label for="estado" class="form-label">
            Estado
        </label>

        <select name="estado"
                id="estado"
                class="form-select"
                required>

            <option value="Programada">Programada</option>
            <option value="Atendida">Atendida</option>
            <option value="Cancelada">Cancelada</option>

        </select>

    </div>


    <button type="submit"
            class="btn btn-primary">
        Registrar Cita
    </button>

    <a href="index.jsp"
       class="btn btn-secondary">
        Cancelar
    </a>

</form>


</div>

</body>
</html>

