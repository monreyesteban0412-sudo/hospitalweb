<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hospital.model.Cita" %>
<%@ page import="com.hospital.model.Paciente" %>
<%@ page import="com.hospital.model.Medico" %>

<!DOCTYPE html>

<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Editar Cita</title>

```
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
```

</head>

<body>

<div class="container mt-5">


<h2 class="mb-4">Editar Cita Médica</h2>

<%
    Cita cita = (Cita) request.getAttribute("cita");

    List<Paciente> pacientes =
        (List<Paciente>) request.getAttribute("pacientes");

    List<Medico> medicos =
        (List<Medico>) request.getAttribute("medicos");
%>

<form action="ActualizarCitaServlet" method="post">

    <input type="hidden"
           name="id"
           value="<%= cita.getId() %>">


    <div class="mb-3">

        <label for="pacienteId" class="form-label">
            Paciente
        </label>

        <select name="pacienteId"
                id="pacienteId"
                class="form-select"
                required>

            <%
                if (pacientes != null) {

                    for (Paciente paciente : pacientes) {

                        String seleccionado =
                            paciente.getId() == cita.getPacienteId()
                            ? "selected"
                            : "";
            %>

                <option value="<%= paciente.getId() %>"
                        <%= seleccionado %>>

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

            <%
                if (medicos != null) {

                    for (Medico medico : medicos) {

                        String seleccionado =
                            medico.getId() == cita.getMedicoId()
                            ? "selected"
                            : "";
            %>

                <option value="<%= medico.getId() %>"
                        <%= seleccionado %>>

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
               value="<%= cita.getFecha() %>"
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
               value="<%= cita.getHora() %>"
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

            <option value="Programada"
                <%= "Programada".equals(cita.getEstado())
                    ? "selected"
                    : "" %>>
                Programada
            </option>

            <option value="Atendida"
                <%= "Atendida".equals(cita.getEstado())
                    ? "selected"
                    : "" %>>
                Atendida
            </option>

            <option value="Cancelada"
                <%= "Cancelada".equals(cita.getEstado())
                    ? "selected"
                    : "" %>>
                Cancelada
            </option>

        </select>

    </div>


    <button type="submit"
            class="btn btn-success">
        Guardar cambios
    </button>

    <a href="ListarCitasServlet"
       class="btn btn-secondary">
        Cancelar
    </a>

</form>

</div>

</body>

</html>
