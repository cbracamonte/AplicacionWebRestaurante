
package RestauranteSoft.c4_persistencia.daoPostgreSql;

import RestauranteSoft.c3_dominio.contrato.FabricaAbstractaDAO;
import RestauranteSoft.c3_dominio.contrato.IClienteDAO;
import RestauranteSoft.c3_dominio.contrato.IComprobanteDePagoDAO;
import RestauranteSoft.c3_dominio.contrato.IMesaDAO;
import RestauranteSoft.c3_dominio.contrato.IPedidoDAO;
import RestauranteSoft.c3_dominio.contrato.IProductoDAO;
import RestauranteSoft.c3_dominio.contrato.IUsuarioDAO;
import RestauranteSoft.c4_persistencia.GestorJDBC;

/**
 *
 * @author AMARO
 */
public class FabricaDAOpostgre extends FabricaAbstractaDAO{

    @Override
    public GestorJDBC crearGestorJDBC() {
       return new GestorJDBCPostgre();
    }

    @Override
    public IProductoDAO crearProductoDAO(GestorJDBC gestorJDBC) {
        return new ProductoDAOPostgre(gestorJDBC);
    }

    @Override
    public IPedidoDAO crearPedidoDAO(GestorJDBC gestorJDBC) {
        return new PedidoDAOPostgre(gestorJDBC);
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC) {
        return new UsuarioDAOpostgre(gestorJDBC);
    }
    
    public IClienteDAO crearClienteDAO(GestorJDBC gestorJDBC) {
        return new ClienteDAOpostgre(gestorJDBC);
    }

    @Override
    public IMesaDAO crearMesaDAO(GestorJDBC gestorJDBC) {
        return new MesaDAOPostgre(gestorJDBC) ;
    }

    @Override
    public IComprobanteDePagoDAO crearComprobanteDePago(GestorJDBC gestorJDBC) {
        return new ComprobanteDePagoDAOpostgre(gestorJDBC);
    }
    
}
