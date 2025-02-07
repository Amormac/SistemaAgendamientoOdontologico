package ec.webmarket.restful.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNombre(String nombre);

	List<Cliente> findByFechaCreacion(LocalDate fechaCreacion);

}
