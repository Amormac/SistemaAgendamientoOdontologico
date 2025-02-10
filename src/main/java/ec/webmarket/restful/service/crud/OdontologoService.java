package ec.webmarket.restful.service.crud;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Horario;
import ec.webmarket.restful.dto.v1.OdontologoDTO;

import ec.webmarket.restful.persistence.OdontologoRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class OdontologoService extends GenericCrudServiceImpl<Horario, OdontologoDTO> {

	@Autowired
	private OdontologoRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Horario> find(OdontologoDTO dto) {
		return repository.findById(dto.getId_producto());
	}

	public List<Horario> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public List<Horario> findByFechaCreacion(LocalDate fechaCreacion) {
		return repository.findByFechaCreacion(fechaCreacion);
	}

	@Override
	public Horario mapToDomain(OdontologoDTO dto) {
		return modelMapper.map(dto, Horario.class);
	}

	@Override
	public OdontologoDTO mapToDto(Horario domain) {
		return modelMapper.map(domain, OdontologoDTO.class);
	}
	
    public Horario findByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

}