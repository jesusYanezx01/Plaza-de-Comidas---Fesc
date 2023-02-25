/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plazan.dao;

import com.mycompany.plazan.modelo.Persona;

/**
 *
 * @author Jesus
 */
public interface Idaopersona {
    
    
    public boolean ingresar(String user, String pass);
    
    public boolean registrar (Persona persona);
    
    
    
    
}
