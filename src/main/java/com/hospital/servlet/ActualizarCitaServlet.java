package com.hospital.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.hospital.dao.CitaDAO;
import com.hospital.model.Cita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ActualizarCitaServlet")
public class ActualizarCitaServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    int pacienteId = Integer.parseInt(request.getParameter("pacienteId"));
    int medicoId = Integer.parseInt(request.getParameter("medicoId"));

    LocalDate fecha =
            LocalDate.parse(request.getParameter("fecha"));

    LocalTime hora =
            LocalTime.parse(request.getParameter("hora"));

    String estado = request.getParameter("estado");

    Cita cita = new Cita();

    cita.setId(id);
    cita.setPacienteId(pacienteId);
    cita.setMedicoId(medicoId);
    cita.setFecha(fecha);
    cita.setHora(hora);
    cita.setEstado(estado);

    CitaDAO citaDAO = new CitaDAO();

    boolean actualizado = citaDAO.actualizar(cita);

    if (actualizado) {

        response.sendRedirect("ListarCitasServlet");

    } else {

        response.sendRedirect("EditarCitaServlet?id=" + id);
    }
}

}
