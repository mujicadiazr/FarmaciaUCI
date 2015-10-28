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
import uci.cu.logic.InformeRecepcion;
import uci.cu.logic.Reclamacion;
import uci.cu.logic.Vale;

/**
 *
 * @author randy
 */
public class InformeRecepcionDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE InformeRecepcion SET importe = ? WHERE Documentoid = ?;";
    String INSERT_SQL = "INSERT INTO InformeRecepcion(Documentoid, importe) VALUES (?, ?);";
    String DELETE_SQL = "DELETE FROM InformeRecepcion WHERE Documentoid = ?;";
    String SELECT_BY_ID_SQL = "SELECT Documentoid, importe FROM InformeRecepcion WHERE Documentoid = ?;";
    String SELECT_ALL_SQL = "SELECT Documentoid, importe FROM InformeRecepcion;";
        
    public InformeRecepcionDAO() {
    }
        

    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof InformeRecepcion)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un InformeRecepcion");
        }
        
        InformeRecepcion  med = (InformeRecepcion) object;
        //Insertamos el documento
        (new DocumentoDAO()).salvar(med);
        //cogemos el id
        int id = (new DocumentoDAO()).obtenerUltimoVale().getId();
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	
        ps.setInt(1, id);
        ps.setFloat(2, med.getImporte());
       
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof InformeRecepcion)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un InformeRecepcion");
        }
        
        InformeRecepcion med = (InformeRecepcion) object;
        
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
	InformeRecepcion med = null;
        List<InformeRecepcion> meds = new ArrayList<InformeRecepcion>();
        
	while (resultSet.next()) {
                Documento d = (new DocumentoDAO()).obtenerPorID(new Documento(resultSet.getInt(1)));
                
                med = new InformeRecepcion(resultSet.getFloat(2), d.getId(), d.getTrabajadorUsuario(), d.getFecha(),d.getDatosFactura());
                meds.add(med);
	}
	return meds;
    }
    
    public void modificar(Object vale) throws Exception {
        if (!(vale instanceof InformeRecepcion )) {
            throw new Exception("Esta intentando modificar un objeto que no es un InformeRecepcion");
        }
        
        InformeRecepcion med = (InformeRecepcion) vale;
        
        //Modificamos el documento
        (new DocumentoDAO()).modificar(med);
        
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setFloat(1, med.getImporte());	
        ps.setInt(2,med.getId());
        
	ps.execute();
    }

    
    @Override
    public InformeRecepcion obtenerPorID(Object object) throws Exception {
        if (!(object instanceof InformeRecepcion)) {
            throw new Exception("Esta intentando obtener un InformeRecepcion con un objeto invalido");
            
        }
        
        InformeRecepcion m = (InformeRecepcion)object;
        Documento d = (new DocumentoDAO()).obtenerPorID(m);
        
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        ps.setInt(1, ((InformeRecepcion)object).getId());
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setImporte(rs.getFloat(2));            
        }
        
        m.setDatosFactura(d.getDatosFactura());
        m.setFecha(d.getFecha());
        m.setTrabajadorUsuario(d.getTrabajadorUsuario());
        m.setId(d.getId());
        
        return m;
    }
}
