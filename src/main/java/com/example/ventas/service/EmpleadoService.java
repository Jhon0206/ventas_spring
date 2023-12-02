package com.example.ventas.service;

import com.example.ventas.entity.Empleado;
import com.example.ventas.repository.EmpleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository repository;

    public List<Empleado> empleadoSel() {
        return repository.findAll();
    }

    public Empleado empleadoGet(Integer id) {
        return repository.findById(id).orElse(new Empleado());
    }

    public Empleado empleadoLogIn(String correo, String clave) {
        return repository.loginEmpleado(correo, clave);
    }

    public Empleado empleadoInsUpd(Empleado empleado) {
        return repository.save(empleado);
    }

    public void empleadoDel(Integer id) {
        repository.deleteById(id);
    }
}
