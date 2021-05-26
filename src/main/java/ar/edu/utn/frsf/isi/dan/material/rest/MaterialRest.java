package ar.edu.utn.frsf.isi.dan.material.rest;

import ar.edu.utn.frsf.isi.dan.material.model.Material;
import ar.edu.utn.frsf.isi.dan.material.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping(Api.MATERIAL_BASE_PATH)
@Tag(name = "ClienteRest", description = "Permite gestionar los productos de la empresa.")
public class MaterialRest {

    @Autowired
    private MaterialService materialService;

//CREAR PRODUCTO Y SU UNIDAD ASOCIADA

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

//ACTUALIZAR Y CONSULTAR INFORMACION

    @PutMapping(path = "/modificar")
    @Operation(summary = "Actualiza un material.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "material actualizado"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
            @ApiResponse(responseCode = "404", description = "material inexistente") })
    public ResponseEntity<?> actualizar(@Parameter(description = "material a actualizar") @RequestBody Material material,
                                        @RequestParam(name = "id") Long id)
    {
            return ResponseEntity.ok(materialService.actualizarMaterial(material, id));
    }

//CONSULTAR POR NOMBRE, RANGO DE STOCK, PRECIO

    @GetMapping(path = "/nombre")
    @Operation(summary = "Retorna los un material por nombre")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "material recuperado"),
            @ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
            @ApiResponse(responseCode = "404", description = "material inexistente") })
    public ResponseEntity<Material> obtenerPorNombre(@RequestParam(name = "nombre") String nombre)
    {
            return ResponseEntity.ok(materialService.obtenerMaterialPorNombre(nombre));
    }

    @GetMapping(path = "/rangostock")
    @Operation(summary = "Retorna los materiales en cierto rango de stock")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "materiales recuperado"),
            @ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
            @ApiResponse(responseCode = "404", description = "materiales inexistente") })
    public ResponseEntity<?> obtenerPorNombre(@RequestParam(name= "minimo") BigDecimal min, @RequestParam(name = "maximo") BigDecimal max)
    {
        return ResponseEntity.ok(materialService.obtenerMaterialPorRangoStock(min, max));
    }

    @GetMapping(path = "/precio")
    @Operation(summary = "Retorna los materiales en que cuestan cierto precio")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "materiales recuperado"),
            @ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
            @ApiResponse(responseCode = "404", description = "materiales inexistente") })
    public ResponseEntity<?> obtenerPorPrecio(@Parameter(description = "precio del material") @RequestParam() BigDecimal precio)
    {
        return ResponseEntity.ok(materialService.obtenerMaterialPorPrecio(precio));
    }

}
