package com.example.ventas.service;

import com.example.ventas.entity.Categoria;
import com.example.ventas.entity.Producto;
import com.example.ventas.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository repository;

    public List<Producto> productoSel(String name) {
        return (name == null || name.isBlank())
                ? repository.findAll()
                : repository.findByNombreContainingIgnoreCase(name);
    }

    public Page<Producto> productoPaging(int page, int size) {
        Pageable paging = PageRequest.of(page-1, size);
        return repository.findAll(paging);
    }

//    public List<Producto> findByCategoria(Categoria cat){
//        return repository.findByCategoria(cat);
//    }
    public Producto productoGet(Integer id) {
        return repository.findById(id).orElse(new Producto());
    }

    public Producto productoInsUpd(Producto producto) {
        return repository.save(producto);
    }

    public void productoDel(Integer id) {
        repository.deleteById(id);
    }
}
