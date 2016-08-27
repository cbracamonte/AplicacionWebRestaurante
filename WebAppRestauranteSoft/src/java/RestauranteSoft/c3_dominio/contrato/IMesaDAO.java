/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c3_dominio.contrato;

import RestauranteSoft.c3_dominio.entidades.Mesa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AMARO
 */
public interface IMesaDAO {
    
    public Mesa buscar(int numero) throws SQLException;
    
    public List<Mesa> listaMesas(String estadoDisponible)throws SQLException;
    
    public int modificarEstado(Mesa mesa)throws Exception;
    
}
