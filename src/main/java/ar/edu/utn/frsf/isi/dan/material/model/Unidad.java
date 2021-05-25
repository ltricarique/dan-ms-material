package ar.edu.utn.frsf.isi.dan.material.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

/**
 * @author Leandro Heraldo Tricarique
 *
 */
@Entity
@Immutable
@Table(name = "UNIDAD", schema = "MS_MATERIAL")
public class Unidad
{
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
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
		Unidad other = (Unidad) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString()
	{
		return "Unidad [id=" + id + ", descripcion=" + descripcion + "]";
	}

}
