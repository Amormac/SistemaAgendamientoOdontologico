package ec.webmarket.restful.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(updatable = false, nullable = false)
	    private Long id_producto;
	    
	    @Column(unique = true, nullable = false, length = 50)
	    private String codigo;
	    
	    @Column(nullable = false, length = 100)
	    private String nombre;
	    
	    @Column(nullable = true, length = 255)
	    private String descripcion;
	    
	    @Column(nullable = false, precision = 10, scale = 2)
	    private BigDecimal precioUnitario;
	    
	    @Column(nullable = false)
	    private Integer stock;
	    
	    @Column(nullable = false, length = 20)
	    private String unidadMedida;
	    
	    @Column(nullable = false)
	    private LocalDate fechaCreacion;
}
