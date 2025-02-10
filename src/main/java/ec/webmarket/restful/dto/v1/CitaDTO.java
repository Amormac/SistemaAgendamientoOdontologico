package ec.webmarket.restful.dto.v1;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitaDTO {
    private Long id_cita = null;
    private Long pacienteId;
    private Long odontologoId;
    private Long horarioId;
    private String fechaCita;
    private String estado;
    private String motivo;
}

