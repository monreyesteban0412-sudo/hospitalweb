package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.config.Conexion;
import com.hospital.model.Medico;

public class MedicoDAO {

    public boolean guardar(Medico medico) {

        String sql = "INSERT INTO medicos(nombre, apellido, especialidad, telefono, correo) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getEspecialidad());
            ps.setString(4, medico.getTelefono());
            ps.setString(5, medico.getCorreo());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al guardar médico: " + e.getMessage());
            return false;
        }
    }

    public List<Medico> listar() {

        List<Medico> medicos = new ArrayList<>();

        String sql = "SELECT * FROM medicos";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Medico medico = new Medico();

                medico.setId(rs.getInt("id"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medico.setTelefono(rs.getString("telefono"));
                medico.setCorreo(rs.getString("correo"));

                medicos.add(medico);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar médicos: " + e.getMessage());
        }

        return medicos;
    }

    public Medico buscarPorId(int id) {

        String sql = "SELECT * FROM medicos WHERE id = ?";

        Medico medico = null;

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                medico = new Medico();

                medico.setId(rs.getInt("id"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medico.setTelefono(rs.getString("telefono"));
                medico.setCorreo(rs.getString("correo"));
            }

        } catch (SQLException e) {

            System.out.println("Error al buscar médico: " + e.getMessage());
        }

        return medico;
    }

    public boolean actualizar(Medico medico) {

        String sql = "UPDATE medicos SET nombre=?, apellido=?, especialidad=?, "
                   + "telefono=?, correo=? WHERE id=?";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getEspecialidad());
            ps.setString(4, medico.getTelefono());
            ps.setString(5, medico.getCorreo());
            ps.setInt(6, medico.getId());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al actualizar médico: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM medicos WHERE id = ?";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al eliminar médico: " + e.getMessage());
            return false;
        }
    }
}