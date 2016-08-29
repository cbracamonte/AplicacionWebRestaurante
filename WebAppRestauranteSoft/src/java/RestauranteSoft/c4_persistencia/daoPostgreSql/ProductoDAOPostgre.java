/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c4_persistencia.daoPostgreSql;

import RestauranteSoft.c3_dominio.contrato.IProductoDAO;
import RestauranteSoft.c3_dominio.entidades.Producto;
import RestauranteSoft.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMARO
 */
public class ProductoDAOPostgre implements IProductoDAO{
    
    GestorJDBC gestorJDBC;

    public ProductoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public List<Producto> buscar(String descripcion) throws SQLException{
        ArrayList<Producto> productos = new ArrayList();
        Producto producto;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select productoid, descripcion, tipo, precio, stock, estado"
                + " from producto where descripcion like '%" + descripcion + "%' order by descripcion";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){            
            producto = new Producto();
            producto.setProductoid(resultado.getInt("productoid"));
            producto.setDescripcion(resultado.getString("descripcion"));
            producto.setTipo(resultado.getString("tipo"));
            producto.setPrecio(resultado.getDouble("precio"));
            producto.setStock(resultado.getInt("stock"));
            producto.setEstado(resultado.getString("estado"));
            productos.add(producto);
        }
        resultado.close();
        return productos;    
    }

    @Override
    public Producto buscar(int productoid) throws SQLException {
        Producto producto = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select productoid, descripcion, tipo, precio, stock, estado"
                + " from producto where productoid = " + productoid;

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            producto = new Producto();
            producto.setProductoid(resultado.getInt("productoid"));
            producto.setDescripcion(resultado.getString("descripcion"));
            producto.setTipo(resultado.getString("tipo"));
            producto.setPrecio(resultado.getDouble("precio"));
            producto.setStock(resultado.getInt("stock"));
            producto.setEstado(resultado.getString("estado"));
        }
        resultado.close();
        return producto;  
    }
    
    @Override
    public int ingresar(Producto producto) throws SQLException {
        String sentenciaSQL = "insert into producto(descripcion,tipo,precio,stock,estado) "
                + "values(?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, producto.getDescripcion());
        sentencia.setString(2, producto.getTipo());
        sentencia.setDouble(3, producto.getPrecio());
        sentencia.setInt(4, producto.getStock());
        sentencia.setString(5, producto.getEstado());
        return sentencia.executeUpdate();
    }
    
    @Override
    public int modificar(Producto producto) throws SQLException {
        String sentenciaSQL = "update producto set descripcion = ?, tipo = ?, precio = ?, stock = ?, estado = ? "
                + "where productoid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, producto.getDescripcion());
        sentencia.setString(2, producto.getTipo());
        sentencia.setDouble(3, producto.getPrecio());
        sentencia.setInt(4, producto.getStock());
        sentencia.setString(5, producto.getEstado());
        sentencia.setInt(6, producto.getProductoid());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(Producto producto) throws SQLException {
        String sentenciaSQL = "delete from producto where productoid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, producto.getProductoid());
        return sentencia.executeUpdate();
    }

    @Override
    public int actualizarStock(Producto producto) throws Exception {
        String sentenciaSQL = "UPDATE producto SET stock=? WHERE productoid = ?";
        PreparedStatement sentencia= gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDouble(1, producto.getStock());
        sentencia.setInt(2, producto.getProductoid());
        return sentencia.executeUpdate();
    }

    @Override
    public List<Producto> listaProductos(String tipoBebida) throws SQLException {
        ArrayList<Producto> productos = new ArrayList();
        Producto producto;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select productoid, descripcion, tipo, precio, stock, estado"
                + " from producto where tipo= '" + tipoBebida + "'";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){            
            producto = new Producto();
            producto.setProductoid(resultado.getInt("productoid"));
            producto.setDescripcion(resultado.getString("descripcion"));
            producto.setTipo(resultado.getString("tipo"));
            producto.setPrecio(resultado.getDouble("precio"));
            producto.setStock(resultado.getInt("stock"));
            producto.setEstado(resultado.getString("estado"));
            productos.add(producto);
        }
        resultado.close();
        return productos;    
    }
    
}
