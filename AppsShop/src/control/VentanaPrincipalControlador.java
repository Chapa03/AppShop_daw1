package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import vista.DevPanelAplicaciones;
import vista.Login;
import vista.MiPerfil;
import vista.Signup;

public class VentanaPrincipalControlador implements ActionListener {
	private Map<String, Object> componentes = new HashMap<String, Object>();

	public VentanaPrincipalControlador() {
		
	}
	
	public VentanaPrincipalControlador(Map<String, Object> componentes) {
		super();
		this.componentes = componentes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		
		switch (s) {
		case "login":
			if (UsuarioControlador.getUser().getAlias().equals("Invitado")) {
				Login dialogLogin = new Login();
				dialogLogin.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogLogin.setVisible(true);
				if(UsuarioControlador.getUser().isDeveloper()) {
					((JButton)componentes.get("devbutton")).setVisible(true);
				} else {
					((JButton)componentes.get("devbutton")).setVisible(false);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ya has iniciado sesión como " + UsuarioControlador.getUser().getAlias()
						+ "\nCierra tu sesión o utiliza la ventana de cambio de usuario para acceder con otra cuenta (ALT + C)");
			}
			
			break;
		case "change":
			if (UsuarioControlador.getUser().getAlias().equals("Invitado")) {
				JOptionPane.showMessageDialog(null, "No hay ningún usuario activo. La sesión actual es la de Invitados");
			} else {
				Login dialogChangeUser = new Login();
				dialogChangeUser.setTitle("Cambiar de usuario");
				dialogChangeUser.setAvisoCambioUsuario(UsuarioControlador.getUser().getAlias());
				dialogChangeUser.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogChangeUser.setVisible(true);
				if(UsuarioControlador.getUser().isDeveloper()) {
					((JButton)componentes.get("devbutton")).setVisible(true);
				} else {
					((JButton)componentes.get("devbutton")).setVisible(false);
				}
			}
			break;
		case "signup":
			if (UsuarioControlador.getUser().getAlias().equals("Invitado")) {
				Signup dialogSignup = new Signup();
				dialogSignup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialogSignup.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Cierra tu sesión como " + UsuarioControlador.getUser().getAlias() + " para registrarte con otra cuenta, por favor.");
			}
			break;
		case "logout":
			if (UsuarioControlador.getUser().getAlias().equals("Invitado")) {
				JOptionPane.showMessageDialog(null, "No hay ningún usuario activo. La sesión actual es la de Invitados");
			} else {
				JOptionPane.showMessageDialog(null, "Hasta pronto, " + UsuarioControlador.getUser().getAlias() + "!!!");
				UsuarioControlador.logout();
//				menuUser.setText(UsuarioControlador.getUser().getAlias());
//				En vez de utilizar la linea anterior para renombrar la etiqueta del jmenu de la
//				ventana principal con el nombre del usuario nuevo, accedemos al elemento de clave
//				"menuUser" que introujimos en la clase de la vista dentro del hashmap.
				((JMenu)componentes.get("menuUser")).setText(UsuarioControlador.getUser().getAlias());
				((JButton)componentes.get("devbutton")).setVisible(false);
			}
			break;
		case "exit":
			System.exit(0);
			break;
		case "perfil":
			if (UsuarioControlador.getUser().isLoged()) {
//				Apertura ventana Mi Perfil
				MiPerfil dialog = new MiPerfil();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Por favor, inicia sesión para acceder a tus datos de usuario."
						+ "\nSi no estás registrado, puedes registrarte desde el menú de Invitado o pulsando ALT+L");
			}
			break;
		case "about":
			JOptionPane.showMessageDialog(null, "AppShop es un proyecto para el módulo de Programación de 1o de DAW");
			break;
		case "devpanel":
			DevPanelAplicaciones dialog = new DevPanelAplicaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		default:
			break;
		}
		
	}
	
}
