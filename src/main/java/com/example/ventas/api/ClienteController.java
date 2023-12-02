package com.example.ventas.api;

import com.example.ventas.entity.Cliente;
import com.example.ventas.service.ClienteService;
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
@RequestMapping(path = "cliente", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
      RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public List<Cliente> clienteSel() {
        return service.clienteSel();
    }

    @GetMapping(value = "/{id}")
    public Cliente clienteGet(@PathVariable("id") Integer id) {
        return service.clienteGet(id);
    }

    @PostMapping(consumes = "application/json")
    public Cliente clienteIns(@RequestBody Cliente cliente) {
        return service.clienteInsUpd(cliente);
    }

    @PutMapping(consumes = "application/json")
    public Cliente clienteUpd(@RequestBody Cliente cliente) {
        return service.clienteInsUpd(cliente);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void clienteDel(@PathVariable("id") Integer id) {
        service.clienteDel(id);
    }
}
