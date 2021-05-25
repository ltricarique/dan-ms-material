package ar.edu.utn.frsf.isi.dan.material.repository;

import ar.edu.utn.frsf.isi.dan.material.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>
{
    Material findByNombre(String nombre);
    List<Material> findByStockActualBetween(Integer minimo, Integer maximo);
    List<Material> findByPrecio(Double precio);
}