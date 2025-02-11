package ec.webmarket.restful.persistence;


import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Horario;
import ec.webmarket.restful.dto.v1.OdontologoDTO;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

	public List<Horario> findByOdontologo(OdontologoDTO dto);
	
	public List<Horario> findByFecha(LocalDate fecha);
}
