package com.example.ventas.api;

import com.example.ventas.entity.Detalle;
import com.example.ventas.entity.Producto;
import com.example.ventas.repository.DetalleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping(path = "detalle", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
    RequestMethod.PUT, RequestMethod.DELETE})
public class DetalleController {

    @Autowired
    DetalleRepository service;

    @GetMapping
    public List<Detalle> detalleSel() {
        return service.findAll();
    }
    
    @GetMapping(value = "/get")
    public Producto detalleGet() {
        return service.findById(1).orElseThrow().getProducto();
    }

}
