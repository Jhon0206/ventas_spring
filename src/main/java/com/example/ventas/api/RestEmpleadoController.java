package com.example.ventas.api;

import com.example.ventas.entity.Empleado;
import com.example.ventas.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api-empleado", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
      RequestMethod.PUT, RequestMethod.DELETE})
public class RestEmpleadoController {

    @Autowired
    EmpleadoService service;

    @GetMapping
    public List<Empleado> empleadoSel() {
        return service.empleadoSel();
    }

    @GetMapping(value = "/{id}")
    public Empleado empleadoGet(@PathVariable("id") Integer id) {
        return service.empleadoGet(id);
    }
    
    @GetMapping(value = "/login/{correo}+{clave}")
    public Empleado empleadoLogIn(@PathVariable("correo") String correo,@PathVariable("clave") String clave) {
        return service.empleadoLogIn(correo, clave);
    }

    @PostMapping(consumes = "application/json")
    public Empleado empleadoIns(@RequestBody Empleado empleado) {
        return service.empleadoInsUpd(empleado);
    }

    @PutMapping(consumes = "application/json")
    public Empleado empleadoUpd(@RequestBody Empleado empleado) {
        return service.empleadoInsUpd(empleado);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void empleadoDel(@PathVariable("id") Integer id) {
        service.empleadoDel(id);
    }
}
