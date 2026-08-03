package com.hospital.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/hospitaldb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {

        Connection conexion = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conectado correctamente a MySQL.");

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontró el Driver.");

        } catch (SQLException e) {

            System.out.println("Error de conexión: " + e.getMessage());

        }

        return conexion;
    }

}