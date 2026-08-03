package com.hospital.util;

import com.hospital.dao.PacienteDAO;
import com.hospital.model.Paciente;

public class PruebaPacienteDAO {

    public static void main(String[] args) {

        Paciente paciente = new Paciente();

        paciente.setNombre("Juan");
        paciente.setApellido("Pérez");
        paciente.setDocumento("123456789");
        paciente.setTelefono("3001234567");
        paciente.setCorreo("juan@email.com");

        PacienteDAO dao = new PacienteDAO();

        if (dao.guardar(paciente)) {
            System.out.println("Paciente guardado correctamente.");
        } else {
            System.out.println("Error al guardar el paciente.");
        }
    }
}