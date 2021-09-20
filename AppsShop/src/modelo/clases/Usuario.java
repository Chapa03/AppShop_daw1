package modelo.clases;

import java.util.Calendar;

public class Usuario {
	private int idUsuario;
	private String nombreCompleto;
	private String alias;
	private String password;
	private String fechaNacimiento;
	private String pais;
	private String correo;
	private boolean developer;
	private boolean loged;
	
	public Usuario() {
		
	}
	
	public Usuario (String alias, boolean loged) {
		this.alias = alias;
		this.loged = loged;
	}
	
	public Usuario(int idUsuario, String nombreCompleto, String alias, String password, String fechaNacimiento, String pais, String correo,
			boolean developer) {
		super();
		this.idUsuario = idUsuario;
		this.nombreCompleto = nombreCompleto;
		this.alias = alias;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;
		this.correo = correo;
		this.developer = developer;
	}
	
	/*
	 * Este es el constructor que utilizará la vista para comprobar
	 * si un usuario de la base de datos ha iniciado sesión
	 */
	public Usuario(int idUsuario, String nombreCompleto, String alias, String password, String fechaNacimiento, String pais, String correo,
			boolean developer, boolean loged) {
		super();
		this.idUsuario = idUsuario;
		this.nombreCompleto = nombreCompleto;
		this.alias = alias;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;
		this.correo = correo;
		this.developer = developer;
		this.loged = loged;
	}
	
	public Usuario(int idUsuario, String nombreCompleto, String fechaNacimiento, String pais, String correo) {
		super();
		this.idUsuario = idUsuario;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;
		this.correo = correo;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isDeveloper() {
		return developer;
	}

	public void setDeveloper(boolean developer) {
		this.developer = developer;
	}
	
	public boolean isLoged() {
		return loged;
	}

	public void setLoged(boolean loged) {
		this.loged = loged;
	}

	@Override
	public String toString() {
		return  "\nNombre: " + nombreCompleto
				+ "\nEmail: " + correo
				+ "\nFecha de nacimiento: " + fechaNacimiento
				+ "\nPais: " + pais;
	}
	
}
