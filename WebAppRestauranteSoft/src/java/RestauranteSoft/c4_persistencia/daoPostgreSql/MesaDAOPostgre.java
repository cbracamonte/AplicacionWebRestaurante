/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestauranteSoft.c4_persistencia.daoPostgreSql;

import RestauranteSoft.c3_dominio.contrato.IMesaDAO;
import RestauranteSoft.c3_dominio.entidades.Mesa;
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
public class MesaDAOPostgre implements IMesaDAO{
    GestorJDBC gestorJDBC;

    public MesaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public Mesa buscar(int numero) throws SQLException {
        Mesa mesa=null;
        ResultSet resultadoMesa;
        String sentenciaSQL="select mesaid,estado,numero from mesa where numero= '" + numero + "'";
        resultadoMesa = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultadoMesa.next()){
            mesa= new Mesa();
            mesa.setMesaid(resultadoMesa.getInt("mesaid"));
            mesa.setEstado(resultadoMesa.getString("estado"));
            mesa.setNumero(resultadoMesa.getInt("numero"));
        }
        resultadoMesa.close();
        return mesa;
    }

    public List<Mesa> listaMesas(String estadoDisponible) throws SQLException {
        ArrayList<Mesa> mesas = new ArrayList();
        Mesa mesa;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT mesaid, estado, numero  FROM mesa where estado = '" + estadoDisponible + "'order by numero";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){            
            mesa = new Mesa();
            mesa.setMesaid(resultado.getInt("mesaid"));
            mesa.setEstado(resultado.getString("estado"));
            mesa.setNumero(resultado.getInt("numero"));
            mesas.add(mesa);
        }
        resultado.close();
        return mesas; 
    }

    @Override
    public int modificarEstado(Mesa mesa) throws Exception {
        String sentenciaSQL = "UPDATE mesa SET estado=? WHERE mesaid = ?";
        PreparedStatement sentencia= gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, mesa.getEstado());
        sentencia.setInt(2, mesa.getMesaid());
        return sentencia.executeUpdate();
    }
    
}
