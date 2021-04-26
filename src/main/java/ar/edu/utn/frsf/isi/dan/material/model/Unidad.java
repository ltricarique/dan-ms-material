package ar.edu.utn.frsf.isi.dan.material.model;

/**
 * @author Leandro Heraldo Tricarique
 *
 */
public class Unidad {
	private Integer id;
	private String descripcion;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Unidad)
			return ((Unidad) obj).getId().equals(id);
		else
			return false;
	}

	@Override
	public String toString() {
		return "Unidad [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
