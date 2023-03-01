/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plazan.dao;

import com.mycompany.plazan.modelo.Persona;
import com.mycompany.plazan.modelo.Restaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class Daorestaurante extends Conexion implements IdaoRestaurante{
    
    public boolean registrarRestaurante(Restaurante restaurante) {
        PreparedStatement ps = null;
        Connection connection = getConexion();

        String sqlRegistrar = "INSERT INTO " + Constantes.T_RESTAURANTE + "("
                + Constantes.TR_NOMBRE + ","
                + Constantes.TR_NIT + ","
                + Constantes.TR_DIRECCION + ","
                + Constantes.TR_TELEFONO + ","
                + Constantes.TR_URLLOGO + ","
                + Constantes.TR_IDUSUARIOPROPIETARIO+ ") VALUES(?,?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(sqlRegistrar);

            ps.setString(1, restaurante.getNombre());
            ps.setString(2, restaurante.getNit());
            ps.setString(3, restaurante.getDireccion());
            ps.setString(4, restaurante.getTelefono());
            ps.setString(5, restaurante.getUrlLogo());
            ps.setInt(6, restaurante.getIdUsuarioPropietario());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Daopersona.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;

    }
    
}
