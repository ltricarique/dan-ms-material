package ar.edu.utn.frsf.isi.dan.material.model;

import java.time.Instant;
import java.util.List;

/**
 * @author Leandro Heraldo Tricarique
 *
 */
public class Provision {
	private Integer id;
	private Instant fechaProvision;
	private List<DetalleProvision> detalle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getFechaProvision() {
		return fechaProvision;
	}

	public void setFechaProvision(Instant fechaProvision) {
		this.fechaProvision = fechaProvision;
	}

	public List<DetalleProvision> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleProvision> detalle) {
		this.detalle = detalle;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Provision)
			return ((Provision) obj).getId().equals(id);
		else
			return false;
	}

	@Override
	public String toString() {
		return "Provision [id=" + id + ", fechaProvision=" + fechaProvision + ", detalle=" + detalle + "]";
	}

}
