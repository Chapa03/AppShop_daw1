package control;

import java.util.List;

import modelo.clases.CategoriaJuegos;
import modelo.clases.Usuario;

public class CategoriaControlador {
	
	public String[][] listaCategoriasAArray(List<CategoriaJuegos> listaCategorias){
		String [][] datos = new String[listaCategorias.size()][6];
		for (int i = 0; i < listaCategorias.size(); i++) {
//			datos[i][0] = listaCategorias.get(i).getId;
//			datos[i][1] = listaCategorias.get(i).getNombreCompleto();
		}
		return datos;
	}

}
