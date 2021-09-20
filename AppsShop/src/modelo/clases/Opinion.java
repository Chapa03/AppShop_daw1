package modelo.clases;

import java.util.Calendar;

public class Opinion {
	private int idOpinion;
	private Usuario usuario;
	private int valoracion;
	private String comentario;
	private Calendar fechaOpinion;
	
	public Opinion(int idOpinion, Usuario usuario, int valoracion, String comentario, Calendar fechaOpinion) {
		super();
		this.idOpinion = idOpinion;
		this.usuario = usuario;
		this.valoracion = valoracion;
		this.comentario = comentario;
		this.fechaOpinion = fechaOpinion;
	}
	
	public int getIdOpinion() {
		return idOpinion;
	}

	public void setIdOpinion(int idOpinion) {
		this.idOpinion = idOpinion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Calendar getFechaOpinion() {
		return fechaOpinion;
	}

	public void setFechaOpinion(Calendar fechaOpinion) {
		this.fechaOpinion = fechaOpinion;
	}

	@Override
	public String toString() {
		return "Opinion [usuario=" + usuario + ", valoracion=" + valoracion + ", comentario=" + comentario
				+ ", fechaOpinion=" + fechaOpinion + "]";
	}
	
}
