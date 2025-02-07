package ec.webmarket.restful.dto.v1;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductoDTO {
	    private Long id_producto = null;
	    private String codigo;
	    private String nombre;
	    private String descripcion;
	    private BigDecimal precioUnitario;
	    private Integer stock;
	    private String unidadMedida;
	    private LocalDate fechaCreacion;
}

