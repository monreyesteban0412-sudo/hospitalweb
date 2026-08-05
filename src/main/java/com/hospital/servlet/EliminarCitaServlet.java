package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.CitaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarCitaServlet")
public class EliminarCitaServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));

    CitaDAO citaDAO = new CitaDAO();

    boolean eliminado = citaDAO.eliminar(id);

    if (eliminado) {

        response.sendRedirect("ListarCitasServlet");

    } else {

        response.sendRedirect("ListarCitasServlet");
    }
}

}
