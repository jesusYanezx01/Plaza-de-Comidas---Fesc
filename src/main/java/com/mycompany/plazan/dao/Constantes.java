/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plazan.dao;

/**
 *
 * @author Jesus
 */
public class Constantes {
    
    //Datos de conexion
    public static final String URL="jdbc:mysql://localhost:3306/";
    public static final String DATABASE="nn";
    public static final String USER="root";
    public static final String PASSWORD="";
    
    
    //Tabla persona
    public static final String T_PERSONA="persona";
    public static final String TP_ID="id";
    public static final String TP_NOMBRE="nombre";
    public static final String TP_APELLIDO="apellido";
    public static final String TP_DOCUMENTO="documento";
    public static final String TP_CELULAR="celular";
    public static final String TP_CORREO="correo";
    public static final String TP_CLAVE="clave";
    public static final String TP_IDTIPOPERSONA="idTipoPersona";
    

    //Tabla tipoPersona
    public static final String T_TIPOPERSONA="tipopersona";
    public static final String TT_ID="id";
    public static final String TT_ROL="rol";
    
    //Tabla Restaurante
    public static final String T_RESTAURANTE= "restaurante";
    public static final String TR_ID= "id";
    public static final String TR_NOMBRE= "nombre";
    public static final String TR_NIT= "nit";
    public static final String TR_DIRECCION= "direccion";
    public static final String TR_TELEFONO= "telefono";
    public static final String TR_URLLOGO= "urlLogo";
    public static final String TR_IDUSUARIOPROPIETARIO= "idUsuarioPropietario";
    
}
