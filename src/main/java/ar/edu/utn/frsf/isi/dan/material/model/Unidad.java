package ar.edu.utn.frsf.isi.dan.material.model;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidad other = (Unidad) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Unidad [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
