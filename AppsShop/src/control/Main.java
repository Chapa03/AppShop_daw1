package control;

import java.awt.EventQueue;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import modelo.bbdd.AplicacionesDAO;
import modelo.bbdd.CategoriaDAOPS;
import modelo.bbdd.UsuariosDAOPS;
import modelo.clases.Aplicacion;
import modelo.clases.CategoriaJuegos;
import modelo.clases.Usuario;
import modelo.gestionFicheros.EscrituraConvertida;
import modelo.gestionFicheros.LecturaDeUnaVez;
import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		/**
		 * Charsets utilizados para la lectura y escritura de ficheros
		 */
		Charset charset1 = StandardCharsets.UTF_8;
		Charset charset2 = StandardCharsets.ISO_8859_1;
		
		/**
		 * Ficheros para leer o escribir
		 */
		String ficheroAplicaciones = "files/entradas/aplicacionesIniciales.csv";
		String nuevoFicheroExportado = "files/salidas/listaAplicacionesSimple.txt";
		
		/**
		 * Listas utilizadas para la lectura de ficheros
		 */
		List<String> listaSimpleAplicaciones = null;
		

		/*
		 * Creacion de la ventana principal sobre la que funciona toda la aplicacion
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
//		EscrituraConvertida.escrituraDesdeLista(ficheroAplicaciones, nuevoFicheroExportado, charset2);
//		
//		System.out.println("Lectura del nuevo fichero simple de aplicaciones:");
//		listaSimpleAplicaciones = LecturaDeUnaVez.lecturaALista(nuevoFicheroExportado, charset2);
//		for (String s : listaSimpleAplicaciones) {
//			System.out.println(s);
//		}

//		AplicacionesDAO.insertarAplicacion(new Aplicacion());
//		AplicacionesDAO.selectPrueba();
	}
	
}
