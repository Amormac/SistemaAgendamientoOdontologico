package ec.webmarket.restful.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FacturaCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id_factura;
    
    @Column(unique = true, nullable = false)
    private String numeroFactura;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @Column(nullable = false)
    private LocalDate fechaEmision;
    
    @Column(length = 20, nullable = false)
    private String estado;
    
    @Column(length = 255, nullable = true)
    private String observaciones;

}
