package com.hospital.servlet;

import com.hospital.dao.PacienteDAO;
import com.hospital.model.Paciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ActualizarPacienteServlet")
public class ActualizarPacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Paciente paciente = new Paciente();

        paciente.setId(Integer.parseInt(request.getParameter("id")));
        paciente.setNombre(request.getParameter("nombre"));
        paciente.setApellido(request.getParameter("apellido"));
        paciente.setDocumento(request.getParameter("documento"));
        paciente.setTelefono(request.getParameter("telefono"));
        paciente.setCorreo(request.getParameter("correo"));

        PacienteDAO dao = new PacienteDAO();

        dao.actualizar(paciente);

        response.sendRedirect("ListarPacientesServlet");

    }

}
