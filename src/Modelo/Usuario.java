package Modelo;

import javax.swing.Timer;

public class Usuario {
    
    private String nombre;
    
    private String cedula;
    
    public Usuario(String pnombre){
        this.nombre=pnombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }
    
    
}