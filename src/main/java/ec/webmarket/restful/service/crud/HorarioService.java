package ec.webmarket.restful.service.crud;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Horario;
import ec.webmarket.restful.dto.v1.HorarioDTO;
import ec.webmarket.restful.persistence.HorarioRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class HorarioService extends GenericCrudServiceImpl<Horario, HorarioDTO> {

	@Autowired
	private HorarioRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Horario> find(HorarioDTO dto) {
		return repository.findById(dto.getId_horario());
	}

	public List<Horario> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public List<Horario> findByFechaCreacion(LocalDate fechaCreacion) {
		return repository.findByFechaCreacion(fechaCreacion);
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