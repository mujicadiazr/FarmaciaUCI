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
import uci.cu.logic.Documento;
import uci.cu.logic.Reclamacion;
import uci.cu.logic.Vale;

/**
 *
 * @author randy
 */
public class DocumentoDAO extends BaseDAO{
    String INSERT_DOC = "INSERT INTO Documento(TrabajadorUsuario, fecha, datosFactura) VALUES (?, ?, ?);";
    String UPDATE_SQL = "UPDATE Reclamacion SET datosReales = ? WHERE Documentoid = ?;";
    String DELETE_SQL = "DELETE FROM Reclamacion WHERE Documentoid = ?;";    
    String SELECT_ALL_SQL = "SELECT id, TrabajadorUsuario, fecha, datosFactura FROM Documento;";
    String SELECT_BY_ID_SQL = "SELECT id, TrabajadorUsuario, fecha, datosFactura FROM Documento WHERE id = ?;";
    
    String MAX_ID_DOC = "SELECT MAX(id) FROM Documento;";
    
    

    public DocumentoDAO() {
    }

        
    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof Documento)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un Documento");
        }
        
        Documento  med = (Documento) object;
        //Insertamos el documento
        PreparedStatement ps = getConnection().prepareStatement(INSERT_DOC);
	
        ps.setString(1, med.getTrabajadorUsuario());
        ps.setDate(2, med.getFecha());
	ps.setString(3, med.getDatosFactura());
        
          
	ps.execute();
    }

    
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof Documento)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un Documento");
        }
        
        Documento med = (Documento) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
        ps.setInt(1, med.getId());
	        
        ps.execute();
    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	Documento med = null;
        List<Documento> meds = new ArrayList<Documento>();
        
	while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String trabajadorUsuario = resultSet.getString(2);
		Date fecha = resultSet.getDate(3);
                String datosFactura = resultSet.getString(4);
                
                med = new Documento(id, trabajadorUsuario, fecha, datosFactura);
                meds.add(med);
	}
	return meds;
    }
    
     @Override
    public Documento obtenerPorID(Object object) throws Exception {
        if (!(object instanceof Documento)) {
            throw new Exception("Esta intentando obtener un Documento con un objeto invalido");
            
        }
        
        Documento m = new Documento();
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        ps.setInt(1, ((Documento)object).getId());
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setId(rs.getInt(1));
            m.setTrabajadorUsuario(rs.getString(2));
            m.setFecha(rs.getDate(3));
            m.setDatosFactura(rs.getString(4));
        }
        
        return m;
    }
     
     public void modificar(Object vale) throws Exception {
        if (!(vale instanceof Documento )) {
            throw new Exception("Esta intentando modificar un objeto que no es un Documento");
        }
        
        Documento med = (Documento) vale;
                
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setString(1, med.getTrabajadorUsuario());
	ps.setDate(2, med.getFecha());
        ps.setString(3, med.getDatosFactura());
        
        ps.setInt(4,med.getId());
        
	ps.execute();
    }
    
    public Documento obtenerUltimoVale() throws Exception{
        Documento v = new Documento();
        int id = -1;
        
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(MAX_ID_DOC);
	             
	while (resultSet.next()) {
                id = resultSet.getInt(1);
	}
        
        v.setId(id);
        
        return v;
    }
}
