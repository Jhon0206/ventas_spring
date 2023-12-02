/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ventas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "venta")
public class Venta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente Cliente;
        
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    
    @Column(name = "monto")
    private Float monto;
    
    @Column(name = "fecha")
    @PastOrPresent
    private LocalDateTime fecha;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<Detalle> detalles;

    public Venta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta{");
        sb.append("id=").append(id);
        sb.append(", Cliente=").append(Cliente);
        sb.append(", empleado=").append(empleado);
        sb.append(", monto=").append(monto);
        sb.append(", fecha=").append(fecha);
        sb.append("\nElementos=").append(detalles.size());
        sb.append('}');
        return sb.toString();
    }


}
