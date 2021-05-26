package ar.edu.utn.frsf.isi.dan.material.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;

/**
 * @author Leandro Heraldo Tricarique
 *
 */
@Entity
@Table(name = "DETALLE_PEDIDO", schema = "MS_PEDIDO")
public class DetallePedido
{
	@Id
	@Column(name = "ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "ID_MATERIAL", foreignKey = @ForeignKey(name = "FK_DETALLE_PEDIDO_ID_MATERIAL_TO_MATERIAL_ID"))
	private Material material;
	@Column(name = "CANTIDAD")
	private BigDecimal cantidad;
	@Column(name = "PRECIO")
	private BigDecimal precio;

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

	public BigDecimal getPrecio()
	{
		return precio;
	}

	public void setPrecio(BigDecimal precio)
	{
		this.precio = precio;
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
		DetallePedido other = (DetallePedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString()
	{
		return "DetallePedido [id=" + id + ", material=" + material + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

}
