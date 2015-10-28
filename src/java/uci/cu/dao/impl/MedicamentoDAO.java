/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.dao.impl;

import uci.cu.dao.base.BaseDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uci.cu.logic.Medicamento;


/**
 *
 * @author randy
 */
public class MedicamentoDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE Medicamento SET Nombre = ?, Descripcion = ?, Tipo = ?, Costo = ?, Cantidad = ?, UMedida = ?, Lote = ?, FechaVencimiento = ? WHERE Nombre = ? AND Tipo = ?;";
    String INSERT_SQL = "INSERT INTO Medicamento(Nombre, Descripcion, Tipo, Costo, Cantidad, UMedida, Lote, FechaVencimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    String DELETE_SQL = "DELETE FROM Medicamento WHERE Nombre = ? AND Tipo = ?;";
    String SELECT_BY_ID_SQL = "SELECT Nombre, Descripcion, Tipo, Costo, Cantidad, UMedida, Lote, FechaVencimiento FROM Medicamento WHERE Nombre = ? AND Tipo = ?;";
    String SELECT_ALL_SQL = "SELECT Nombre, Descripcion, Tipo, Costo, Cantidad, UMedida, Lote, FechaVencimiento FROM Medicamento;";
     
    
    public MedicamentoDAO() {
    }
    
    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof Medicamento)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un Medicamento");
        }
        
        Medicamento med = (Medicamento) object;
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	ps.setString(1, med.getNombre());
	ps.setString(2, med.getDescripcion());
        ps.setString(3, med.getTipo());
        ps.setFloat(4, med.getCosto());
        ps.setInt(5, med.getCantidad());
        ps.setString(6, med.getUnidadMedida());
        ps.setInt(7, med.getLote());
        ps.setDate(8,med.getFechaVencimiento());
        
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof Medicamento)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un Medicamento");
        }
        
        Medicamento med = (Medicamento) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
        ps.setString(1, med.getNombre());
	ps.setString(2, med.getTipo());
        
        ps.execute();
    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	Medicamento med = null;
        List<Medicamento> meds = new ArrayList<Medicamento>();
        
	while (resultSet.next()) {
		String nombre = resultSet.getString(1);
                String descripcion = resultSet.getString(2); 
                String tipo = resultSet.getString(3);
                float costo = resultSet.getFloat(4);
                int cantidad = resultSet.getInt(5); 
                String unidadMedida = resultSet.getString(6);
                int Lote = resultSet.getInt(7); 
                Date fechaVencimiento = resultSet.getDate(8);
                
		med = new Medicamento(nombre, descripcion, tipo, costo, cantidad, unidadMedida, Lote, fechaVencimiento);
                meds.add(med);
	}
	return meds;
    }
    
    public void modificar(Object old, Object neww) throws Exception {
        if (!(old instanceof Medicamento || neww instanceof Medicamento)) {
            throw new Exception("Esta intentando modificar un objeto que no es un Medicamento");
        }
        
        Medicamento med = (Medicamento) neww;
        Medicamento medOld = (Medicamento) old;
        
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setString(1, med.getNombre());
	ps.setString(2, med.getDescripcion());
        ps.setString(3, med.getTipo());
        ps.setFloat(4, med.getCosto());
        ps.setInt(5, med.getCantidad());
        ps.setString(6, med.getUnidadMedida());
        ps.setInt(7, med.getLote());
        ps.setDate(8,med.getFechaVencimiento());
        
        ps.setString(9, medOld.getNombre());
        ps.setString(10,medOld.getTipo());
        
	ps.execute();
    }

    
    @Override
    public Medicamento obtenerPorID(Object object) throws Exception {
        if (!(object instanceof Medicamento)) {
            throw new Exception("Esta intentando obtener un Medicamento con un objeto invalido");
            
        }
        
        Medicamento m = new Medicamento("", "");
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        ps.setString(1, ((Medicamento)object).getNombre());
        ps.setString(2, ((Medicamento)object).getTipo());
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setNombre(rs.getString(1));
            m.setDescripcion(rs.getString(2));
            m.setTipo(rs.getString(3));
            m.setCosto(rs.getFloat(4));
            m.setCantidad(rs.getInt(5));
            m.setUnidadMedida(rs.getString(6));
            m.setLote(rs.getInt(7));
            m.setFechaVencimiento(rs.getDate(8));
            
        }
        
        return m;
    }

      
    
}
