package com.example.ventas.repository;

import com.example.ventas.entity.Venta;
import com.example.ventas.entity.VentaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VentaRepository extends JpaRepository<Venta, Integer>{
    
    @Query("FROM VentaDto v WHERE v.id = :id")
    VentaDto ventaVista(Integer id);

}
