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
import uci.cu.logic.Suscripcion;
import uci.cu.logic.Vale;

/**
 *
 * @author randy
 */
public class SuscripcionDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE Suscripcion SET CI = ?, Nombre = ?, PrimerApellido = ?, SegundoApellido = ? WHERE CI = ?;";
    String INSERT_SQL = "INSERT INTO Suscripcion(CI, Nombre, PrimerApellido, SegundoApellido) VALUES (?, ?, ?, ?);";
    String DELETE_SQL = "DELETE FROM Suscripcion WHERE CI = ?;";
    String SELECT_BY_ID_SQL = "SELECT CI, Nombre, PrimerApellido, SegundoApellido FROM Suscripcion WHERE CI = ?;";
    String SELECT_ALL_SQL = "SELECT CI, Nombre, PrimerApellido, SegundoApellido FROM Suscripcion;";
    String YA_COGIO_SQL = "select * from vuelta as v join gestionalmohadillas as g on v.id = g.vueltaid \n" +
                            "join suscripcion as s on s.ci = g.suscripcionci\n" +
                            "where s.ci = ? AND v.id = (select MAX(id) from vuelta);";
    
    public SuscripcionDAO() {
    }
        

    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof Suscripcion)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un Suscripcion");
        }
        
        Suscripcion med = (Suscripcion) object;
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	
        ps.setString(1, med.getCi());
	ps.setString(2, med.getNombre());
        ps.setString(3, med.getPrimerApell());
        ps.setString(4, med.getSegundoApell());
                
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof Suscripcion)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un Suscripcion");
        }
        
        Suscripcion med = (Suscripcion) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
        ps.setString(1, med.getCi());
	        
        ps.execute();
    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	Suscripcion med = null;
        List<Suscripcion> meds = new ArrayList<Suscripcion>();
        
	while (resultSet.next()) {
                                
                med = new Suscripcion(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4));
                meds.add(med);
                med = null;
	}
	return meds;
    }
    
    public void modificar(Object old, Object neww) throws Exception {
        if (!(old instanceof Suscripcion || neww instanceof Suscripcion )) {
            throw new Exception("Esta intentando modificar un objeto que no es un Suscripcion");
        }
        
        Suscripcion o = (Suscripcion) old;
        Suscripcion n = (Suscripcion) neww;
                
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setString(1, n.getCi());
	ps.setString(2, n.getNombre());
        ps.setString(3, n.getPrimerApell());
        ps.setString(4, n.getSegundoApell());
      
        ps.setString(5,o.getCi());
        
	ps.execute();
    }

    
    @Override
    public Suscripcion obtenerPorID(Object object) throws Exception {
        if (!(object instanceof Suscripcion)) {
            throw new Exception("Esta intentando obtener un Suscripcion con un objeto invalido");
            
        }
        
        Suscripcion m = new Suscripcion();
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        ps.setString(1, ((Suscripcion)object).getCi());
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setCi(rs.getString(1));
            m.setNombre(rs.getString(2));
            m.setPrimerApell(rs.getString(3));
            m.setSegundoApell(rs.getString(4));
        }
        
        return m;
    }
    
    public boolean yaCogio(Suscripcion obj) throws Exception{
        PreparedStatement ps = getConnection().prepareStatement(YA_COGIO_SQL);
        ps.setString(1, obj.getCi());
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return true;
        return false;
    }
}
