package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.CitaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarCitasServlet")
public class ListarCitasServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    CitaDAO citaDAO = new CitaDAO();

    request.setAttribute("citas", citaDAO.listar());

    request.getRequestDispatcher("listarCitas.jsp")
           .forward(request, response);
}

}
