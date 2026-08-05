package com.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {


private int id;
private int pacienteId;
private int medicoId;
private LocalDate fecha;
private LocalTime hora;
private String estado;
private String pacienteNombre;
private String pacienteApellido;
private String medicoNombre;
private String medicoApellido;
private String especialidad;

public Cita() {
}

public Cita(int id, int pacienteId, int medicoId,
            LocalDate fecha, LocalTime hora, String estado) {
    this.id = id;
    this.pacienteId = pacienteId;
    this.medicoId = medicoId;
    this.fecha = fecha;
    this.hora = hora;
    this.estado = estado;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getPacienteId() {
    return pacienteId;
}

public void setPacienteId(int pacienteId) {
    this.pacienteId = pacienteId;
}

public int getMedicoId() {
    return medicoId;
}

public void setMedicoId(int medicoId) {
    this.medicoId = medicoId;
}

public LocalDate getFecha() {
    return fecha;
}

public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
}

public LocalTime getHora() {
    return hora;
}

public void setHora(LocalTime hora) {
    this.hora = hora;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}

public String getPacienteNombre() {
    return pacienteNombre;
}

public void setPacienteNombre(String pacienteNombre) {
    this.pacienteNombre = pacienteNombre;
}

public String getPacienteApellido() {
    return pacienteApellido;
}

public void setPacienteApellido(String pacienteApellido) {
    this.pacienteApellido = pacienteApellido;
}

public String getMedicoNombre() {
    return medicoNombre;
}

public void setMedicoNombre(String medicoNombre) {
    this.medicoNombre = medicoNombre;
}

public String getMedicoApellido() {
    return medicoApellido;
}

public void setMedicoApellido(String medicoApellido) {
    this.medicoApellido = medicoApellido;
}

public String getEspecialidad() {
    return especialidad;
}

public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
}

}
