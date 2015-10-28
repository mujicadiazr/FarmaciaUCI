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
public class ReclamacionDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE Reclamacion SET datosReales = ? WHERE Documentoid = ?;";
    String INSERT_SQL = "INSERT INTO Reclamacion(Documentoid, datosReales) VALUES (?, ?);";
    String DELETE_SQL = "DELETE FROM Reclamacion WHERE Documentoid = ?;";
    String SELECT_BY_ID_SQL = "SELECT Documentoid, datosReales FROM Reclamacion WHERE Documentoid = ?;";
    String SELECT_ALL_SQL = "SELECT Documentoid, datosReales FROM Reclamacion;";
    
    public ReclamacionDAO() {
    }
        

    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof Reclamacion)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un Reclamacion");
        }
        
        Reclamacion  med = (Reclamacion) object;
        //Insertamos el documento
        (new DocumentoDAO()).salvar(med);
        //cogemos el id
        int id = (new DocumentoDAO()).obtenerUltimoVale().getId();
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	
        ps.setInt(1, id);
        ps.setString(2, med.getDatosReales());
       
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof Reclamacion)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un Reclamacion");
        }
        
        Reclamacion med = (Reclamacion) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
        ps.setInt(1, med.getId());
	        
        ps.execute();
        //Eliminamos el documento
        (new DocumentoDAO()).eliminar(med);
    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	Reclamacion med = null;
        List<Reclamacion> meds = new ArrayList<Reclamacion>();
        
	while (resultSet.next()) {
                Documento d = (new DocumentoDAO()).obtenerPorID(new Documento(resultSet.getInt(1)));
                
                med = new Reclamacion(resultSet.getString(2), d.getId(), d.getTrabajadorUsuario(), d.getFecha(),d.getDatosFactura());
                meds.add(med);
	}
	return meds;
    }
    
    public void modificar(Object vale) throws Exception {
        if (!(vale instanceof Reclamacion )) {
            throw new Exception("Esta intentando modificar un objeto que no es un Reclamacion");
        }
        
        Reclamacion med = (Reclamacion) vale;
        
        //Modificamos el documento
        (new DocumentoDAO()).modificar(med);
        
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setString(1, med.getDatosReales());	
        ps.setInt(2,med.getId());
        
	ps.execute();
    }

    
    @Override
    public Reclamacion obtenerPorID(Object object) throws Exception {
        if (!(object instanceof Reclamacion)) {
            throw new Exception("Esta intentando obtener un Vale con un objeto invalido");
            
        }
        
        Reclamacion m = new Reclamacion();
        Documento d = (new DocumentoDAO()).obtenerPorID(m);
        
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        ps.setInt(1, ((Reclamacion)object).getId());
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setDatosReales(rs.getString(2));            
        }
        
        m.setDatosFactura(d.getDatosFactura());
        m.setFecha(d.getFecha());
        m.setTrabajadorUsuario(d.getTrabajadorUsuario());
        m.setId(d.getId());
        
        return m;
    }
}
