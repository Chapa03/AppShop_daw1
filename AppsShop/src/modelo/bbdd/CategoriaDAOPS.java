package modelo.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.clases.CategoriaJuegos;

public class CategoriaDAOPS {
	private static Connection connection;

	/*
	 * Busca un usuario por su alias en la base de datos.
	 */
	public static List<CategoriaJuegos> listaCategorias() {
		List<CategoriaJuegos> listaCategorias= new ArrayList<CategoriaJuegos>();
		ResultSet res=null;
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			
			String sql = "SELECT * FROM categorias";
			pStatement = connection.prepareStatement(sql);
			// -----------------ejecutamos
			res = pStatement.executeQuery();
			while (res.next()) {
				listaCategorias.add(new CategoriaJuegos(res.getInt(1), res.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			// -------------cerramos y desconectamos
			try {
				pStatement.close();
				Conexion.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaCategorias;
	}
	
}
