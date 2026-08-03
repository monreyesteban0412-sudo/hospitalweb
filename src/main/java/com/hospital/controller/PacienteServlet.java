package com.hospital.controller;

import java.io.IOException;

import com.hospital.dao.PacienteDAO;
import com.hospital.model.Paciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/paciente")
public class PacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Paciente paciente = new Paciente();

        paciente.setNombre(request.getParameter("nombre"));
        paciente.setApellido(request.getParameter("apellido"));
        paciente.setDocumento(request.getParameter("documento"));
        paciente.setTelefono(request.getParameter("telefono"));
        paciente.setCorreo(request.getParameter("correo"));

        PacienteDAO dao = new PacienteDAO();

        if (dao.guardar(paciente)) {
            response.getWriter().println("Paciente registrado correctamente.");
        } else {
            response.getWriter().println("Error al registrar el paciente.");
        }
    }
}
