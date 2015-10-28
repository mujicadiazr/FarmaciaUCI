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
import uci.cu.logic.Vale;

/**
 *
 * @author randy
 */
public class ValeDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE Vale SET Fecha = ?, Hora = ? WHERE ID = ?;";
    String INSERT_SQL = "INSERT INTO Vale(Fecha, Hora) VALUES (?, ?);";
    String DELETE_SQL = "DELETE FROM Vale WHERE ID = ?;";
    String SELECT_BY_ID_SQL = "SELECT * FROM Vale WHERE ID = ?;";
    String SELECT_ALL_SQL = "SELECT * FROM Vale;";
    String SELECT_ULTIMO = "SELECT MAX(ID) as mx FROM Vale;";
    
    public ValeDAO() {
    }
        

    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof Vale)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un Vale");
        }
        
        Vale med = (Vale) object;
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	
        ps.setDate(1, med.getFecha());
	ps.setTime(2, med.getHora());
                
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof Vale)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un Vale");
        }
        
        Vale med = (Vale) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
        ps.setInt(1, med.getId());
	        
        ps.execute();
    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	Vale med = null;
        List<Vale> meds = new ArrayList<Vale>();
        
	while (resultSet.next()) {
                int id = resultSet.getInt(1);
		Date fecha = resultSet.getDate(2);
                Time hora = resultSet.getTime(3);
                
                med = new Vale(fecha, hora, id);
                meds.add(med);
	}
	return meds;
    }
    
    public void modificar(Object vale) throws Exception {
        if (!(vale instanceof Vale )) {
            throw new Exception("Esta intentando modificar un objeto que no es un Vale");
        }
        
        Vale med = (Vale) vale;
                
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setDate(1, med.getFecha());
	ps.setTime(2, med.getHora());
      
        ps.setInt(3,med.getId());
        
	ps.execute();
    }

    
    @Override
    public Vale obtenerPorID(Object object) throws Exception {
        if (!(object instanceof Vale)) {
            throw new Exception("Esta intentando obtener un Vale con un objeto invalido");
            
        }
        
        Vale m = new Vale();
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        ps.setInt(1, ((Vale)object).getId());
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setId(rs.getInt(1));
            m.setFecha(rs.getDate(2));
            m.setHora(rs.getTime(3));
        }
        
        return m;
    }
    
    public Vale obtenerUltimoVale() throws Exception{
        Vale v = new Vale();
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
