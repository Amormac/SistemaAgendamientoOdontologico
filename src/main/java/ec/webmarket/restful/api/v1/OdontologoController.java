package ec.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.webmarket.restful.common.ApiConstants;
import ec.webmarket.restful.dto.v1.OdontologoDTO;
import ec.webmarket.restful.security.ApiResponseDTO;
import ec.webmarket.restful.service.crud.OdontologoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { ApiConstants.URI_API_V1_PRODUCTO })
public class OdontologoController {

	@Autowired
	private OdontologoService entityService;

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody OdontologoDTO dto) {
	    try {
	        OdontologoDTO createdDto = entityService.create(dto);
	        return new ResponseEntity<>(new ApiResponseDTO<>(true, createdDto), HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(new ApiResponseDTO<>(false, "Error al crear el Odontologo: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@GetMapping
	public ResponseEntity<?> getById(@Valid @RequestBody OdontologoDTO dto) {
	    if (dto.getCedula() == null) {
	        return new ResponseEntity<>(new ApiResponseDTO<>(false, "La cedula no debe ser nulo"), HttpStatus.BAD_REQUEST);
	    }
	    else if(dto.getNombre()== null) {
	    	return new ResponseEntity<>(new ApiResponseDTO<>(false, "El nombre no debe ser nulo"), HttpStatus.BAD_REQUEST);
	    	
	    }
	    else if(dto.getApellido()== null) {
	    	return new ResponseEntity<>(new ApiResponseDTO<>(false, "El apellido no debe ser nulo"), HttpStatus.BAD_REQUEST);
	    	
	    }
	    
	    return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.consultarCitas(dto)), HttpStatus.OK);
	}
	 
	
	

}