/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c1_controlador;

import RestauranteSoft.c2_aplicacion.GestionarProductoServicio;
import RestauranteSoft.c3_dominio.entidades.Producto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class ProductoBeans {

    private int productoid;
    private String descripcion;
    private String tipo;
    private int stock;
    private double precio;
    private String estado;
    
    private List<Object> lista;

    public List<Object> getLista() {
        return lista;
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
    
    

    //Metodos.
    public String ingresarProducto() throws Exception {
        String urlRetorno= "vistaGuardarProducto";
        Producto producto;
        try {
            producto= new Producto(descripcion, tipo, stock, precio, estado);
            
            GestionarProductoServicio gestionarProductoServicio = new GestionarProductoServicio();
            gestionarProductoServicio.crearProducto(producto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return urlRetorno;
    }

}
