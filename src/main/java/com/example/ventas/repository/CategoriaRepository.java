package com.example.ventas.repository;

import com.example.ventas.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
