/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c3_dominio.entidades;

/**
 *
 * @author Alumno
 */
public class Mesa {
    private int mesaid;
    private String estado;
    private int numero;
    
    public static final String ESTADO_DISPONIBLE = "DISPONIBLE";
    public static final String ESTADO_NO_DISPONIBLE = "NO DISPONIBLE";
    
    public int getMesaid() {
        return mesaid;
    }

    public void setMesaid(int mesaid) {
        this.mesaid = mesaid;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
