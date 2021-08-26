package ar.edu.utn.frsf.isi.dan.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frsf.isi.dan.material.model.Provision;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Repository
public interface ProvisionRepository extends JpaRepository<Provision, Long>
{
}
