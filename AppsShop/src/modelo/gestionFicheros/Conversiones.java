package modelo.gestionFicheros;
import java.util.ArrayList;
import java.util.List;

import modelo.clases.Aplicacion;
import modelo.clases.Usuario;

public class Conversiones {
	

	public static List<Aplicacion> convertirTexto(List<String> textoLista){
		List<Aplicacion> listaAplicaciones = new ArrayList<Aplicacion>();
		String[] temporalLinea;
		int edadMinimaApp = 0;
		float pesoEnMBApp = 0f;
		textoLista.remove(0);
		for (String s: textoLista) {
			temporalLinea = s.split(";");
			edadMinimaApp = Integer.parseInt(temporalLinea[5].trim());
			pesoEnMBApp = Float.parseFloat(temporalLinea[4]);
			listaAplicaciones.add(new Aplicacion(temporalLinea[0], temporalLinea[1], pesoEnMBApp, edadMinimaApp));
		}
		return listaAplicaciones;
	}

	
	public static List<String> obtenerListaStrings(List<Aplicacion> listaAplicaciones){
		List<String> temp = new ArrayList<String>();
		temp.add("Listado de aplicaciones de la tienda:");
		temp.add("");
		temp.add("Nombre App:\t\tTama?o en MB:\tClasific. edad:\t\tDescripci?n:");
		temp.add("----------------------------------------------------------------------------");
		String tabNombre = "";
		String tabEdad = "\t\t";
		
		listaAplicaciones.remove(0);
		for (Aplicacion app : listaAplicaciones) {
			if (app.getNombreApp().length() >= 8) {
				tabNombre = "\t\t";
			} else if (app.getNombreApp().length() < 8) {
				tabNombre = "\t\t\t";
			} else if ((app.getPeso() + "MB").length() <= 8) {
				tabEdad += "\t";
			}
			temp.add(app.getNombreApp() + tabNombre + app.getPeso() + "MB" + tabEdad + app.getEdadMinima() + " A?os\t\t" + app.getDescripcion());
		}
		return temp;
	}
	
	public static List<String> obtenerListaUsuarios(List<Usuario> listaUsuarios){
		List<String> temp = new ArrayList<String>();
		temp.add("Listado de usuarios registrados en AppShop:");
		temp.add("");
		temp.add("Alias:\t\tNombre completo:\tFecha de nacimiento:\tPa?s\tCorreo:\t\t?Desarrollador?");
		temp.add("----------------------------------------------------------------------------");
		
		listaUsuarios.remove(0);
		for (Usuario user : listaUsuarios) {
			temp.add(user.getAlias() + "\t\t" + user.getNombreCompleto() + "\t" + user.getFechaNacimiento() + "\t" + user.getPais() + "\t" + user.getCorreo() + "\t" + user.isDeveloper());
		}
		return temp;
	}
}
