package com.hospital.servlet;

import java.io.IOException;
import java.util.List;

import com.hospital.dao.PacienteDAO;
import com.hospital.model.Paciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarPacientesServlet")
public class ListarPacientesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        PacienteDAO dao = new PacienteDAO();

        List<Paciente> lista = dao.listar();

        request.setAttribute("listaPacientes", lista);

        request.getRequestDispatcher("listarPacientes.jsp")
               .forward(request, response);

    }

}