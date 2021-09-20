package modelo.clases;

import java.util.Calendar;

public class AppGenerica extends Aplicacion{
	private String categoriaApp;

	public AppGenerica() {
	}

	public AppGenerica(int idAplicacion, String tipoAplicacion, String nombreApp, String descripcion, Usuario desarrollador, Calendar fechaPublicacion,
			float peso, int edadMinima, Opinion opinion, String categoriaApp) {
		super(idAplicacion, tipoAplicacion, nombreApp, descripcion, desarrollador, fechaPublicacion, peso, edadMinima, opinion);
		this.categoriaApp = categoriaApp;
	}

	public String getCategoriaApp() {
		return categoriaApp;
	}

	public void setCategoriaApp(String categoriaApp) {
		this.categoriaApp = categoriaApp;
	}

	@Override
	public String toString() {
		return "AppGenerica [categoriaApp=" + categoriaApp + "]";
	}
	
}
