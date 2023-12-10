
package com.example.ventas.controller;

import com.example.ventas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("products")
public class ProductoPublicController {
    
    @Autowired
    ProductoService productoService;
    
    @GetMapping
    public String productsCatalogue(Model model,@RequestParam(defaultValue = "") String name){
        model.addAttribute("data",productoService.productoSel(name));
        return "products";
    }
    
    @GetMapping(value = "/{id}")
    public String productsDetails(Model model, @PathVariable("id") Integer id){
        model.addAttribute("product",productoService.productoGet(id));
        return "product_detail";
    }
    
    @GetMapping(value = "/cart/{id}")
    public String productsCart(Model model, @PathVariable("id") Integer id){
        model.addAttribute("product",productoService.productoGet(id));
        return "cooming_soon";
    }
    
    
}
