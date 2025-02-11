package ec.webmarket.restful.dto.v1;

import java.time.LocalDate;
import java.time.LocalTime;

import ec.webmarket.restful.domain.Odontologo;
import lombok.Data;

@Data
public class HorarioDTO {
    private Long id_horario;
    private Odontologo odontologo;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean disponible;
}

