package ec.webmarket.restful.api.v1;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.webmarket.restful.common.ApiConstants;
import ec.webmarket.restful.domain.Producto;
import ec.webmarket.restful.dto.v1.ProductoDTO;
import ec.webmarket.restful.security.ApiResponseDTO;
import ec.webmarket.restful.service.crud.ProductoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { ApiConstants.URI_API_V1_PRODUCTO })
public class ProductoController {

	@Autowired
	private ProductoService entityService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findAll(new ProductoDTO())), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody ProductoDTO dto) {
	    try {
	        ProductoDTO createdDto = entityService.create(dto);
	        return new ResponseEntity<>(new ApiResponseDTO<>(true, createdDto), HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(new ApiResponseDTO<>(false, "Error al crear el producto: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody ProductoDTO dto) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.update(dto)), HttpStatus.OK);
	}

	@GetMapping("/{id}/archivo/id")
	public ResponseEntity<?> getById(@Valid @PathVariable Long id) {
	    if (id == null) {
	        return new ResponseEntity<>(new ApiResponseDTO<>(false, "El ID no debe ser nulo"), HttpStatus.BAD_REQUEST);
	    }
	    ProductoDTO dto = new ProductoDTO();
	    dto.setId_producto(id);
	    return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.find(dto)), HttpStatus.OK);
	}

	 @GetMapping("/{codigo}/archivo/codigo")
	    public ResponseEntity<?> getProductoByCodigo(@PathVariable String codigo) {
	        Producto productos = entityService.findByCodigo(codigo);
	        return new ResponseEntity<>(productos, HttpStatus.OK);
	    }
	 
	
	@GetMapping("/{fechaCreacion}/archivo/fecha-creacion")
	public ResponseEntity<?> getProductoByFechaCreacion(@PathVariable String fechaCreacion) {
		LocalDate fecha = LocalDate.parse(fechaCreacion); // return
		entityService.findByFechaCreacion(fecha);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findByFechaCreacion(fecha)),
				HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{id}/archivo/id")
	public ResponseEntity<?> deleteById(@Valid @PathVariable Long id) {
	   ProductoDTO dto = new ProductoDTO();
	    dto.setId_producto(id);
	    // Llamar al servicio para eliminar el producto
	    entityService.delete(dto);
	    return new ResponseEntity<>(new ApiResponseDTO<Void>(true, null), HttpStatus.NO_CONTENT);
	}

}