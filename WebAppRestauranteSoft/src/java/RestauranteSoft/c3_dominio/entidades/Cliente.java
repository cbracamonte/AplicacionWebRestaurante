/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c3_dominio.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class Cliente {
    private int clienteid;
    private String dni;
    private String nombre;
    private String apellidos;
    
    public static final int LONGITUD_NOMBRE = 50;
    public static final int LONGITUD_APELLIDOS = 50;
    public static final int LONGITUD_DNI = 8;

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public static ArrayList datosObligatorios(){
        ArrayList datosObligatorios = new ArrayList();
        datosObligatorios.add("nombre");
        datosObligatorios.add("apellidos");
        datosObligatorios.add("dni");
        return datosObligatorios;
    }
    
    public static ArrayList<String> datosUnicos(){
        ArrayList datosUnicos = new ArrayList();
        datosUnicos.add("dni");
        return datosUnicos;
    }
    
}
