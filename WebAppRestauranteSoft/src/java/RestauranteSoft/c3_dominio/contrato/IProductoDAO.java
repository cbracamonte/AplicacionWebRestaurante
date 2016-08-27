/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c3_dominio.contrato;

import RestauranteSoft.c3_dominio.entidades.Producto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AMARO
 */
public interface IProductoDAO {
    
    public List<Producto> buscar(String descripcion)throws SQLException;
    
    public Producto buscar(int productoid)throws SQLException;
    
    public int ingresar(Producto producto)throws SQLException;
    
    public int modificar(Producto producto)throws SQLException;
    
    public int eliminar(Producto producto)throws SQLException;
    
    public int actualizarStock(Producto producto)throws Exception;
    
    public List<Producto> listaProductos(String tipoBebida)throws SQLException;
    
}
