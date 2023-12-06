package com.example.ventas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.sql.Blob;

@Entity
public class Empleado extends Persona{
   
    @Column   
    @NotBlank(message = "Ingrese un apellido paterno")
    @Size(min = 2,max = 50,message = "El tamaño debe estar entre 2 y 50")    
    private String paterno;
    
    @Column   
    @NotBlank(message = "Ingrese un apellido materno")
    @Size(min = 2,max = 50,message = "El tamaño debe estar entre 2 y 50")    
    private String materno;
    
    @Column    
    @Pattern(regexp = "^[\\s]*$|^[0-9]+$", message = "Sólo números")
    private String telefono;
    
    @Column
    private String clave;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {        
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\npaterno: ").append(paterno);
        sb.append("\nmaterno: ").append(materno);
        sb.append("\ntelefono: ").append(telefono);
        return sb.toString();
    }
    
    
}
