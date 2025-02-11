package ec.webmarket.restful.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Cita;
import ec.webmarket.restful.dto.v1.OdontologoDTO;
public interface OdontologoRepository extends JpaRepository<Cita, Long>
{
	public List<Cita> consultarCitas(OdontologoDTO odontologo);

}
