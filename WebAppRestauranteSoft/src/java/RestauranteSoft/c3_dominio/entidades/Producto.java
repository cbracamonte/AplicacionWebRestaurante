/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c3_dominio.entidades;

import java.util.ArrayList;

/**
 *
 * @author AMARO
 */
public class Producto {
    private int productoid;
    private String descripcion;
    private String tipo;
    private int stock;
    private double precio;
    private String estado;
    
    
    public static final int LONGITUD_DESCRIPCION = 50;
    public static final String ESTADO_DISPONIBLE = "DISPONIBLE";
    public static final String ESTADO_NODISPONIBLE = "NO DISPONIBLE";
    public static final String TIPO_MENU = "MENU";
    public static final String TIPO_BEBIDA = "BEBIDA";

    public Producto(int productoid, String descripcion, String tipo, int stock, double precio, String estado) {
        this.productoid = productoid;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.stock = stock;
        this.precio = precio;
        this.estado = estado;
    }

    public Producto(String descripcion, String tipo, int stock, double precio, String estado) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.stock = stock;
        this.precio = precio;
        this.estado = estado;
    }

    public Producto() {
    }
    

        
    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean estaDisponibleParaPedido(){
        if(estado.equals(ESTADO_DISPONIBLE))
            return true;
        else
            return false;            
    }
    public boolean stockDisponible(int cantidad){
        return (stock>=cantidad);
    }
    
    public void restarStock(int cantidad){
        stock=stock-cantidad;
    }
    
    public double valorStock(){
        return precio*stock;
    }
    
    public static ArrayList datosObligatorios(){
        ArrayList datosObligatorios= new ArrayList();
        datosObligatorios.add("descripcion");
        datosObligatorios.add("tipo");
        datosObligatorios.add("precio");
        return datosObligatorios;
    }
    
    public static ArrayList<String> datosUnicos(){
        ArrayList datosUnicos = new ArrayList();
        datosUnicos.add("descripcion");
        return datosUnicos;
    }
}
