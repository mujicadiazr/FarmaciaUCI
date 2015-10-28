/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uci.cu.dao.base.BaseDAO;
import uci.cu.logic.GestionAlmohadilla;

/**
 *
 * @author randy
 */
public class GestionAlmohadillaDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE GestionAlmohadillas SET TrabajadorUsuario = ? WHERE VueltaID = ? AND SuscripcionCI = ?;";
    String INSERT_SQL = "INSERT INTO GestionAlmohadillas(VueltaID, SuscripcionCI, TrabajadorUsuario) VALUES (?, ?, ?);";
    String DELETE_SQL = "DELETE FROM GestionAlmohadillas WHERE VueltaID = ? AND SuscripcionCI = ?;";
    String SELECT_BY_ID_SQL = "SELECT VueltaID, SuscripcionCI, TrabajadorUsuario FROM GestionAlmohadillas WHERE VueltaID = ? AND SuscripcionCI = ?;";
    String SELECT_ALL_SQL = "SELECT VueltaID, SuscripcionCI, TrabajadorUsuario FROM GestionAlmohadillas;";
    
    
    public GestionAlmohadillaDAO() {
    }
    
        
    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof GestionAlmohadilla)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un GestionAlmohadilla");
        }
        
        GestionAlmohadilla med = (GestionAlmohadilla) object;
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	
        ps.setInt(1, med.getVueltaId());
	ps.setString(2, med.getSuscripcionCi());
        ps.setString(3, med.getTrabajadorUsuario());       
        
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof GestionAlmohadilla)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un VentaMedicamento");
        }
        
        GestionAlmohadilla med = (GestionAlmohadilla) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
       ps.setInt(1, med.getVueltaId());
       ps.setString(2, med.getSuscripcionCi());
        
        ps.execute();
    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	GestionAlmohadilla med = null;
        List<GestionAlmohadilla> meds = new ArrayList<GestionAlmohadilla>();
        
	while (resultSet.next()) {
                int vueltaID = resultSet.getInt(1);
                String SuscripcionCi = resultSet.getString(2);
                String TrabajadorUsuario = resultSet.getString(3);
                                
                med = new GestionAlmohadilla(vueltaID, SuscripcionCi, TrabajadorUsuario);
                meds.add(med);
	}
	return meds;
    }
    
    public void modificar(Object vale) throws Exception {
        if (!(vale instanceof GestionAlmohadilla )) {
            throw new Exception("Esta intentando modificar un objeto que no es un GestionAlmohadilla");
        }
        
        GestionAlmohadilla med = (GestionAlmohadilla) vale;
                
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setString(1, med.getTrabajadorUsuario());
        ps.setInt(2, med.getVueltaId());
        ps.setString(3, med.getSuscripcionCi());
	
        ps.execute();
    }

    
    @Override
    public GestionAlmohadilla obtenerPorID(Object object) throws Exception {
        if (!(object instanceof GestionAlmohadilla)) {
            throw new Exception("Esta intentando obtener un VentaMedicamento con un objeto invalido");
            
        }
        
        GestionAlmohadilla m = new GestionAlmohadilla();
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        
        ps.setInt(1, ((GestionAlmohadilla)object).getVueltaId());
	ps.setString(2, ((GestionAlmohadilla)object).getSuscripcionCi());
        
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setVueltaId(rs.getInt(1));
            m.setSuscripcionCi(rs.getString(2));
            m.setTrabajadorUsuario(rs.getString(3));
           
        }
        
        return m;
    }
    
    
}
