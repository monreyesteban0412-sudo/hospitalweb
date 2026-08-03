package com.hospital.servlet;

import com.hospital.dao.PacienteDAO;
import com.hospital.model.Paciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/EditarPacienteServlet")
public class EditarPacienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        PacienteDAO dao = new PacienteDAO();

        Paciente paciente = dao.buscarPorId(id);

        request.setAttribute("paciente", paciente);

        request.getRequestDispatcher("editarPaciente.jsp")
               .forward(request, response);

    }

}