
package com.example.ventas.repository;

import com.example.ventas.entity.VentaDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface VentaViewRepository extends Repository<VentaDto, Integer>{
    
    List<VentaDto> findAll();
    Optional<VentaDto> findById(Integer id);
    long count();
    
}
