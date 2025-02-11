package ec.webmarket.restful.service.crud;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Cita;
import ec.webmarket.restful.domain.Odontologo;
import ec.webmarket.restful.dto.v1.OdontologoDTO;

import ec.webmarket.restful.persistence.OdontologoRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class OdontologoService extends GenericCrudServiceImpl<Odontologo, OdontologoDTO> {

	@Autowired
	private OdontologoRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	public List<Cita> consultarCitas(OdontologoDTO odontologo){
		return repository.consultarCitas(odontologo);
	}
	
	@Override
	public Optional<Odontologo> find(OdontologoDTO dto) {
	    throw new UnsupportedOperationException("El método find(OdontologoDTO) no está soportado en esta implementación.");
	}

	@Override
	public Odontologo mapToDomain(OdontologoDTO dto) {
		return modelMapper.map(dto, Odontologo.class);
	}

	@Override
	public OdontologoDTO mapToDto(Odontologo domain) {
		return modelMapper.map(domain, OdontologoDTO.class);
	}

}