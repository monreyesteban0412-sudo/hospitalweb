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

@WebServlet("/CitaServlet")
public class CitaServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException {

    int pacienteId = Integer.parseInt(request.getParameter("pacienteId"));
    int medicoId = Integer.parseInt(request.getParameter("medicoId"));

    LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
    LocalTime hora = LocalTime.parse(request.getParameter("hora"));

    String estado = request.getParameter("estado");

    Cita cita = new Cita();

    cita.setPacienteId(pacienteId);
    cita.setMedicoId(medicoId);
    cita.setFecha(fecha);
    cita.setHora(hora);
    cita.setEstado(estado);

    CitaDAO dao = new CitaDAO();

    boolean guardado = dao.guardar(cita);

    if (guardado) {
        response.sendRedirect("ListarCitasServlet");
    } else {
        response.sendRedirect("registroCita.jsp?error=1");
    }
}

}
