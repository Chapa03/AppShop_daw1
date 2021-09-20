package modelo.clases;

import java.util.Calendar;

public class Juego extends Aplicacion{
	private String categoriaJuego;

	public Juego() {
		
	}

	public Juego(int idAplicacion, String tipoAplicacion, String nombreApp, String descripcion, Usuario desarrollador,
			Calendar fechaPublicacion, float peso, int edadMinima, Opinion opinion, String categoriaJuego) {
		super(idAplicacion, tipoAplicacion, nombreApp, descripcion, desarrollador, fechaPublicacion, peso, edadMinima, opinion);
		this.categoriaJuego = categoriaJuego;
	}

	public Juego(String nombreApp, String descripcion, float peso, int edadMinima) {
		super(nombreApp, descripcion, peso, edadMinima);
		// TODO Auto-generated constructor stub
	}



	public Juego(String nombreApp, String tipoAplicacion, String descripcion, Usuario desarrollador, Calendar fechaPublicacion, float peso,
			int edadMinima) {
		super(nombreApp, tipoAplicacion, descripcion, desarrollador, fechaPublicacion, peso, edadMinima);
		// TODO Auto-generated constructor stub
	}



	public String getCategoriaJuego() {
		return categoriaJuego;
	}

	public void setCategoriaJuego(String categoriaJuego) {
		this.categoriaJuego = categoriaJuego;
	}

	@Override
	public String toString() {
		return "Juego [categoriaJuego=" + categoriaJuego + "]";
	}
	
}
