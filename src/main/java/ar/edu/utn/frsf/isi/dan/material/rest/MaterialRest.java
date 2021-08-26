package ar.edu.utn.frsf.isi.dan.material.rest;

import java.math.BigDecimal;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frsf.isi.dan.material.model.Material;
import ar.edu.utn.frsf.isi.dan.material.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@RestController
@RequestMapping(Api.MATERIAL_BASE_PATH)
@CrossOrigin
@Tag(name = "MaterialRest", description = "Permite gestionar los materiales de la empresa.")
public class MaterialRest
{
	@Autowired
	private MaterialService materialService;

	/**
	 * Registra un producto y su unidad asociada.
	 * 
	 * @param material
	 * @return
	 */
	@RolesAllowed(Role.EMPLEADO)
	@PostMapping
	@Operation(summary = "Registra un nuevo Material.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Material registrado correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado") })
	public ResponseEntity<?> registrar(@RequestBody @Valid Material material)
	{
		return ResponseEntity.ok(materialService.guardarMaterial(material));
	}

	/**
	 * Actualiza información de un material.
	 * 
	 * @param material
	 * @param id
	 * @return
	 */
	@RolesAllowed(Role.EMPLEADO)
	@PutMapping(path = Api.MATERIAL_PUT_ACTUALIZAR_PATH)
	@Operation(summary = "Actualiza un material.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Material actualizado"),
		@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "material inexistente") })
	public ResponseEntity<?> actualizar(@Parameter(description = "Material a actualizar") @RequestBody Material material,
		@RequestParam(name = "id") Long id)
	{
		return ResponseEntity.ok(materialService.actualizarMaterial(material, id));
	}

	//CONSULTAR POR NOMBRE, RANGO DE STOCK, PRECIO

	@RolesAllowed(Role.EMPLEADO)
	@GetMapping(path = Api.MATERIAL_GET_NOMBRE_PATH)
	@Operation(summary = "Retorna un material por nombre.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Material recuperado"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "material inexistente") })
	public ResponseEntity<Material> obtenerPorNombre(@RequestParam(name = "nombre") String nombre)
	{
		return ResponseEntity.ok(materialService.obtenerMaterialPorNombre(nombre));
	}

	@RolesAllowed(Role.EMPLEADO)
	@GetMapping(path = Api.MATERIAL_GET_RANGO_STOCK_PATH)
	@Operation(summary = "Retorna los materiales en cierto rango de stock.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Materiales recuperado"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "Materiales inexistente") })
	public ResponseEntity<?> obtenerPorNombre(@RequestParam(name = "minimo") BigDecimal min, @RequestParam(name = "maximo") BigDecimal max)
	{
		return ResponseEntity.ok(materialService.obtenerMaterialPorRangoStock(min, max));
	}

	@RolesAllowed(Role.EMPLEADO)
	@GetMapping(path = Api.MATERIAL_GET_PRECIO_PATH)
	@Operation(summary = "Retorna los materiales que importan un dado monto.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Pateriales recuperado"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "materiales inexistente") })
	public ResponseEntity<?> obtenerPorPrecio(@Parameter(description = "Precio del material") @RequestParam() BigDecimal precio)
	{
		return ResponseEntity.ok(materialService.obtenerMaterialPorPrecio(precio));
	}

	@GetMapping(path = "/instancia")
	@Operation(summary = "Retorna información de la instancia.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información de la instancia"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado") })
	public ResponseEntity<?> instancia()
	{
		return ResponseEntity.ok("dan-ms-material -> [OK]");
	}
}
