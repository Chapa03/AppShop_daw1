package modelo.gestionFicheros;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LecturaDeUnaVez {
	public static List<String> lecturaALista(String file, Charset ch) {
		List<String> textoLista=null;
		
		Path fichero = Paths.get(file);
		
		try {
			textoLista = Files.readAllLines(fichero, ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return textoLista;
	}
	
}























