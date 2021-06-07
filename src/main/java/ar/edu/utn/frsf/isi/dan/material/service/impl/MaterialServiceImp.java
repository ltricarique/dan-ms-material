package ar.edu.utn.frsf.isi.dan.material.service.impl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.edu.utn.frsf.isi.dan.material.model.DetallePedido;
import ar.edu.utn.frsf.isi.dan.material.model.DetalleProvision;
import ar.edu.utn.frsf.isi.dan.material.model.Material;
import ar.edu.utn.frsf.isi.dan.material.model.MovimientoStock;
import ar.edu.utn.frsf.isi.dan.material.model.Provision;
import ar.edu.utn.frsf.isi.dan.material.repository.MaterialRepository;
import ar.edu.utn.frsf.isi.dan.material.repository.MovimientoStockRepository;
import ar.edu.utn.frsf.isi.dan.material.repository.ProvisionRepository;
import ar.edu.utn.frsf.isi.dan.material.service.MaterialService;

@Service
public class MaterialServiceImp implements MaterialService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MaterialServiceImp.class);

	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private MovimientoStockRepository movimientoStockRepository;
	@Autowired
	private ProvisionRepository provisionRepository;

	@JmsListener(destination = "COLA_PEDIDOS")
	public void handle(Message msg) throws JMSException, JsonMappingException, JsonProcessingException
	{
		//Recibir el mensaje y generar un movimiento de stock y hacer un pedido dado el caso
		if (msg instanceof TextMessage)
		{
			String json = ((TextMessage) msg).getText();

			ObjectMapper mapper = new ObjectMapper();
			List<DetallePedido> detalles = Arrays.asList(mapper.readValue(json, DetallePedido[].class));;
			LOGGER.info("Pedido recibido de COLA_PEDIDOS");

			List<DetalleProvision> detalleProvisions = new ArrayList<>();

			for (DetallePedido d : detalles)
			{
				Material m = materialRepository.findById(d.getMaterial().getId()).get();

				//Actualizar stock del producto
				BigDecimal nuevoStock = m.getStockActual().subtract(d.getCantidad());
				m.setStockActual(nuevoStock);
				materialRepository.save(m);

				//Crear Movimiento Stock
				MovimientoStock movimientoStock = new MovimientoStock();
				movimientoStock.setDetallePedido(d);
				movimientoStock.setMaterial(m);
				movimientoStock.setCantidadSalida(d.getCantidad());
				movimientoStock.setFecha(Instant.now());
				movimientoStockRepository.save(movimientoStock);

				//Crear detalle de provision si el stock es menor al minimo
				if (nuevoStock.compareTo(m.getStockMinimo()) < 0)
				{
					DetalleProvision detalleProvision = new DetalleProvision();
					detalleProvision.setCantidad(d.getCantidad());
					detalleProvision.setMaterial(m);
					detalleProvisions.add(detalleProvision);
				}
			}
			// registrar pedido de provision por cada stock menor al minimo
			if (!detalleProvisions.isEmpty())
			{
				Provision provision = new Provision();
				provision.setDetalle(detalleProvisions);
				provision.setFechaProvision(Instant.now());
				provisionRepository.save(provision);
			}
		}
	}

	@Override
	public Material guardarMaterial(Material material)
	{
		material = materialRepository.save(material);
		LOGGER.info("Material guardado");
		return material;
	}

	@Override
	public Material actualizarMaterial(Material material, Long id)
	{
		material = materialRepository.save(material);
		LOGGER.info("Material actualizado");
		return material;
	}

	@Override
	public void bajaMaterial(Long id)
	{
		materialRepository.deleteById(id);
		LOGGER.info("Material eliminado");
	}

	@Override
	public List<Material> listarMateriales()
	{
		return materialRepository.findAll();
	}

	@Override
	public Material obtenerMaterialPorId(Long id)
	{
		return materialRepository.findById(id).get();
	}

	@Override
	public Material obtenerMaterialPorNombre(String nombre)
	{
		return materialRepository.findByNombre(nombre);
	}

	@Override
	public List<Material> obtenerMaterialPorRangoStock(BigDecimal min, BigDecimal max)
	{
		return materialRepository.findByStockActualBetween(min, max);
	}

	@Override
	public List<Material> obtenerMaterialPorPrecio(BigDecimal precio)
	{
		return materialRepository.findByPrecioUnitario(precio);
	}
}
