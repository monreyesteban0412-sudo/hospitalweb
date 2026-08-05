package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.config.Conexion;
import com.hospital.model.Cita;

public class CitaDAO {

public boolean guardar(Cita cita) {

    String sql = "INSERT INTO citas(paciente_id, medico_id, fecha, hora, estado) VALUES (?, ?, ?, ?, ?)";

    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, cita.getPacienteId());
        ps.setInt(2, cita.getMedicoId());
        ps.setObject(3, cita.getFecha());
        ps.setObject(4, cita.getHora());
        ps.setString(5, cita.getEstado());

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println("Error al guardar cita: " + e.getMessage());
        return false;

    }
}

public List<Cita> listar() {

List<Cita> citas = new ArrayList<>();

String sql = """
    SELECT c.id,
           c.paciente_id,
           c.medico_id,
           c.fecha,
           c.hora,
           c.estado,
           p.nombre AS paciente_nombre,
           p.apellido AS paciente_apellido,
           m.nombre AS medico_nombre,
           m.apellido AS medico_apellido,
           m.especialidad
    FROM citas c
    INNER JOIN pacientes p ON c.paciente_id = p.id
    INNER JOIN medicos m ON c.medico_id = m.id
    ORDER BY c.fecha, c.hora
    """;

try (
    Connection con = Conexion.conectar();
    PreparedStatement ps = con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery()
) {

    while (rs.next()) {

        Cita cita = new Cita();

        cita.setId(rs.getInt("id"));
        cita.setPacienteId(rs.getInt("paciente_id"));
        cita.setMedicoId(rs.getInt("medico_id"));
        cita.setFecha(rs.getDate("fecha").toLocalDate());
        cita.setHora(rs.getTime("hora").toLocalTime());
        cita.setEstado(rs.getString("estado"));

        cita.setPacienteNombre(rs.getString("paciente_nombre"));
        cita.setPacienteApellido(rs.getString("paciente_apellido"));
        cita.setMedicoNombre(rs.getString("medico_nombre"));
        cita.setMedicoApellido(rs.getString("medico_apellido"));
        cita.setEspecialidad(rs.getString("especialidad"));

        citas.add(cita);
    }

} catch (SQLException e) {

    System.out.println("Error al listar citas: " + e.getMessage());

}

return citas;

}



public Cita buscarPorId(int id) {

    String sql = "SELECT * FROM citas WHERE id = ?";

    Cita cita = null;

    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            cita = new Cita();

            cita.setId(rs.getInt("id"));
            cita.setPacienteId(rs.getInt("paciente_id"));
            cita.setMedicoId(rs.getInt("medico_id"));
            cita.setFecha(rs.getDate("fecha").toLocalDate());
            cita.setHora(rs.getTime("hora").toLocalTime());
            cita.setEstado(rs.getString("estado"));
        }

    } catch (SQLException e) {

        System.out.println("Error al buscar cita: " + e.getMessage());

    }

    return cita;
}

public boolean actualizar(Cita cita) {

    String sql = "UPDATE citas SET paciente_id=?, medico_id=?, fecha=?, hora=?, estado=? WHERE id=?";

    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, cita.getPacienteId());
        ps.setInt(2, cita.getMedicoId());
        ps.setObject(3, cita.getFecha());
        ps.setObject(4, cita.getHora());
        ps.setString(5, cita.getEstado());
        ps.setInt(6, cita.getId());

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println("Error al actualizar cita: " + e.getMessage());
        return false;

    }
}

public boolean eliminar(int id) {

    String sql = "DELETE FROM citas WHERE id = ?";

    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, id);

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println("Error al eliminar cita: " + e.getMessage());
        return false;

    }
}

}
