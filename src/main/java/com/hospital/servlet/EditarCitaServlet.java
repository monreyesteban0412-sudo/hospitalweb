package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.CitaDAO;
import com.hospital.dao.MedicoDAO;
import com.hospital.dao.PacienteDAO;
import com.hospital.model.Cita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditarCitaServlet")
public class EditarCitaServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));

    CitaDAO citaDAO = new CitaDAO();

    Cita cita = citaDAO.buscarPorId(id);

    if (cita != null) {

        PacienteDAO pacienteDAO = new PacienteDAO();
        MedicoDAO medicoDAO = new MedicoDAO();

        request.setAttribute("cita", cita);

        request.setAttribute(
            "pacientes",
            pacienteDAO.listar()
        );

        request.setAttribute(
            "medicos",
            medicoDAO.listar()
        );

        request.getRequestDispatcher("editarCita.jsp")
               .forward(request, response);

    } else {

        response.sendRedirect("ListarCitasServlet");
    }
}

}
