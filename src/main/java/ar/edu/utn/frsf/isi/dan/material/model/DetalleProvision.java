package ar.edu.utn.frsf.isi.dan.material.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Table(name = "DETALLE_PROVISION", schema = "MS_MATERIAL")
public class DetalleProvision
{
	@Id
	@SequenceGenerator(name = "detalleProvisionGenerator", sequenceName = "SECUENCIA_DETALLE_PROVISION", schema = "MS_MATERIAL", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalleProvisionGenerator")
	@Column(name = "ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "ID_MATERIAL", foreignKey = @ForeignKey(name = "FK_DETALLE_PROVISION_ID_MATERIAL_TO_MATERIAL_ID"))
	private Material material;
	@Column(name = "CANTIDAD")
	private BigDecimal cantidad;
	@ManyToOne
	@JoinColumn(name = "ID_PROVISION", foreignKey = @ForeignKey(name = "FK_DETALLE_PROVISION_ID_PROVISION_TO_PROVISION_ID"))
	@JsonIgnore
	private Provision provision;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Material getMaterial()
	{
		return material;
	}

	public void setMaterial(Material material)
	{
		this.material = material;
	}

	public BigDecimal getCantidad()
	{
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad)
	{
		this.cantidad = cantidad;
	}

	public Provision getProvision()
	{
		return provision;
	}

	public void setProvision(Provision provision)
	{
		this.provision = provision;
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
		DetalleProvision other = (DetalleProvision) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString()
	{
		return "DetalleProvision [id=" + id + ", material=" + material + ", cantidad=" + cantidad + "]";
	}

}
