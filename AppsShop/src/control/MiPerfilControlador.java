package control;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.bbdd.UsuariosDAOPS;
import modelo.clases.Usuario;
import vista.DevPanelUsuario;
import vista.MiPerfil;

public class MiPerfilControlador implements ActionListener{
	private Map<String, Object> componentes = new HashMap<String, Object>();
	
	public MiPerfilControlador() {
		
	}
	
	public MiPerfilControlador(Map<String, Object> componentes) {
		super();
		this.componentes = componentes;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		Object[] opciones = new Object[] {"Sí", "No"};
		Object[] opciones2 = new Object[] {"Sí, quiero borrar mi cuenta y los datos asociados", "CANCELAR"};
		
		switch (s) {
		case "save":
			
			int n = JOptionPane.showOptionDialog(null, "¿Estás seguro de que deseas modificar tus datos personales?", "Confirmación de cambio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);
			if (n == 0) {
				try {
					if (UsuariosDAOPS.modificarUsuarioBasico(UsuarioControlador.modificarUsuario(((JTextField) componentes.get("nombre")).getText(), ((JTextField) componentes.get("mail")).getText(), ((JTextField) componentes.get("fecha")).getText(), ((JTextField) componentes.get("pais")).getText()))) {
						JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
					} else {
						JOptionPane.showMessageDialog(null, "No se han podido actualizar los datos de tu perfil.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (n == 1){
				JOptionPane.showMessageDialog(null, "No se ha cambiado ningún dato.");
			}
			break;
		case "borrar":
			int m = JOptionPane.showOptionDialog(null, "¿Estás seguro de que deseas eliminar tu perfil de usuario?"
					+ "\n\tEsta decisión no es reversible y perderás tus datos personales,"
					+ "\n\tasí como las aplicaciones que hayas asociado a tu cuenta."
					+ "\n\tSe te volverá a pedir confirmación", "Confirmación de borrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[1]);
			if (m == 0) {
				int o = JOptionPane.showOptionDialog(null, "Confirma para eliminar todo tu perfil", "¿Estás seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);
				if (o == 0) {
					if (UsuarioControlador.eliminarPerfilUsuario(UsuarioControlador.getUser().getIdUsuario())) {
						JOptionPane.showMessageDialog(null, "Tu perfil ha sido eliminado con éxito."
								+ "\nInicia sesión con otro perfil o regístrate para poder acceder de nuevo.");
//						Hacer desde aqui invisible la ventana de mi perfil y cambiar al perfil de invitado
					} else {
						JOptionPane.showMessageDialog(null, "Tu perfil no ha podido ser eliminado. Inténtalo de nuevo más adelante.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Operación cancelada");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Operación cancelada");
			}
			break;
		case "devPanel":
			DevPanelUsuario dialog = new DevPanelUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			break;
		case "showData":
			CardLayout c1 = (CardLayout)(((JPanel)componentes.get("cards")).getLayout());
			c1.show((JPanel)componentes.get("cards"), "datos");
			((JLabel)componentes.get("lblNombre")).setText(UsuarioControlador.getUser().getNombreCompleto());
			((JLabel)componentes.get("lblFecha")).setText(UsuarioControlador.getUser().getFechaNacimiento());
			((JLabel)componentes.get("lblMail")).setText(UsuarioControlador.getUser().getCorreo());
			((JLabel)componentes.get("lblPais")).setText(UsuarioControlador.getUser().getPais());
			break;
		case "modData":
			CardLayout c2 = (CardLayout)(((JPanel)componentes.get("cards")).getLayout());
			c2.show((JPanel)componentes.get("cards"), "modificar");
			break;
		case "settings":
			CardLayout c3 = (CardLayout)(((JPanel)componentes.get("cards")).getLayout());
			c3.show((JPanel)componentes.get("cards"), "settings");
			break;

		default:
			break;
		}
		
	}

}
