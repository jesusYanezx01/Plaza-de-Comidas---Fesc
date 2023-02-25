/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plazan.controlador;

import com.mycompany.plazan.dao.Daopersona;
import com.mycompany.plazan.dao.Idaopersona;
import com.mycompany.plazan.modelo.Hash;
import com.mycompany.plazan.modelo.Persona;
import com.mycompany.plazan.vista.JfMenuPrincipal;
import com.mycompany.plazan.vista.Jflogin;
import com.mycompany.plazan.vista.Jfregitro;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class Controlador implements MouseListener {

    private Jflogin jflogin;
    private Jfregitro jfregistro;
    private JfMenuPrincipal jfMenuPrincipal;
    private Idaopersona idaopersona;

    private Persona persona;
    private Hash hash; 

    public Controlador() {
        this.jflogin = new Jflogin();
        this.jfMenuPrincipal = new JfMenuPrincipal();
        this.jfregistro = new Jfregitro();
        this.jfMenuPrincipal = new JfMenuPrincipal();
        this.persona = new Persona();
        this.hash = new Hash();
        this.idaopersona = new Daopersona();
        //this.idaopersona = new 
        

        //Botones de panel login
        this.jflogin.BotonIngresar.addMouseListener(this);

        //Botones de panel Menu principal
        this.jfMenuPrincipal.botonCerrarSesion.addMouseListener(this);
        this.jfMenuPrincipal.botonRegistrar.addMouseListener(this);

        //Botones de panel registro
        this.jfregistro.botonCrear.addMouseListener(this);
        this.jfregistro.botonVolverRegistro.addMouseListener(this);
        this.jfregistro.comboboxRol.addMouseListener(this);
    }

    public void inicio() {
        jflogin.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Condiciones para botones en le panel de login
        if (e.getSource() == jflogin.BotonIngresar) {
            validacionLogin();
            limpiarDatosLogin();
        }

        //Condiciones para botones en el panel Menu principal
        if (e.getSource() == jfMenuPrincipal.botonCerrarSesion) {
            cerrarPanelMenuPrincipal();
            abrirLogin();

        } else if (e.getSource() == jfMenuPrincipal.botonRegistrar) {
            cerrarPanelMenuPrincipal();
            abrirPanelRegistrar();

        }

        //Condiciones  para botones en el panel registro
        if (e.getSource() == jfregistro.botonVolverRegistro) {
            cerrarPanelRegistro();
            abrirPanelMenuPrincipal();

        } else if (e.getSource() == jfregistro.botonCrear) {
            validacionesParaCrearPersona();

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    //Metodos para cerrar paneles
    
    public void cerrarPanelLogin() {
        jflogin.setVisible(false);
    }

    public void cerrarPanelMenuPrincipal() {
        jfMenuPrincipal.setVisible(false);
    }

    public void cerrarPanelRegistro() {
        jfregistro.setVisible(false);
    }

    //Metodos para abrir paneles
    
    public void abrirPanelMenuPrincipal() {
        jfMenuPrincipal.setVisible(true);
        jfMenuPrincipal.setLocationRelativeTo(null);
    }
    
    public void abrirLogin() {
        jflogin.setVisible(true);
        
    }

    public void abrirPanelRegistrar() {
        jfregistro.setVisible(true);
        jfregistro.setLocationRelativeTo(null);
    }

    //Meotodos para limpiar datos
    
    public void limpiarDatosLogin() {
        jflogin.txtcorreo1.setText("");
        jflogin.txtContraseña.setText("");

    }

    public void limpiarCorreoRegistro() {
        jfregistro.txtCorreo.setText("");
    }
    
    public void limpiarContraseñas() {
        jfregistro.txtContraseña.setText("");
        jfregistro.txtConfirmacionContra.setText("");

    }

    public void limpiarDatosRegistro() {
        jfregistro.txtCorreo.setText("");
        jfregistro.txtNombre.setText("");
        jfregistro.txtApellido.setText("");
        jfregistro.txtCelular.setText("");
        jfregistro.txtConfirmacionContra.setText("");
        jfregistro.txtContraseña.setText("");
        jfregistro.txtDocumento.setText("");
    }

    //Metodos para entrar login - Menu Principal
    
    public void validacionLogin() {
        String user = jflogin.txtcorreo1.getText();
        String pass = jflogin.txtContraseña.getText();
        String newPass = hash.sha1(pass);

        if (user.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos completos");

        } else {

            if (idaopersona.ingresar(user, newPass)) {
                abrirPanelMenuPrincipal();
                cerrarPanelLogin();
            } else {

                JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectas");
                limpiarDatosLogin();

            }
        }
    }
    
    //Meotodo para las validaciones para crear un usuario  

    private void validacionesParaCrearPersona() {

        String contra = jfregistro.txtContraseña.getText();
        String confirContra = jfregistro.txtConfirmacionContra.getText();
        String documento = jfregistro.txtDocumento.getText();

        if (jfregistro.txtNombre.getText().equals("") || jfregistro.txtApellido.getText().equals("") || documento.equals("") || jfregistro.txtCelular.getText().equals("") || jfregistro.txtCorreo.getText().equals("") || contra.equals("") || confirContra.equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios, debe llenar todos los campos");

        } else {

        }
        if (contra.equals(confirContra)) {

            if (esEmail(jfregistro.txtCorreo.getText())) {

                if (isNumeric(documento)) {

                    crearPersonas();

                } else {
                    JOptionPane.showMessageDialog(null, "En el campo documento solo se pueden registrar numeros");
                }

            } else {
                JOptionPane.showMessageDialog(null, "El correo electronico no es valido");
                limpiarCorreoRegistro();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
            limpiarContraseñas();

        }
    }
    
    //Metodo para almacenar una persona en la base de datos 
    
    public void crearPersonas() {

        String contra = jfregistro.txtContraseña.getText();
        String rol = (String) jfregistro.comboboxRol.getSelectedItem();
        String newPass = hash.sha1(contra);

        persona.setNombre(jfregistro.txtNombre.getText());
        persona.setApellido(jfregistro.txtApellido.getText());
        persona.setDocumento(jfregistro.txtDocumento.getText());
        persona.setCelular(jfregistro.txtCelular.getText());
        persona.setCorreo(jfregistro.txtCorreo.getText());
        persona.setClave(newPass);
        if (rol.equals("Administrador")) {
            persona.setIdTipoPersona(1);

        } else if (rol.equals("Propietario")) {
            persona.setIdTipoPersona(2);
        }
        if (idaopersona.registrar(persona)) {
            JOptionPane.showMessageDialog(null, "Registro Guardado");
            limpiarDatosRegistro();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }
    
    //Metodo para validar un formato de correo electronico en especifico 
    
    public boolean esEmail(String correo) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[gmail]+(\\.[com]+)*$");

        Matcher matcher = pattern.matcher(correo);

        return matcher.find();

    }
    
    // Metodo estatico para conocer si una cadena de caracteres esta compuesta de solo numeros 
    
    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
}
}
   
   


    
