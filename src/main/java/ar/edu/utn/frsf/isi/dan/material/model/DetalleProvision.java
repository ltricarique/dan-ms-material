package ar.edu.utn.frsf.isi.dan.material.model;

import java.util.Objects;

/**
 * @author Leandro Heraldo Tricarique
 *
 */
public class DetalleProvision {
	private Integer id;
	private Material material;
	private Integer cantidad;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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
		DetalleProvision other = (DetalleProvision) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "DetalleProvision [id=" + id + ", material=" + material + ", cantidad=" + cantidad + "]";
	}

}
