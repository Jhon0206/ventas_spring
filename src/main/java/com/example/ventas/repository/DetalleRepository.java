package com.example.ventas.repository;

import com.example.ventas.entity.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle, Integer>{
    
}
