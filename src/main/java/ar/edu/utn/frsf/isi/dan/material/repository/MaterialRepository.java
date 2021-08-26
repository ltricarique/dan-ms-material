package ar.edu.utn.frsf.isi.dan.material.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frsf.isi.dan.material.model.Material;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>
{
	Material findByNombre(String nombre);

	List<Material> findByStockActualBetween(BigDecimal minimo, BigDecimal maximo);

	List<Material> findByPrecioUnitario(BigDecimal precio);
}