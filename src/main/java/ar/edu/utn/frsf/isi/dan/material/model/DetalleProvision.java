package ar.edu.utn.frsf.isi.dan.material.model;

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
	public boolean equals(Object obj) {
		if (obj instanceof DetalleProvision)
			return ((DetalleProvision) obj).getId().equals(id);
		else
			return false;
	}

	@Override
	public String toString() {
		return "DetalleProvision [id=" + id + ", material=" + material + ", cantidad=" + cantidad + "]";
	}

}
