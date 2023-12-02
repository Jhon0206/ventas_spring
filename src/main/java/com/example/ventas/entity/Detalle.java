package com.example.ventas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
public class Detalle{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    
    @Column(name = "precio")
    @PositiveOrZero(message = "El precio no debe ser negativo")
    private Float precio;
    
    @Column(name = "cantidad")
    @PositiveOrZero(message = "La cantidad no debe ser negativa")
    private Integer cantidad;
    
    @JoinColumn(name = "producto", referencedColumnName = "id")
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    
    @JoinColumn(name = "venta", referencedColumnName = "id")
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venta venta;

    public Detalle() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalle{");
        sb.append("id=").append(id);
        sb.append(", precio=").append(precio);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", producto=").append(producto.getNombre());
        //sb.append(", venta=").append(venta.getId());
        sb.append('}');
        return sb.toString();
    }
    
}
