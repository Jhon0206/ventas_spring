package com.example.ventas.api;

import com.example.ventas.entity.Categoria;
import com.example.ventas.entity.Producto;
import com.example.ventas.service.CategoriaService;
import com.example.ventas.service.ProductoService;
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
@RequestMapping(path = "api-producto", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
      RequestMethod.PUT, RequestMethod.DELETE})
public class RestProductoController {

    @Autowired
    ProductoService service;
    @Autowired
    CategoriaService serviceCat;

    @GetMapping
    public List<Producto> productoSel() {
        return service.productoSel(null);
    }

//    @GetMapping(value = "/categoria/{id}")
//    public List<Producto> buscarCategoria(@PathVariable("id") Integer id) {
//        Categoria cat = serviceCat.categoriaGet(id);
//        return service.findByCategoria(cat);
//    }
    
    @GetMapping(value = "/{id}")
    public Producto productoGet(@PathVariable("id") Integer id) {
        return service.productoGet(id);
    }

    @PostMapping(consumes = "application/json")
    public Producto productoIns(@RequestBody Producto producto) {
        return service.productoInsUpd(producto);
    }

    @PutMapping(consumes = "application/json")
    public Producto productoUpd(@RequestBody Producto producto) {
        return service.productoInsUpd(producto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void productoDel(@PathVariable("id") Integer id) {
        service.productoDel(id);
    }
}
