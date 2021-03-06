package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.bbdd.UsuariosDAOPS;
import modelo.clases.Usuario;
import modelo.gestionFicheros.EscrituraConvertida;

public class DevPanelUsuariosControlador implements ActionListener, KeyListener{
	
	private Map<String, Object> componentes = new HashMap<String, Object>();
	private String[] cabecera = {"Alias", "Nombre completo", "Fecha de nacimiento", "Pa?s", "Correo", "Desarrollador"};
	
	Charset charset1 = StandardCharsets.UTF_8;
	Charset charset2 = StandardCharsets.ISO_8859_1;
	String ficheroAplicaciones = "files/entradas/aplicacionesIniciales.csv";
	String nuevoFicheroExportado = "files/salidas/listaAppsDesdeBoton.txt";
	String allUsersToTxt = "files/salidas/allUsersToTxt.txt";
	
	public DevPanelUsuariosControlador() {
		
	}
	

	public DevPanelUsuariosControlador(Map<String, Object> componentes) {
		super();
		this.componentes = componentes;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		
		switch (s) {
		case "search":
			String texto = ((JTextField)componentes.get("txtBuscar")).getText();
			List<Usuario> listaUsuarios = UsuariosDAOPS.buscarPorAlias(texto);
			DefaultTableModel modeloBusquedaAlias = new DefaultTableModel(rellenarTabla(listaUsuarios), cabecera);
			((JTable)componentes.get("tabla")).setModel(modeloBusquedaAlias);
			break;
		case "showAll":
			try {
				DefaultTableModel modeloListaTodos = new DefaultTableModel(rellenarTabla(UsuariosDAOPS.obtenerListaUsuarios()), cabecera);
				((JTable)componentes.get("tabla")).setModel(modeloListaTodos);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "devs":
			DefaultTableModel modeloListaDevs;
			try {
				modeloListaDevs = new DefaultTableModel(rellenarTabla(UsuariosDAOPS.obtenerListaDevs()), cabecera);
				((JTable)componentes.get("tabla")).setModel(modeloListaDevs);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "nodevs":
			DefaultTableModel modeloListaNoDevs;
			try {
				modeloListaNoDevs = new DefaultTableModel(rellenarTabla(UsuariosDAOPS.obtenerListaNoDevs()), cabecera);
				((JTable)componentes.get("tabla")).setModel(modeloListaNoDevs);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "all":
			EscrituraConvertida.escrituraDesdeListaUsers(allUsersToTxt, charset2);
			break;
		case "originalToTxt":
			EscrituraConvertida.escrituraDesdeLista(ficheroAplicaciones, nuevoFicheroExportado, charset2);
			break;
		default:
			break;
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		String texto = ((JTextField)componentes.get("txtBuscar")).getText();
		List<Usuario> listaUsuarios = UsuariosDAOPS.buscarPorAlias(texto);
		DefaultTableModel modelo = new DefaultTableModel(rellenarTabla(listaUsuarios), cabecera);
		((JTable)componentes.get("tabla")).setModel(modelo);
	}
	
	public String[][] rellenarTabla(List<Usuario> listaUsuarios){
		String [][] datos = new String[listaUsuarios.size()][6];
		for (int i = 0; i < listaUsuarios.size(); i++) {
			datos[i][0] = listaUsuarios.get(i).getAlias();
			datos[i][1] = listaUsuarios.get(i).getNombreCompleto();
			datos[i][2] = listaUsuarios.get(i).getFechaNacimiento();
			datos[i][3] = listaUsuarios.get(i).getPais();
			datos[i][4] = listaUsuarios.get(i).getCorreo();
			datos[i][5] = (listaUsuarios.get(i).isDeveloper() ? "S?" : "No");
		}
		return datos;
	}

}








