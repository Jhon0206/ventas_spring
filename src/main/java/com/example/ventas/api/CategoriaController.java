package com.example.ventas.api;

import com.example.ventas.entity.Categoria;
import com.example.ventas.service.CategoriaService;
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
@RequestMapping(path = "categoria", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
    RequestMethod.PUT, RequestMethod.DELETE})
public class CategoriaController {

    @Autowired
    CategoriaService service;

//    @GetMapping
//    public List<Categoria> categoriaSel(@PageableDefault Pageable pageable) {
//        return service.categoriaSel(pageable);
//    }

    @GetMapping(value = "/{id}")
    public Categoria categoriaGet(@PathVariable("id") Integer id) {
        return service.categoriaGet(id);
    }

    @PostMapping(consumes = "application/json")
    public Categoria categoriaIns(@RequestBody Categoria categoria) {
        return service.categoriaInsUpd(categoria);
    }

    @PutMapping(consumes = "application/json")
    public Categoria categoriaUpd(@RequestBody Categoria categoria) {
        return service.categoriaInsUpd(categoria);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void categoriaDel(@PathVariable("id") Integer id) {
        service.categoriaDel(id);
    }
}
