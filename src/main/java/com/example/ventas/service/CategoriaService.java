
package com.example.ventas.service;

import com.example.ventas.entity.Categoria;
import com.example.ventas.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository repository;
    
    public List<Categoria> categoriaSel(){
        return repository.findAll();
    }
    
    public Categoria categoriaGet(Integer id){
        return repository.findById(id).orElse(new Categoria());
    }
    
    public Categoria categoriaInsUpd(Categoria categoria){
        return repository.save(categoria);
    }
    
    public void categoriaDel(Integer id){
        repository.deleteById(id);
    }
}
