package modelo.clases;

import java.util.Calendar;

public class Aplicacion {	
	private int idAplicacion;
	private String tipoAplicacion;
	private String nombreApp;
	private String descripcion;
	private Usuario desarrollador;
	private Calendar fechaPublicacion;
	private float peso;
	private int edadMinima;
	private Opinion opinion;
	
	public Aplicacion() {
		
	}
	
	public Aplicacion(int idAplicacion, String tipoAplicacion, String nombreApp, String descripcion, Usuario desarrollador, Calendar fechaPublicacion,
			float peso, int edadMinima, Opinion opinion) {
		super();
		this.idAplicacion = idAplicacion;
		this.tipoAplicacion = tipoAplicacion;
		this.nombreApp = nombreApp;
		this.descripcion = descripcion;
		this.desarrollador = desarrollador;
		this.fechaPublicacion = fechaPublicacion;
		this.peso = peso;
		this.edadMinima = edadMinima;
		this.opinion = opinion;
	}
	

	//	CONSTRUCTOR SIN OPINIONES
	public Aplicacion(String nombreApp, String tipoAplicacion, String descripcion, Usuario desarrollador, Calendar fechaPublicacion,
			float peso, int edadMinima) {
		super();
		this.nombreApp = nombreApp;
		this.tipoAplicacion = tipoAplicacion;
		this.descripcion = descripcion;
		this.desarrollador = desarrollador;
		this.fechaPublicacion = fechaPublicacion;
		this.peso = peso;
		this.edadMinima = edadMinima;
	}
	
//	CONSTRUCTOR SIN OPINIONES, DESARROLLADORES NI FECHA DE PUBLICACION
	public Aplicacion(String nombreApp, String descripcion, float peso, int edadMinima) {
		super();
		this.nombreApp = nombreApp;
		this.descripcion = descripcion;
		this.peso = peso;
		this.edadMinima = edadMinima;
	}

	public int getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	
	public String getTipoAplicacion() {
		return tipoAplicacion;
	}

	public void setTipoAplicacion(String tipoAplicacion) {
		this.tipoAplicacion = tipoAplicacion;
	}

	public String getNombreApp() {
		return nombreApp;
	}

	public void setNombreApp(String nombreApp) {
		this.nombreApp = nombreApp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(Usuario desarrollador) {
		this.desarrollador = desarrollador;
	}

	public Calendar getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Calendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}

	@Override
	public String toString() {
		return "Aplicacion [nombreApp=" + nombreApp + ", descripcion=" + descripcion + ", desarrollador="
				+ desarrollador + ", fechaPublicacion=" + fechaPublicacion + ", peso=" + peso + ", edadMinima="
				+ edadMinima + ", opinion=" + opinion + "]";
	}	

}
