package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.MedicoDAO;
import com.hospital.model.Medico;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MedicoServlet")
public class MedicoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MedicoDAO medicoDAO;

    @Override
    public void init() {

        medicoDAO = new MedicoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String especialidad = request.getParameter("especialidad");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        Medico medico = new Medico();

        medico.setNombre(nombre);
        medico.setApellido(apellido);
        medico.setEspecialidad(especialidad);
        medico.setTelefono(telefono);
        medico.setCorreo(correo);

        boolean guardado = medicoDAO.guardar(medico);

        if (guardado) {

            response.sendRedirect("ListarMedicosServlet");

        } else {

            response.sendRedirect("registroMedico.jsp?error=1");
        }
    }
}