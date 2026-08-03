package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.MedicoDAO;
import com.hospital.model.Medico;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ActualizarMedicoServlet")
public class ActualizarMedicoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String especialidad = request.getParameter("especialidad");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        Medico medico = new Medico();

        medico.setId(id);
        medico.setNombre(nombre);
        medico.setApellido(apellido);
        medico.setEspecialidad(especialidad);
        medico.setTelefono(telefono);
        medico.setCorreo(correo);

        MedicoDAO dao = new MedicoDAO();

        boolean actualizado = dao.actualizar(medico);

        if (actualizado) {

            response.sendRedirect("ListarMedicosServlet");

        } else {

            response.sendRedirect("EditarMedicoServlet?id=" + id);
        }
    }
}