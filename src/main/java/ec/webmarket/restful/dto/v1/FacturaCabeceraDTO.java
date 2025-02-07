package ec.webmarket.restful.dto.v1;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FacturaCabeceraDTO {
    private Long id_factura = null;
    private String numeroFactura;
    private ClienteDTO cliente; 
    private LocalDate fechaEmision;
    private String estado;
    private String observaciones;
}
