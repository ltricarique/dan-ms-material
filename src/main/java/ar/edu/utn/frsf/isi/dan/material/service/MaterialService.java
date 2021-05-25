package ar.edu.utn.frsf.isi.dan.material.service;

import ar.edu.utn.frsf.isi.dan.material.model.Material;

import java.util.List;

public interface MaterialService {


    Material guardarMaterial(Material material);

    Material actualizarMaterial(Material material, Long id);

    void bajaMaterial(Long id);

    List<Material> listarMateriales();

    Material obtenerMaterialPorId(Long id);

    Material obtenerMaterialPorNombre(String nombre);

    List<Material> obtenerMaterialPorRangoStock(Integer min, Integer max);

    List<Material> obtenerMaterialPorPrecio(Double precio);

}
