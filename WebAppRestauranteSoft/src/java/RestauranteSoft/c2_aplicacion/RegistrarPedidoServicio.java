
package RestauranteSoft.c2_aplicacion;

import RestauranteSoft.c3_dominio.contrato.FabricaAbstractaDAO;
import RestauranteSoft.c3_dominio.contrato.IMesaDAO;
import RestauranteSoft.c3_dominio.contrato.IPedidoDAO;
import RestauranteSoft.c3_dominio.contrato.IProductoDAO;
import RestauranteSoft.c3_dominio.contrato.IUsuarioDAO;
import RestauranteSoft.c3_dominio.entidades.LineaDePedido;
import RestauranteSoft.c3_dominio.entidades.Mesa;
import RestauranteSoft.c3_dominio.entidades.Pedido;
import RestauranteSoft.c3_dominio.entidades.Producto;
import RestauranteSoft.c3_dominio.entidades.Usuario;
import RestauranteSoft.c4_persistencia.GestorJDBC;
import RestauranteSoft.c4_persistencia.daoPostgreSql.GestorJDBCPostgre;
import RestauranteSoft.c4_persistencia.daoPostgreSql.PedidoDAOPostgre;
import RestauranteSoft.c4_persistencia.daoPostgreSql.ProductoDAOPostgre;
import java.util.List;

/**
 *
 * @author AMARO
 */
public class RegistrarPedidoServicio {
    private GestorJDBC gestorJDBC;
    private IPedidoDAO pedidoDAO;
    private IMesaDAO mesaDAO;
    private IUsuarioDAO usuarioDAO;
    private IProductoDAO productoDAO;

    public RegistrarPedidoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        pedidoDAO = fabricaAbstractaDAO.crearPedidoDAO(gestorJDBC);
        mesaDAO= fabricaAbstractaDAO.crearMesaDAO(gestorJDBC);
        usuarioDAO= fabricaAbstractaDAO.crearUsuarioDAO(gestorJDBC);
        productoDAO= fabricaAbstractaDAO.crearProductoDAO(gestorJDBC);
    }
    
    //------------------Recopilacion de objetos que se necesitan para el pedido----
    public Mesa buscarMesa(int numero) throws Exception{
        gestorJDBC.abrirConexion();
        Mesa mesa= mesaDAO.buscar(numero);
        gestorJDBC.cerrarConexion();
        return mesa;
    }
    //--------------------------------------------------------------------------
    //Metodo para inicar el llenado de datos al combobox
     public List<Mesa> listaMesas(String estadoDisponible)throws Exception{
         try {
             gestorJDBC.abrirConexion();
             List<Mesa>listaMesas= mesaDAO.listaMesas(estadoDisponible);             
             gestorJDBC.cerrarConexion();
             return listaMesas;
         } catch (Exception e) {
             gestorJDBC.cerrarConexion();
             throw e;
         }
     }
     //---------------------------------------------------------------------------
    //buscamos usuario - que realizara l pedido
     public Usuario buscarUsuarioPorDNI(String dni)throws Exception{
        gestorJDBC.abrirConexion();
        Usuario usuario= usuarioDAO.buscarPorDNI(dni);
        gestorJDBC.cerrarConexion();
        return usuario;
    }
    public List<Usuario> listaUsuarios()throws Exception{
        gestorJDBC.abrirConexion();
        List<Usuario>listaUsuarios= usuarioDAO.listaUsuarios();             
        gestorJDBC.cerrarConexion();
        return listaUsuarios;
    }
    //----------------------------------------------------------------------------
              
    //creamos el pedido
    public int crearPedido(Pedido pedido)throws Exception{
        //reglas de negocio con el producto -  lineas de producto
        gestorJDBC.abrirConexion();
        List<LineaDePedido> lineasDePedido = pedido.getLineasDePedido();
        
        try {
            gestorJDBC.iniciarTransaccion();
            pedido.getMesa().setEstado(Mesa.ESTADO_NO_DISPONIBLE);
            //actualizar stock de la lista de productos de un pedido
            //--------------------------------------------------------------------
            for(LineaDePedido lineaDePedido1: lineasDePedido){
                Producto producto= lineaDePedido1.getProducto();
                producto.restarStock(lineaDePedido1.getCantidad()); //obtenemos la cantidad vendida de un producto
            }
            //--------------------------------------------------------------------
            int registros_afectados= pedidoDAO.ingresar(pedido);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }
    
       
    public Pedido buscarPedido(int pedidoid)throws Exception{
        gestorJDBC.abrirConexion();
        Pedido pedido= pedidoDAO.buscar(pedidoid);
        gestorJDBC.cerrarConexion();
        return pedido;
    }
    
    public List<Pedido> ListaPedidosSinCobrar(String estadoPorCobrar)throws Exception{
        gestorJDBC.abrirConexion();
        List<Pedido> pedidos= pedidoDAO.ListaPedidosSinCobrar(estadoPorCobrar);
        gestorJDBC.cerrarConexion();
        return pedidos;
    }
    
}
