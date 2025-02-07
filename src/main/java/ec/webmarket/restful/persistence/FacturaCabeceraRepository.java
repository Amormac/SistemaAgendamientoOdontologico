package ec.webmarket.restful.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Cliente;
import ec.webmarket.restful.domain.FacturaCabecera;

public interface FacturaCabeceraRepository extends JpaRepository<FacturaCabecera, Long> {

	List<FacturaCabecera> findByCliente(Cliente cliente);
}