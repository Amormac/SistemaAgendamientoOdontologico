package ec.webmarket.restful.service.crud;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Cliente;
import ec.webmarket.restful.dto.v1.ClienteDTO;
import ec.webmarket.restful.persistence.ClienteRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class ClienteService extends GenericCrudServiceImpl<Cliente, ClienteDTO> {

	@Autowired
	private ClienteRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Cliente> find(ClienteDTO dto) {
		return repository.findById(dto.getId_cliente());
	}

	public List<Cliente> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public List<Cliente> findByFechaCreacion(LocalDate fechaCreacion) {
		return repository.findByFechaCreacion(fechaCreacion);
	}

	@Override
	public Cliente mapToDomain(ClienteDTO dto) {
		return modelMapper.map(dto, Cliente.class);
	}

	@Override
	public ClienteDTO mapToDto(Cliente domain) {
		return modelMapper.map(domain, ClienteDTO.class);
	}

}