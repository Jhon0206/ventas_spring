package com.example.ventas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
    @Column(unique = true)
    @Pattern(regexp = "\\d{8}", message = "Sólo 8 dígitos")    
    protected String dni;
    
    @Column 
    @NotBlank(message = "Ingrese un nombre")
    @Size(min = 2,max = 50,message = "El tamaño debe estar entre 2 y 50")
    protected String nombres;
    
    @Column(unique = true)
    @Email(message = "Ingrese un correo válido")
    protected String correo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nID=").append(id);
        sb.append("\nDni=").append(dni);
        sb.append("\nNombres=").append(nombres);
        sb.append("\nCorreo=").append(correo);
        sb.append("\n");
        return sb.toString();
    }   
    
}
