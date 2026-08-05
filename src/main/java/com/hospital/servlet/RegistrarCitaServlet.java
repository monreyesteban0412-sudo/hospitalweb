package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.MedicoDAO;
import com.hospital.dao.PacienteDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrarCitaServlet")
public class RegistrarCitaServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    PacienteDAO pacienteDAO = new PacienteDAO();
    MedicoDAO medicoDAO = new MedicoDAO();

    request.setAttribute("pacientes", pacienteDAO.listar());
    request.setAttribute("medicos", medicoDAO.listar());

    request.getRequestDispatcher("registroCita.jsp")
           .forward(request, response);
}

}
