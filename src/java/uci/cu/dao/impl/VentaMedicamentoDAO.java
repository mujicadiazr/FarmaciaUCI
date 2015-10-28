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
import uci.cu.logic.VentaMedicamento;

/**
 *
 * @author randy
 */
public class VentaMedicamentoDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE VentaMedicamentos SET TrabajadorUsuario = ?, cantMedicamento = ? WHERE MedicamentoNombre = ? AND MedicamentoTipo = ? AND ValeID = ?;";
    String INSERT_SQL = "INSERT INTO VentaMedicamentos(MedicamentoNombre, MedicamentoTipo, ValeID, TrabajadorUsuario, cantMedicamento) VALUES (?, ?, ?, ?, ?);";
    String DELETE_SQL = "DELETE FROM VentaMedicamentos WHERE WHERE MedicamentoNombre = ? AND MedicamentoTipo = ? AND ValeID = ?;";
    String SELECT_BY_ID_SQL = "SELECT * FROM VentaMedicamentos WHERE MedicamentoNombre = ? AND MedicamentoTipo = ? AND ValeID = ?;";
    String SELECT_ALL_SQL = "SELECT * FROM VentaMedicamentos;";
    String MED_DE = "SELECT * FROM ventamedicamentos as vm where vm.valeid = ?;";
    
    public VentaMedicamentoDAO() {
    }
    
        
    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof VentaMedicamento)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un VentaMedicamento");
        }
        
        VentaMedicamento med = (VentaMedicamento) object;
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	
        ps.setString(1, med.getMedicamentoNombre());
	ps.setString(2, med.getMedicamentoTipo());
        ps.setLong(3, med.getValeId());
        ps.setString(4, med.getTrabajadorUsuario());
        ps.setInt(5, med.getCantMedicamento());
        
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof VentaMedicamento)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un VentaMedicamento");
        }
        
        VentaMedicamento med = (VentaMedicamento) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
        ps.setString(1, med.getMedicamentoNombre());
	ps.setString(2, med.getMedicamentoTipo());
        ps.setLong(3, med.getValeId());
	        
        ps.execute();
    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	VentaMedicamento med = null;
        List<VentaMedicamento> meds = new ArrayList<VentaMedicamento>();
        
	while (resultSet.next()) {
                String medicamentoNombre = resultSet.getString(1);
                String medicamentoTipo = resultSet.getString(2);
                int valeId = resultSet.getInt(3);
                String trabajadorUsuario = resultSet.getString(4);
                int cantMedicamento = resultSet.getInt(5);;
                
                med = new VentaMedicamento(medicamentoNombre, medicamentoTipo, valeId, trabajadorUsuario, cantMedicamento);
                meds.add(med);
	}
	return meds;
    }
    
    public void modificar(Object vale) throws Exception {
        if (!(vale instanceof VentaMedicamento )) {
            throw new Exception("Esta intentando modificar un objeto que no es un VentaMedicamento");
        }
        
        VentaMedicamento med = (VentaMedicamento) vale;
                
        PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL);
	ps.setString(1, med.getTrabajadorUsuario());
	ps.setInt(2, med.getCantMedicamento());
        
        ps.setString(3, med.getMedicamentoNombre());
	ps.setString(4, med.getMedicamentoTipo());
        ps.setLong(5, med.getValeId());
      
        ps.execute();
    }

    
    @Override
    public VentaMedicamento obtenerPorID(Object object) throws Exception {
        if (!(object instanceof VentaMedicamento)) {
            throw new Exception("Esta intentando obtener un VentaMedicamento con un objeto invalido");
            
        }
        
        VentaMedicamento m = new VentaMedicamento();
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        
        ps.setString(1, ((VentaMedicamento)object).getMedicamentoNombre());
	ps.setString(2, ((VentaMedicamento)object).getMedicamentoTipo());
        ps.setLong(3, ((VentaMedicamento)object).getValeId());
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            m.setMedicamentoNombre(rs.getString(1));
            m.setMedicamentoTipo(rs.getString(2));
            m.setValeId(rs.getInt(3));
            m.setTrabajadorUsuario(rs.getString(4));
            m.setCantMedicamento(rs.getInt(5));
        }
        
        return m;
    }
    
    public List<VentaMedicamento> MedDeVale(int id) throws Exception{
        List<VentaMedicamento> listaMed = new ArrayList<VentaMedicamento>();
        
        
        PreparedStatement ps = getConnection().prepareStatement(MED_DE);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            VentaMedicamento vm = new VentaMedicamento();
            
            vm.setMedicamentoNombre(rs.getString(1));
            vm.setMedicamentoTipo(rs.getString(2));
            vm.setValeId(rs.getInt(3));
            vm.setTrabajadorUsuario(rs.getString(4));
            vm.setCantMedicamento(rs.getInt(5));
            
            listaMed.add(vm);
        }
        
        return listaMed;        
    }
    
}
