package modelo.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.clases.Aplicacion;

/*
 * Crea, consulta o elimina Aplicaciones directamente de la base de datos.
 */
public class AplicacionesDAOPS {
	private static Connection connection;
	
	public static boolean nuevaAplicacion(Aplicacion app) {
		boolean insertado = false;
		PreparedStatement pStatement = null;
		
		try {
			connection = Conexion.conectar();
			
			String sql = "INSERT INTO aplicaciones Values";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return insertado;
	}
}
