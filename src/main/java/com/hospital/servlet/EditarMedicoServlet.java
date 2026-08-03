package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.MedicoDAO;
import com.hospital.model.Medico;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditarMedicoServlet")
public class EditarMedicoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        MedicoDAO dao = new MedicoDAO();

        Medico medico = dao.buscarPorId(id);

        request.setAttribute("medico", medico);

        request.getRequestDispatcher("editarMedico.jsp")
               .forward(request, response);
    }
}