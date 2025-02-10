package ec.webmarket.restful.persistence;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.webmarket.restful.domain.Odontologo;
import ec.webmarket.restful.dto.v1.OdontologoDTO;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
	
	public Optional<Odontologo> find(OdontologoDTO dto);
	
	public List<Odontologo> findByNombre(String nombre);

	public List<Odontologo> findByFechaCreacion(LocalDate fechaCreacion);



}
