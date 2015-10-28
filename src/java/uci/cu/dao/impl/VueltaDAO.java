/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import uci.cu.dao.base.BaseDAO;
import uci.cu.logic.Vuelta;

/**
 *
 * @author randy
 */
public class VueltaDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE Vuelta SET Anno = ?, Mes = ? WHERE ID = ?;";
    String INSERT_SQL = "INSERT INTO Vuelta(Anno, Mes) VALUES (?, ?);";
    String DELETE_SQL = "DELETE FROM gestionalmohadillas WHERE vueltaid = ?;DELETE FROM Vuelta WHERE ID = ?;";
    
    String SELECT_BY_ID_SQL = "SELECT ID, Anno, Mes FROM Vuelta WHERE ID = ?;";
    String SELECT_ALL_SQL = "SELECT ID, Anno, Mes FROM Vuelta;";
    String SELECT_ULTIMO = "SELECT MAX(ID) as mx FROM Vuelta;";
    
    public VueltaDAO() {
    }
        

    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof Vuelta)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un Vuelta");
        }
        
        Vuelta med = (Vuelta) object;
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	
        ps.setInt(1, med.getAnno());
        ps.setInt(2, med.getMes());        
                
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof Vuelta)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un Vuelta");
        }
        
        Vuelta med = (Vuelta) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
        ps.setInt(1, med.getId());
        ps.setInt(2, med.getId());
	        
        ps.execute();
    }
    
//    public void eliminar(int vid) throws Exception{
//        
//        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
//        ps.setInt(1, vid);
//        ps.E
//    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	Vuelta med = null;
        List<Vuelta> meds = new ArrayList<Vuelta>();
        
	while (resultSet.next()) {
                int id = resultSet.getInt(1);
		int anno = resultSet.getInt(2);
                int mes = resultSet.getInt(3);
                                
                med = new Vuelta(id, anno, mes);
                meds.add(med);
	}
	return meds;
    }
    
    public void modificar(Object vale) throws Exception {
        if (!(vale instanceof Vuelta )) {
            throw new Exception("Esta intentando modificar un objeto que no es un Vuelta");
        }
        
        Vuelta med = (Vuelta) vale;
                
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setInt(1, med.getAnno());
        ps.setInt(2, med.getMes());
        ps.setInt(3, med.getId());
	
	ps.execute();
    }

    
    @Override
    public Vuelta obtenerPorID(Object object) throws Exception {
        if (!(object instanceof Vuelta)) {
            throw new Exception("Esta intentando obtener un Vuelta con un objeto invalido");
            
        }
        
        Vuelta m = new Vuelta();
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        ps.setInt(1, ((Vuelta)object).getId());
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setId(rs.getInt(1));
            m.setAnno(rs.getInt(2));
            m.setMes(rs.getInt(3));
        }
        
        return m;
    }
    
    public Vuelta obtenerUltimaVuelta() throws Exception{
        Vuelta v = new Vuelta();
        int id = -1;
        
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ULTIMO);
	             
	while (resultSet.next()) {
            id = resultSet.getInt(1);
	}
        
        v.setId(id);
        
        v = obtenerPorID(v);
        
        return v;
    }
}
