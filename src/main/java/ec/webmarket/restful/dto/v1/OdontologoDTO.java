package ec.webmarket.restful.dto.v1;

import lombok.Data;

@Data
public class OdontologoDTO {

    private Long id_odontologo;
    private Long cedula;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;
}

