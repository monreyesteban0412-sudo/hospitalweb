package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.config.Conexion;
import com.hospital.model.Paciente;


public class PacienteDAO {

    public boolean guardar(Paciente paciente) {

        String sql = "INSERT INTO pacientes(nombre, apellido, documento, telefono, correo) VALUES (?, ?, ?, ?, ?)";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getDocumento());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getCorreo());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al guardar paciente: " + e.getMessage());
            return false;

        }

    }

    public List<Paciente> listar() {

    List<Paciente> pacientes = new ArrayList<>();

    String sql = "SELECT * FROM pacientes";

    try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
    ) {

        while (rs.next()) {

            Paciente paciente = new Paciente();

            paciente.setId(rs.getInt("id"));
            paciente.setNombre(rs.getString("nombre"));
            paciente.setApellido(rs.getString("apellido"));
            paciente.setDocumento(rs.getString("documento"));
            paciente.setTelefono(rs.getString("telefono"));
            paciente.setCorreo(rs.getString("correo"));

            pacientes.add(paciente);

        }

    } catch (SQLException e) {

        System.out.println("Error al listar pacientes: " + e.getMessage());

    }

    return pacientes;
}

public boolean eliminar(int id) {

    String sql = "DELETE FROM pacientes WHERE id = ?";

    try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, id);

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println("Error al eliminar paciente: " + e.getMessage());

        return false;

    }

}

public Paciente buscarPorId(int id) {

    String sql = "SELECT * FROM pacientes WHERE id = ?";

    Paciente paciente = null;

    try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            paciente = new Paciente();

            paciente.setId(rs.getInt("id"));
            paciente.setNombre(rs.getString("nombre"));
            paciente.setApellido(rs.getString("apellido"));
            paciente.setDocumento(rs.getString("documento"));
            paciente.setTelefono(rs.getString("telefono"));
            paciente.setCorreo(rs.getString("correo"));

        }

    } catch (SQLException e) {

        System.out.println("Error al buscar paciente: " + e.getMessage());

    }

    return paciente;

}

public boolean actualizar(Paciente paciente) {

    String sql = "UPDATE pacientes SET nombre=?, apellido=?, documento=?, telefono=?, correo=? WHERE id=?";

    try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setString(1, paciente.getNombre());
        ps.setString(2, paciente.getApellido());
        ps.setString(3, paciente.getDocumento());
        ps.setString(4, paciente.getTelefono());
        ps.setString(5, paciente.getCorreo());
        ps.setInt(6, paciente.getId());

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println("Error al actualizar paciente: " + e.getMessage());

        return false;

    }

}

}
