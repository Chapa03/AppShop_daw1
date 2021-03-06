package modelo.gestionFicheros;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import modelo.bbdd.UsuariosDAOPS;

public class EscrituraConvertida {
	public static void escrituraDesdeLista(String readFile, String writeFile, Charset ch) {
//		Lista donde vamos a almacenar los Strings
		List<String> textoLista=null;
		
//		obtenemos la el fichero, directorio o link en la variable tipo Path
		Path fichero = Paths.get(readFile);
//		segundo archivo para probar la escritura
		Path ficheroEscritura = Paths.get(writeFile);
		
		try {
//			lectura y almacenamiento del contenido del fichero por
//			lineas en la lista textoLista
			textoLista = Files.readAllLines(fichero, ch);
//			Escribiendo en el fichero 
			Files.write(ficheroEscritura, Conversiones.obtenerListaStrings(Conversiones.convertirTexto(textoLista)), ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void escrituraDesdeListaUsers(String writeFile, Charset ch) {
//		Lista donde vamos a almacenar los Strings
		List<String> textoLista=null;
		
		Path ficheroEscritura = Paths.get(writeFile);
		
		try {
//			Escribiendo en el fichero 
			Files.write(ficheroEscritura, Conversiones.obtenerListaUsuarios(UsuariosDAOPS.obtenerListaUsuarios()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
