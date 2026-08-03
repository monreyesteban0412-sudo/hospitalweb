package com.hospital.util;

import java.sql.Connection;

import com.hospital.config.Conexion;

public class PruebaConexion {

    public static void main(String[] args) {

        Connection con = Conexion.conectar();

        if (con != null) {
            System.out.println("==================================");
            System.out.println("CONEXIÓN EXITOSA A MYSQL");
            System.out.println("==================================");
        } else {
            System.out.println("No fue posible conectar.");
        }

    }

}