package com.hospital.servlet;

import java.io.IOException;
import java.util.List;

import com.hospital.dao.MedicoDAO;
import com.hospital.model.Medico;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarMedicosServlet")
public class ListarMedicosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        MedicoDAO dao = new MedicoDAO();

        List<Medico> medicos = dao.listar();

        request.setAttribute("medicos", medicos);

        request.getRequestDispatcher("listarMedicos.jsp")
               .forward(request, response);
    }
}