package modelo.clases;

public class CategoriaJuegos {
	private int idCategoriaJuegos;
	private String nombreCategoriaJuegos;
	
	public CategoriaJuegos(int idCategoria, String nombreCategoria) {
		super();
		this.idCategoriaJuegos = idCategoria;
		this.nombreCategoriaJuegos = nombreCategoria;
	}
	
	public int getIdCategoria() {
		return idCategoriaJuegos;
	}
	
	public void setIdCategoria(int idCategoria) {
		this.idCategoriaJuegos = idCategoria;
	}
	
	public String getNombreCategoria() {
		return nombreCategoriaJuegos;
	}
	
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoriaJuegos = nombreCategoria;
	}

	@Override
	public String toString() {
		return nombreCategoriaJuegos;
	}

}