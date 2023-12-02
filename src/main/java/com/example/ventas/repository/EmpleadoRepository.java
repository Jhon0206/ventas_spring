package com.example.ventas.repository;

import com.example.ventas.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

    @Query("FROM Empleado e WHERE e.correo = :correo AND AES_DECRYPT(e.clave, :clave) = :clave")
    Empleado loginEmpleado(@Param("correo") String dni,@Param("clave") String clave);
}
