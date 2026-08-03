package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.PacienteDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarPacienteServlet")
public class EliminarPacienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        PacienteDAO dao = new PacienteDAO();

        dao.eliminar(id);

        response.sendRedirect("ListarPacientesServlet");

    }

}