package ar.edu.utn.frsf.isi.dan.material.service.impl;

import ar.edu.utn.frsf.isi.dan.material.model.*;
import ar.edu.utn.frsf.isi.dan.material.repository.MaterialRepository;
import ar.edu.utn.frsf.isi.dan.material.repository.MovimientoStockRepository;
import ar.edu.utn.frsf.isi.dan.material.repository.ProvisionRepository;
import ar.edu.utn.frsf.isi.dan.material.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServiceImp implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private MovimientoStockRepository movimientoStockRepository;
    @Autowired
    private ProvisionRepository provisionRepository;

    @JmsListener(destination = "COLA_PEDIDOS")
    public void handle(Message msg) throws JMSException {
        //Recibir el mensaje y generar un movimiento de stock y hacer un pedido dado el caso
        List<DetallePedido> detalles = new ArrayList<>();
        if (msg instanceof ObjectMessage) {

            Object o = ((ObjectMessage) msg).getObject();
            detalles = (ArrayList<DetallePedido>) o;

            List<DetalleProvision> detalleProvisions = new ArrayList<>();

            for(DetallePedido d : detalles){

                //Actualizar stock del producto
                BigDecimal nuevoStock = d.getMaterial().getStockActual().subtract(d.getCantidad());
                d.getMaterial().setStockActual(nuevoStock);
                materialRepository.save(d.getMaterial());

                //Crear Movimiento Stock

                MovimientoStock movimientoStock = new MovimientoStock();
                movimientoStock.setDetallePedido(d);
                movimientoStock.setMaterial(d.getMaterial());
                movimientoStock.setCantidadSalida(d.getCantidad());
                movimientoStock.setFecha(Instant.now());
                movimientoStockRepository.save(movimientoStock);

                //Crear detalle de provision si el stock es menor al minimo

                if(nuevoStock.compareTo(d.getMaterial().getStockMinimo()) < 0){
                    DetalleProvision detalleProvision = new DetalleProvision();
                    detalleProvision.setCantidad(d.getCantidad());
                    detalleProvision.setMaterial(d.getMaterial());
                    detalleProvisions.add(detalleProvision);
                }

            }
             // registrar pedido de provision por cada stock menor al minimo
            if(!detalleProvisions.isEmpty()){
                Provision provision = new Provision();
                provision.setDetalle(detalleProvisions);
                provision.setFechaProvision(Instant.now());
                provisionRepository.save(provision);
            }

        }


    }

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
    public List<Material> obtenerMaterialPorRangoStock(BigDecimal min, BigDecimal max) {
        return materialRepository.findByStockActualBetween(min, max);
    }

    @Override
    public List<Material> obtenerMaterialPorPrecio(BigDecimal precio) {
        return materialRepository.findByPrecioUnitario(precio);
    }
}
