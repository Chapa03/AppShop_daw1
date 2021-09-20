package control;

import java.sql.SQLException;
import java.util.List;

import modelo.bbdd.UsuariosDAOPS;
import modelo.clases.Usuario;

/*
 * Usuario activo en la aplicacion que previamente ha iniciado sesion.
 */
public class UsuarioControlador {
	private static Usuario user = new Usuario("Invitado", false);
	private static Usuario invitado = new Usuario("Invitado", false);
	private static Usuario provisional;
	
	/*
	 * Recoge el usuario y contraseña de la ventana de Login y lo coteja con la base de datos.
	 * 
	 */
	public static Usuario login(String alias, String pass) throws SQLException {
		return UsuariosDAOPS.autorizarLogin(alias, pass);
	}
	
	/*
	 * Recoge los datos de un nuevo usuario de la ventana de Signup
	 * y los manda a la clase USUARIOSDAOPS
	 */
	public static boolean register(Usuario user) {
		return UsuariosDAOPS.registroUsuario(user);
	}
	
//	public static boolean isRegistered() {
//		
//	}
	
	/*
	 * Obtiene el usuario activo desde cualquier parte de la aplicacion.
	 */
	public static Usuario getUser() {
		return user;
	}
	
	/*
	 *Modifica el usuario activo.
	 */
	public static void setUser(Usuario u) {
		user = u;
	}
	
	/*
	 * Recoge un alias introducido manualmente para buscar correspondencias de usuarios en la base de datos.
	 */
	public static List<Usuario> searchUser(String alias) {
		return UsuariosDAOPS.buscarPorAlias(alias);
	}
	
//	Para modificar un campo o varios de los datos de un usuario, seteo todos los valores de ese usuario a 
//	datos distintos y en el update siguiente, le paso sus datos antiguos con los nuevos actualizados
	public static Usuario modificarUsuarioBlanco() {
		return provisional = new Usuario(user.getIdUsuario(), "z", "1900-01-01", "z", "z");
	}
	
	public static Usuario modificarUsuario(String nombre, String mail, String fecha, String pais) {
		try {
			UsuariosDAOPS.modificarUsuarioBasico(modificarUsuarioBlanco());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setNombreCompleto(nombre);
		user.setCorreo(mail);
		user.setFechaNacimiento(fecha);
		user.setPais(pais);
		return user;
	}
	
	public static boolean comprobacionActivaAlias(String s) {
		return UsuariosDAOPS.comprobarSiAliasExiste(s);
	}
	
	/*
	 * Cierra la sesion del usuario actual, estableciendo el perfil de invitado como activo
	 */
	public static void logout() {
		user = invitado;
	}
	
	/*
	 * Elimina un perfil de usuario a partir de un id de usuario
	 */
	public static boolean eliminarPerfilUsuario(int idUser) {
		boolean borrado = false;
		try {
			if (UsuariosDAOPS.eliminarUsuario(idUser)) {
				user = invitado;
				borrado = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrado;
	}
	
}
