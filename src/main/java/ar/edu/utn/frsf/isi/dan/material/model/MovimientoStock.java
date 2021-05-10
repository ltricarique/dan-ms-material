package ar.edu.utn.frsf.isi.dan.material.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * @author Leandro Heraldo Tricarique
 *
 */
public class MovimientoStock {
	private Integer id;
	private DetallePedido detallePedido;
	private DetalleProvision detalleProvision;
	private Material material;
	private BigDecimal cantidadEntrada;
	private BigDecimal cantidadSalida;
	private Instant fecha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DetallePedido getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(DetallePedido detallePedido) {
		this.detallePedido = detallePedido;
	}

	public DetalleProvision getDetalleProvision() {
		return detalleProvision;
	}

	public void setDetalleProvision(DetalleProvision detalleProvision) {
		this.detalleProvision = detalleProvision;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public BigDecimal getCantidadEntrada() {
		return cantidadEntrada;
	}

	public void setCantidadEntrada(BigDecimal cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}

	public BigDecimal getCantidadSalida() {
		return cantidadSalida;
	}

	public void setCantidadSalida(BigDecimal cantidadSalida) {
		this.cantidadSalida = cantidadSalida;
	}

	public Instant getFecha() {
		return fecha;
	}

	public void setFecha(Instant fecha) {
		this.fecha = fecha;
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
		MovimientoStock other = (MovimientoStock) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MovimientoStock [id=" + id + ", detallePedido=" + detallePedido + ", detalleProvision="
				+ detalleProvision + ", material=" + material + ", cantidadEntrada=" + cantidadEntrada
				+ ", cantidadSalida=" + cantidadSalida + ", fecha=" + fecha + "]";
	}

}
