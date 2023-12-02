
package com.example.ventas.repository;

import com.example.ventas.entity.Categoria;
import com.example.ventas.entity.Producto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    /*
    @Query(value = "SELECT * FROM producto WHERE categoria = ?1",nativeQuery = true)
    List<Producto> buscarCategoria(Integer cat);
        
    @Query("FROM Producto p WHERE p.categoria = :cat")
    List<Producto> buscarCategoriaJPQL(@Param("cat") Integer cat);
    */
   // List<Producto> findByCategoria(Categoria categoria);
    
    
}
