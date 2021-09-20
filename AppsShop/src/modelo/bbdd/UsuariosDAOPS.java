package modelo.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.clases.Usuario;

public class UsuariosDAOPS {
	private static Connection connection;
	
	/*
	 * FUNCIONANDO
	 * Insercion de usuario de la base de datos a partir de los datos de un nuevo usuario recibidos por parámetro
	 */
	public static boolean registroUsuario(Usuario user) {
		boolean rowInserted = false;
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			
			String sql = "INSERT INTO `usuarios` VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getNombreCompleto());
			pStatement.setString(2, user.getAlias());
			pStatement.setString(3, user.getPassword());
			pStatement.setString(4, user.getFechaNacimiento());
			pStatement.setString(5, user.getPais());
			pStatement.setString(6, user.getCorreo());
			if (user.isDeveloper()) {
				pStatement.setInt(7, 1);
			} else {
				pStatement.setInt(7, 0);
			}
			// -----------------ejecutamos
			rowInserted = pStatement.executeUpdate() > 0;
	
		} catch (SQLException e) {
			
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
		return rowInserted;
	}
	
	/*
	 * Recoge el usuario que acaba de iniciar sesión.
	 */
	public static Usuario autorizarLogin(String alias, String pass) throws SQLException {
		Usuario u = new Usuario();
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			String sql = "SELECT * FROM usuarios WHERE alias=? AND password=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, alias);
			pStatement.setString(2, pass);
			
			// -----------------ejecutamos
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()) {
				u.setIdUsuario(rs.getInt(1));
				u.setNombreCompleto(rs.getString(2));
				u.setAlias(rs.getString(3)); 
				u.setPassword(rs.getString(4));
				u.setFechaNacimiento(rs.getString(5));
				u.setPais(rs.getString(6));
				u.setCorreo(rs.getString(7));
				u.setDeveloper(rs.getBoolean(8));
			} else {
				System.out.println("Algo no funciona en la consulta");
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
		return u;
	}
	
	
	
	/*
	 * Actualiza o aniade datos a un usuario registrado
	 */
	public static boolean modificarUsuarioBasico(Usuario user) throws SQLException {
		boolean rowActualizar = false;
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			
			String sql = "UPDATE usuarios SET nombreCompleto=?, fechaNacimiento=?, pais=?, correo=? WHERE idUsuario=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getNombreCompleto());
			pStatement.setString(2, user.getFechaNacimiento());
			pStatement.setString(3, user.getPais());
			pStatement.setString(4, user.getCorreo());
			pStatement.setInt(5, user.getIdUsuario());

			rowActualizar = pStatement.executeUpdate() > 0;

		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {			
			try {
				pStatement.close();
				Conexion.desconectar();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return rowActualizar;
	}

	
	
	/*
	 * Elimina un usuario de la base de datos
	 */
	public static boolean eliminarUsuario(int id) throws SQLException {
		boolean rowEliminar = false;
		PreparedStatement pStatement =null;
		
		try {
			connection = Conexion.conectar();
			
			//-------generamos la sentencia
			String sql = "DELETE FROM usuarios WHERE idUsuario=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);

			rowEliminar = pStatement.executeUpdate() > 0;
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {			
			try {
				pStatement.close();
				Conexion.desconectar();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}

		return rowEliminar;
	}
	
	
	
	
	/*
	 * Busca un usuario por su alias en la base de datos.
	 */
	public static List<Usuario> buscarPorAlias(String s) {
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		ResultSet res=null;
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			
			String sql = "SELECT * FROM usuarios WHERE alias LIKE ?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, "%" + s + "%");
			// -----------------ejecutamos
			res = pStatement.executeQuery();
			while (res.next()) {
				listaUsuarios.add(new Usuario(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getBoolean(8)));
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
		return listaUsuarios;
	}
	
	/*
	 * FUNCIONANDO
	 * Insercion de usuario de la base de datos a partir de los datos de un nuevo usuario recibidos por parámetro
	 */
	public static boolean comprobarSiAliasExiste(String s) {
		boolean rowInserted = false;
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			
			String sql = "SELECT * FROM `usuarios` WHERE alias LIKE ?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, s);
			// -----------------ejecutamos
			rowInserted = pStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			// -------------cerramos y desconectamos
			try {
				pStatement.close();
				Conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowInserted;
	}
	
	
	/*
	 * Obtiene la lista de usuarios registrados.
	 */
	public static List<Usuario> obtenerListaUsuarios() throws SQLException {
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		ResultSet res=null;
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			
			String sql = "SELECT * FROM usuarios";
			pStatement = connection.prepareStatement(sql);
			
			// -----------------ejecutamos
			res = pStatement.executeQuery();
			while (res.next()) {
				listaUsuarios.add(new Usuario(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getBoolean(8)));
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
		return listaUsuarios;
	}
	
	/*
	 * Obtiene la lista de desarrolladores.
	 */
	public static List<Usuario> obtenerListaDevs() throws SQLException {
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		ResultSet res=null;
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			
			String sql = "SELECT * FROM usuarios WHERE developer=1";
			pStatement = connection.prepareStatement(sql);
			
			// -----------------ejecutamos
			res = pStatement.executeQuery();
			while (res.next()) {
				listaUsuarios.add(new Usuario(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getBoolean(8)));
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
		return listaUsuarios;
	}
	
	/*
	 * Obtiene la lista de NO desarrolladores.
	 */
	public static List<Usuario> obtenerListaNoDevs() throws SQLException {
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		ResultSet res=null;
		PreparedStatement pStatement = null;
		try {
			connection = Conexion.conectar();
			
			String sql = "SELECT * FROM usuarios WHERE developer=0";
			pStatement = connection.prepareStatement(sql);
			
			// -----------------ejecutamos
			res = pStatement.executeQuery();
			while (res.next()) {
				listaUsuarios.add(new Usuario(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getBoolean(8)));
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
		return listaUsuarios;
	}
}
