package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.MedicoDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarMedicoServlet")
public class EliminarMedicoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        MedicoDAO dao = new MedicoDAO();

        dao.eliminar(id);

        response.sendRedirect("ListarMedicosServlet");
    }
}