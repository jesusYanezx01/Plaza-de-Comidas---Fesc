/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plazan.modelo;

/**
 *
 * @author Jesus
 */
public class Restaurante {

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String urlLogo;
    private int idUsuarioPropietario;

    public Restaurante() {
    }

    public Restaurante(String nombre, String nit, String direccion, String telefono, String urlLogo, int idUsuarioPropietario) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.urlLogo = urlLogo;
        this.idUsuarioPropietario = idUsuarioPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public int getIdUsuarioPropietario() {
        return idUsuarioPropietario;
    }

    public void setIdUsuarioPropietario(int idUsuarioPropietario) {
        this.idUsuarioPropietario = idUsuarioPropietario;
    }

}


