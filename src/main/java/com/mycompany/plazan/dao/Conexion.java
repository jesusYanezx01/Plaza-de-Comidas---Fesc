/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plazan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class Conexion {

    private Connection connection = null;

    public Connection getConexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //getConnection(URL+DATABASE, USER, PASSWORD)
            connection = DriverManager.getConnection(Constantes.URL + Constantes.DATABASE, Constantes.USER, Constantes.PASSWORD);

            if (connection != null) {
                System.out.println("Conexion establecida");
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

}
