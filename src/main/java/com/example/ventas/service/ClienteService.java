
package com.example.ventas.service;

import com.example.ventas.entity.Cliente;
import com.example.ventas.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;
    
    public List<Cliente> clienteSel(){
        return repository.findAll();
    }
    
    public Cliente clienteGet(Integer id){
        return repository.findById(id).orElse(new Cliente());
    }
    
    public Cliente clienteInsUpd(Cliente cliente){
        return repository.save(cliente);
    }
    
    public void clienteDel(Integer id){
        repository.deleteById(id);
    }
}
