package ar.edu.utn.frsf.isi.dan.material.service.impl;

import ar.edu.utn.frsf.isi.dan.material.model.Material;
import ar.edu.utn.frsf.isi.dan.material.repository.MaterialRepository;
import ar.edu.utn.frsf.isi.dan.material.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImp implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public Material guardarMaterial(Material material) {

        return materialRepository.save(material);
    }

    @Override
    public Material actualizarMaterial(Material material, Long id) {
        return materialRepository.save(material);
    }

    @Override
    public void bajaMaterial(Long id) {
        materialRepository.deleteById(id);
    }

    @Override
    public List<Material> listarMateriales() {
        return materialRepository.findAll();
    }

    @Override
    public Material obtenerMaterialPorId(Long id) {
        return materialRepository.findById(id).get();
    }

    @Override
    public Material obtenerMaterialPorNombre(String nombre) {
        return materialRepository.findByNombre(nombre);
    }

    @Override
    public List<Material> obtenerMaterialPorRangoStock(Integer min, Integer max) {
        return materialRepository.findByStockActualBetween(min, max);
    }

    @Override
    public List<Material> obtenerMaterialPorPrecio(Double precio) {
        return materialRepository.findByPrecio(precio);
    }
}
