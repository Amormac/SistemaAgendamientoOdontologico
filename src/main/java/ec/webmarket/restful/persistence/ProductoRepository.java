package ec.webmarket.restful.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Horario;

public interface ProductoRepository extends JpaRepository<Horario, Long> {

	List<Horario> findByNombre(String nombre);

	List<Horario> findByFechaCreacion(LocalDate fechaCreacion);
	
    Horario findByCodigo(String codigo);

}
