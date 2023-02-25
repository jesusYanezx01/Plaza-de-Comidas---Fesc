
package com.mycompany.plazan;

 // author Jesus
import com.mycompany.plazan.controlador.Controlador;
import com.mycompany.plazan.dao.Conexion;
import com.mycompany.plazan.vista.Jflogin;


public class App {

    public static void main(String[] args) {
        
        Jflogin jflogin = new Jflogin();
        
        Controlador controlador = new Controlador();
        controlador.inicio(); 
        
       
                
 
    }

}

