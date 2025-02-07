package ec.webmarket.restful.persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Paciente;

public interface ClienteRepository extends JpaRepository<Paciente, Long> {

	List<Paciente> findByNombre(String nombre);

	List<Paciente> findByFechaCreacion(LocalDate fechaCreacion);
	
	Optional<Paciente> findByCedula(Long cedula);

}
