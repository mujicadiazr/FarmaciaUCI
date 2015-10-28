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
import uci.cu.logic.Trabajador;

/**
 *
 * @author randy
 */
public class TrabajadorDAO extends BaseDAO{
    String UPDATE_SQL = "UPDATE Trabajador SET CI = ?, Nombre = ?, PrimerApellido = ?, SegundoApellido = ?, Telefono = ?, DirPart = ?, Usuario = ?, Contrasenna = ?, Rol = ? WHERE Usuario = ?;";
    String INSERT_SQL = "INSERT INTO Trabajador(CI, Nombre, PrimerApellido, SegundoApellido, Telefono, DirPart, Usuario, Contrasenna, Rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String DELETE_SQL = "DELETE FROM Trabajador WHERE Usuario = ?;";
    String SELECT_BY_ID_SQL = "SELECT * FROM Trabajador WHERE Usuario = ?;";
    String SELECT_ALL_SQL = "SELECT * FROM Trabajador;";
    
    public TrabajadorDAO() {
    }
    
    @Override
    public void salvar(Object object) throws Exception {
        if (!(object instanceof Trabajador)) {
            throw new Exception("Esta intentando almacenar un objeto que no es un Trabajador");
        }
        
        Trabajador trabajador = (Trabajador) object;
        
        PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL);
	ps.setString(1, trabajador.getCi());
	ps.setString(2, trabajador.getNombre());
        ps.setString(3, trabajador.getPrimerApellido());
        ps.setString(4, trabajador.getSegundoApellido());
        ps.setString(5, trabajador.getTelefono());
        ps.setString(6, trabajador.getDireccionParticular());
        ps.setString(7, trabajador.getUsuario());
        ps.setString(8,trabajador.getContrasenna());
        ps.setString(9,trabajador.getRol());
        
	ps.execute();
    }

    @Override
    public void eliminar(Object object) throws Exception {
        if (!(object instanceof Trabajador)) {
            throw new Exception("Esta intentando eliminar un objeto que no es un Trabajador");
        }
        
        Trabajador trabajador = (Trabajador) object;
        
        PreparedStatement ps = getConnection().prepareStatement(DELETE_SQL);
        
        ps.setString(1, trabajador.getUsuario());
	        
        ps.execute();
    }

    @Override
    public List<?> listarTodos() throws Exception {
        Statement st = getConnection().createStatement();
	ResultSet resultSet = st.executeQuery(SELECT_ALL_SQL);
	Trabajador trabajador = null;
        List<Trabajador> lista = new ArrayList<Trabajador>();
        
	while (resultSet.next()) {
                
		String ci = resultSet.getString(1);
                String nombre = resultSet.getString(2) ;
                String primerApellido = resultSet.getString(3);
                String segundoApellido = resultSet.getString(4);                
                String telefono = resultSet.getString(5);
                String direccionParticular = resultSet.getString(6);
                String usuario = resultSet.getString(7);
                String contrasenna = resultSet.getString(8);
                String rol = resultSet.getString(9);
                
		trabajador = new Trabajador(ci, nombre, primerApellido, segundoApellido, telefono, direccionParticular, usuario, contrasenna, rol);
                lista.add(trabajador);
	}
	return lista;
    }
    
    public void modificar(Object old, Object neww) throws Exception {
        if (!(old instanceof Trabajador || neww instanceof Trabajador)) {
            throw new Exception("Esta intentando modificar un objeto que no es un Trabajador");
        }
        
        
        Trabajador trabajadorNew = (Trabajador) neww;
        Trabajador trabajadorOld = (Trabajador) old;
        
        PreparedStatement ps;
	
        if (!trabajadorNew.getCi().equals("")) {
            ps = getConnection().prepareStatement(UPDATE_SQL);
            ps.setString(1, trabajadorNew.getCi());
            ps.setString(2, trabajadorNew.getNombre());
            ps.setString(3, trabajadorNew.getPrimerApellido());
            ps.setString(4, trabajadorNew.getSegundoApellido());
            ps.setString(5,trabajadorNew.getTelefono());
            ps.setString(6, trabajadorNew.getDireccionParticular());
            ps.setString(7, trabajadorNew.getUsuario());
            ps.setString(8, trabajadorNew.getContrasenna());
            ps.setString(9, trabajadorNew.getRol());
            ps.setString(10, trabajadorOld.getUsuario());
            ps.execute();
        }       
    
    }

    @Override
    public Trabajador obtenerPorID(Object object) throws Exception {
        if (!(object instanceof Trabajador)) {
            throw new Exception("Esta intentando obtener un Trabajador con un objeto invalido");
            
        }
        
        Trabajador t = new Trabajador("");
        PreparedStatement ps = getConnection().prepareStatement(SELECT_BY_ID_SQL);
        ps.setString(1, ((Trabajador)object).getUsuario());
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            t.setCi(rs.getString(1));
            t.setNombre(rs.getString(2));
            t.setPrimerApellido(rs.getString(3));
            t.setSegundoApellido(rs.getString(4));
            t.setTelefono(rs.getString(5));
            t.setDireccionParticular(rs.getString(6));
            t.setUsuario(rs.getString(7));
            t.setContrasenna(rs.getString(8));
            t.setRol(rs.getString(9));
        }
        
        return t;
    }

    public boolean estaTrabajadorIdUser(String CI,String user) throws Exception
    {
        PreparedStatement ps1 = getConnection().prepareStatement("select count (*) from trabajador where ci =? ;");
        PreparedStatement ps2 = getConnection().prepareStatement("select count (*) from trabajador where usuario =? ;");
        ps1.setString(1, CI);
        ps2.setString(1, user);
        
        ResultSet r1 = ps1.executeQuery();
        ResultSet r2 = ps2.executeQuery();
        
        int valor1=0;
        int valor2=0;
        
        while(r1.next())
        {
            valor1=r1.getInt(1);
        }
        
        while(r2.next())
        {
            valor2=r2.getInt(1);
        }
        
        if(valor1==valor2&&valor2==0)
            return false;
        return true;
    }
    
}
