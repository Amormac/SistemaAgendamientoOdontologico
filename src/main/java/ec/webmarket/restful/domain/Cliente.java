package ec.webmarket.restful.domain;

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
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id_cliente;
    
    @Column(updatable = true, nullable = false, unique = true)
    private Long cedula;
    
    @Column(length = 50, nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private LocalDate fechaNacimiento;
    
    @Column(updatable = true, nullable = true, unique = false)
    private String telefono;
    
    @Column(length = 100, nullable = true)
    private String direccion;
    
    @Column(length = 255, nullable = true) 
    private String correo;
    
    @Column(nullable = false)
    private LocalDate fechaCreacion;
}
