package ar.edu.utn.frsf.isi.dan.material.repository;

import ar.edu.utn.frsf.isi.dan.material.model.Material;
import ar.edu.utn.frsf.isi.dan.material.model.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoStockRepository extends JpaRepository<MovimientoStock, Long> {
}
