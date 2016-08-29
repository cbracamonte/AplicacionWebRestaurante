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
import java.util.List;

/**
 *
 * @author AMARO
 */
public class GenerarReporteDeProductosServicio {
    private GestorJDBC gestorJDBC;
    private IProductoDAO productoDAO;

    public GenerarReporteDeProductosServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        productoDAO = fabricaAbstractaDAO.crearProductoDAO(gestorJDBC);
    }
    
    public List<Producto> reporteProductos(String tipoBebida)throws Exception{
        gestorJDBC.abrirConexion();
        List<Producto> productos= productoDAO.listaProductos(tipoBebida);
        gestorJDBC.cerrarConexion();
        return productos;
    }
}
