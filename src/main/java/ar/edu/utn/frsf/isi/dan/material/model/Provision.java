package ar.edu.utn.frsf.isi.dan.material.model;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

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
		Provision other = (Provision) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Provision [id=" + id + ", fechaProvision=" + fechaProvision + ", detalle=" + detalle + "]";
	}

}
