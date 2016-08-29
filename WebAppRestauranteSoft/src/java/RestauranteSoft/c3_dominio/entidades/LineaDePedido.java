/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c3_dominio.entidades;

/**
 *
 * @author AMARO
 */
public class LineaDePedido {
    private int cantidad;
    private double precio;
    private String condicion;
    private Producto producto;

    //solo con el constructor por defecto ya que no hay nada que inicializar

//    public LineaDePedido() {
//    }
        
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    //reglas del negocio
    public double calcularSubTotal(){
        return cantidad*precio;
    }
    
}
