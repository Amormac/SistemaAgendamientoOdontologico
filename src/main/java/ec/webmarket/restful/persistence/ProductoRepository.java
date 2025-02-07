package ec.webmarket.restful.persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByNombre(String nombre);

	List<Producto> findByFechaCreacion(LocalDate fechaCreacion);
	
	Optional <Producto> findByCodigo(Producto producto);

}
