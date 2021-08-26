package ar.edu.utn.frsf.isi.dan.material.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Table(name = "MOVIMIENTO_STOCK", schema = "MS_MATERIAL")
public class MovimientoStock
{
	@Id
	@SequenceGenerator(name = "movimientoStockGenerator", sequenceName = "SECUENCIA_MOVIMIENTO_STOCK", schema = "MS_MATERIAL", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimientoStockGenerator")
	@Column(name = "ID")
	private Long id;
	@OneToOne //(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "ID_DETALLE_PEDIDO", foreignKey = @ForeignKey(name = "FK_MOVIMIENTO_STOCK_ID_DETALLE_PEDIDO_TO_DETALLE_PEDIDO_ID"))
	private DetallePedido detallePedido;
	@OneToOne //(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "ID_DETALLE_PROVISION", foreignKey = @ForeignKey(name = "FK_MOVIMIENTO_STOCK_ID_DETALLE_PROVISION_TO_DETALLE_PROVISION_ID"))
	private DetalleProvision detalleProvision;
	@ManyToOne
	@JoinColumn(name = "ID_MATERIAL", foreignKey = @ForeignKey(name = "FK_MOVIMIENTO_STOCK_ID_MATERIAL_TO_MATERIAL_ID"))
	private Material material;
	@Column(name = "CANTIDAD_ENTRADA")
	private BigDecimal cantidadEntrada;
	@Column(name = "CANTIDAD_SALIDA")
	private BigDecimal cantidadSalida;
	@Column(name = "FECHA")
	private Instant fecha;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public DetallePedido getDetallePedido()
	{
		return detallePedido;
	}

	public void setDetallePedido(DetallePedido detallePedido)
	{
		this.detallePedido = detallePedido;
	}

	public DetalleProvision getDetalleProvision()
	{
		return detalleProvision;
	}

	public void setDetalleProvision(DetalleProvision detalleProvision)
	{
		this.detalleProvision = detalleProvision;
	}

	public Material getMaterial()
	{
		return material;
	}

	public void setMaterial(Material material)
	{
		this.material = material;
	}

	public BigDecimal getCantidadEntrada()
	{
		return cantidadEntrada;
	}

	public void setCantidadEntrada(BigDecimal cantidadEntrada)
	{
		this.cantidadEntrada = cantidadEntrada;
	}

	public BigDecimal getCantidadSalida()
	{
		return cantidadSalida;
	}

	public void setCantidadSalida(BigDecimal cantidadSalida)
	{
		this.cantidadSalida = cantidadSalida;
	}

	public Instant getFecha()
	{
		return fecha;
	}

	public void setFecha(Instant fecha)
	{
		this.fecha = fecha;
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
		MovimientoStock other = (MovimientoStock) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString()
	{
		return "MovimientoStock [id=" + id + ", detallePedido=" + detallePedido + ", detalleProvision=" + detalleProvision + ", material="
			+ material + ", cantidadEntrada=" + cantidadEntrada + ", cantidadSalida=" + cantidadSalida + ", fecha=" + fecha + "]";
	}

}
