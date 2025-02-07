package ec.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.webmarket.restful.common.ApiConstants;
import ec.webmarket.restful.dto.v1.FacturaCabeceraDTO;
import ec.webmarket.restful.security.ApiResponseDTO;
import ec.webmarket.restful.service.crud.FacturaCabeceraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { ApiConstants.URI_API_V1_FACTURA_CABECERA })
public class FacturaCabeceraController {

	@Autowired
	private FacturaCabeceraService entityService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findAll(new FacturaCabeceraDTO())),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody FacturaCabeceraDTO dto) {
	    try {
	        FacturaCabeceraDTO createdDto = entityService.create(dto);
	        return new ResponseEntity<>(new ApiResponseDTO<>(true, createdDto), HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(new ApiResponseDTO<>(false, "Error al crear el la factura: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody FacturaCabeceraDTO dto) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.update(dto)), HttpStatus.OK);
	}

	@GetMapping("/{id}/archivo/id")
	public ResponseEntity<?> getById(@Valid @PathVariable Long id) {
		FacturaCabeceraDTO dto = new FacturaCabeceraDTO();
		dto.setId_factura(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.find(dto)), HttpStatus.OK);
	}

	@GetMapping("/{paisId}/archivo/pais")
	public ResponseEntity<?> getProvinciasByPais(@PathVariable Long paisId) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findByCliente(paisId)), HttpStatus.OK);
	}
	
}