package ec.webmarket.restful.dto.v1;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClienteDTO {
	private Long id_cliente = null;
    private Long cedula;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String direccion;
    private String correo;
    private LocalDate fechaCreacion;
}

