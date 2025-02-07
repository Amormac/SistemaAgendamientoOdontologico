package ec.webmarket.restful.service.crud;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Cliente;
import ec.webmarket.restful.domain.FacturaCabecera;
import ec.webmarket.restful.dto.v1.FacturaCabeceraDTO;
import ec.webmarket.restful.persistence.FacturaCabeceraRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class FacturaCabeceraService extends GenericCrudServiceImpl<FacturaCabecera, FacturaCabeceraDTO> {

	@Autowired
	private FacturaCabeceraRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<FacturaCabecera> find(FacturaCabeceraDTO dto) {
		return repository.findById(dto.getId_factura());
	}

	public List<FacturaCabecera> findByCliente(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId_cliente(id);
		return repository.findByCliente(cliente);
	}

	@Override
	public FacturaCabecera mapToDomain(FacturaCabeceraDTO dto) {
		return modelMapper.map(dto, FacturaCabecera.class);
	}

	@Override
	public FacturaCabeceraDTO mapToDto(FacturaCabecera domain) {
		return modelMapper.map(domain, FacturaCabeceraDTO.class);
	}

}