package ar.edu.utn.frsf.isi.dan.material.repository;

import ar.edu.utn.frsf.isi.dan.material.model.MovimientoStock;
import ar.edu.utn.frsf.isi.dan.material.model.Provision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvisionRepository extends JpaRepository<Provision, Long> {
}
