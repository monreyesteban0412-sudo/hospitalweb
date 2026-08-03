package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.PacienteDAO;
import com.hospital.model.Paciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PacienteServlet")
public class PacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String documento = request.getParameter("documento");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        Paciente paciente = new Paciente();

        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDocumento(documento);
        paciente.setTelefono(telefono);
        paciente.setCorreo(correo);

        PacienteDAO dao = new PacienteDAO();

        boolean resultado = dao.guardar(paciente);

    if (resultado) {

    response.sendRedirect("ListarPacientesServlet");
} else {

    response.getWriter().println("Error al registrar el paciente.");


}
    }
}