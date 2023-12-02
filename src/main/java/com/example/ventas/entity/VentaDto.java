
package com.example.ventas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;

/**
 * Clase para reresentar una vista (útil para WebService REST)
 * Opcional para Web con Thymeleaf.
 * @author jhon_
 */
@Entity
@Immutable //Para View
public class VentaDto {
    @Id
    private Integer id; 
    
    //Faltan mapear los campos de la vista "Venta_view"
}
