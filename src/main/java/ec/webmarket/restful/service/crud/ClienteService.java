package ec.webmarket.restful.service.crud;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Paciente;
import ec.webmarket.restful.dto.v1.ClienteDTO;
import ec.webmarket.restful.persistence.ClienteRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class ClienteService extends GenericCrudServiceImpl<Paciente, ClienteDTO> {

	@Autowired
	private ClienteRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Paciente> find(ClienteDTO dto) {
		return repository.findById(dto.getId_cliente());
	}

	public List<Paciente> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public List<Paciente> findByFechaCreacion(LocalDate fechaCreacion) {
		return repository.findByFechaCreacion(fechaCreacion);
	}

	@Override
	public void delete(ClienteDTO dto) {
		repository.deleteById(dto.getId_cliente());
	}
	
	@Override
	public Paciente mapToDomain(ClienteDTO dto) {
		return modelMapper.map(dto, Paciente.class);
	}

	@Override
	public ClienteDTO mapToDto(Paciente domain) {
		return modelMapper.map(domain, ClienteDTO.class);
	}
	
	public Optional<Paciente> findByCedula(Long cedula) {
	    return repository.findByCedula(cedula);
	}

}