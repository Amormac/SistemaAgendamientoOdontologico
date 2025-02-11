package ec.webmarket.restful.service.crud;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Horario;
import ec.webmarket.restful.dto.v1.HorarioDTO;
import ec.webmarket.restful.dto.v1.OdontologoDTO;
import ec.webmarket.restful.persistence.HorarioRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class HorarioService extends GenericCrudServiceImpl<Horario, HorarioDTO> {

	@Autowired
	private HorarioRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Horario> find(HorarioDTO dto) {
	    throw new UnsupportedOperationException("El método find(OdontologoDTO) no está soportado en esta implementación.");
	}
	
	public List<Horario> findByOdontologo(OdontologoDTO dto){
		return repository.findByOdontologo(dto);
		
	}

	public List<Horario> findByFecha(LocalDate fecha){
		return repository.findByFecha(fecha);
	}


	@Override
	public Horario mapToDomain(HorarioDTO dto) {
		return modelMapper.map(dto, Horario.class);
	}

	@Override
	public HorarioDTO mapToDto(Horario domain) {
		return modelMapper.map(domain, HorarioDTO.class);
	}
}