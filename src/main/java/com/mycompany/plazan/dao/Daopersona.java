/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plazan.dao;

import com.mycompany.plazan.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jesus
 */
public class Daopersona extends Conexion implements Idaopersona{

    

        public boolean ingresar(String user, String pass) {
            Connection con = getConexion();
            PreparedStatement ps = null;
            ResultSet rs;

            String sql = "SELECT " + Constantes.TP_CORREO + "," + Constantes.TP_CLAVE + " FROM " + Constantes.T_PERSONA + " WHERE " + Constantes.TP_CORREO + "='" + user + "' AND " + Constantes.TP_CLAVE + " = '" + pass + "'";

            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                System.err.println(ex);
                return false;
            }

        }
        
        public boolean registrar(Persona persona) {
        PreparedStatement ps = null;
        Connection connection = getConexion();

        String sqlRegistrar = "INSERT INTO " + Constantes.T_PERSONA + "("
                + Constantes.TP_NOMBRE + ","
                + Constantes.TP_APELLIDO + ","
                + Constantes.TP_DOCUMENTO + ","
                + Constantes.TP_CELULAR + ","
                + Constantes.TP_CORREO + ","
                + Constantes.TP_CLAVE+ ","
                + Constantes.TP_IDTIPOPERSONA+ ") VALUES(?,?,?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(sqlRegistrar);

            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getDocumento());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo());
            ps.setString(6, persona.getClave());
            ps.setInt(7, persona.getIdTipoPersona());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Daopersona.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;

    }
        
        


    }



