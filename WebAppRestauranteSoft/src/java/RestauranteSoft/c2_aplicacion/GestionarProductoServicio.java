/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c2_aplicacion;

import RestauranteSoft.c3_dominio.contrato.FabricaAbstractaDAO;
import RestauranteSoft.c3_dominio.contrato.IProductoDAO;
import RestauranteSoft.c3_dominio.entidades.Producto;
import RestauranteSoft.c4_persistencia.GestorJDBC;
import RestauranteSoft.c4_persistencia.daoPostgreSql.GestorJDBCPostgre;
import RestauranteSoft.c4_persistencia.daoPostgreSql.ProductoDAOPostgre;
import java.util.List;

/**
 *
 * @author AMARO
 */
public class GestionarProductoServicio {
    private GestorJDBC gestorJDBC;
    private IProductoDAO productoDAO;

    public GestionarProductoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        productoDAO = fabricaAbstractaDAO.crearProductoDAO(gestorJDBC);
    }
    
    public List<Producto> buscarProductos(String descripcion)throws Exception{
        gestorJDBC.abrirConexion();
        List<Producto> productos= productoDAO.buscar(descripcion);
        gestorJDBC.cerrarConexion();
        return productos;
    }
    
    public Producto buscarProducto(int productoid)throws Exception{
        gestorJDBC.abrirConexion();
        Producto producto= productoDAO.buscar(productoid);
        gestorJDBC.cerrarConexion();
        return producto;
    }
    
    public int crearProducto(Producto producto)throws Exception{
        gestorJDBC.abrirConexion();
        int registros_afectados= productoDAO.ingresar(producto);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
    
    public int modificarProducto(Producto producto)throws Exception{
        gestorJDBC.abrirConexion();
        int registros_afectados= productoDAO.modificar(producto);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
    
    public int eliminarProducto(Producto producto)throws Exception{
        gestorJDBC.abrirConexion();
        int registros_afectados= productoDAO.eliminar(producto);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
}
