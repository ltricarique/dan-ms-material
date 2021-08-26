package ar.edu.utn.frsf.isi.dan.material.model;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Table(name = "PROVISION", schema = "MS_MATERIAL")
public class Provision
{
	@Id
	@SequenceGenerator(name = "provisionGenerator", sequenceName = "SECUENCIA_PROVISION", schema = "MS_MATERIAL", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provisionGenerator")
	@Column(name = "ID")
	private Long id;
	@Column(name = "FECHA_PROVISION")
	private Instant fechaProvision;
	@OneToMany(mappedBy = "provision", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<DetalleProvision> detalle;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Instant getFechaProvision()
	{
		return fechaProvision;
	}

	public void setFechaProvision(Instant fechaProvision)
	{
		this.fechaProvision = fechaProvision;
	}

	public List<DetalleProvision> getDetalle()
	{
		return detalle;
	}

	public void setDetalle(List<DetalleProvision> detalle)
	{
		this.detalle = detalle;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj)
	{
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
	public String toString()
	{
		return "Provision [id=" + id + ", fechaProvision=" + fechaProvision + ", detalle=" + detalle + "]";
	}

}
