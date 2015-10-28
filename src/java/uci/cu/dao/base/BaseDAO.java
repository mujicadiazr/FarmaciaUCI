package uci.cu.dao.base;

import java.sql.Connection;
import java.util.List;

import uci.cu.dao.util.JDBCUtil;

/**
 * @author iskael
 * 
 */
public abstract class BaseDAO {

	protected Connection connection;

	public abstract void salvar(Object object) throws Exception;

	public abstract void eliminar(Object object) throws Exception;

	//public abstract void eliminarPorId(Integer id) throws Exception;

	public abstract List<?> listarTodos() throws Exception;

        public abstract Object obtenerPorID(Object object) throws Exception;
        
	//public abstract Object buscarPorID(Integer id) throws Exception;

	public Connection getConnection() throws Exception {
		if (connection == null || connection.isClosed()) {
			connection = JDBCUtil.getConnection();
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
