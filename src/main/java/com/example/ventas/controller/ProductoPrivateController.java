package com.example.ventas.controller;

import com.example.ventas.entity.Producto;
import com.example.ventas.service.CategoriaService;
import com.example.ventas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("productos")
public class ProductoPrivateController {

    @Autowired
    ProductoService productoService;
    @Autowired
    CategoriaService categoriaService;

    @GetMapping(value = "list")
    public String productsList(Model model) {
        model.addAttribute("data", productoService.productoSel());
        return "intranet/products_list";
    }

    @GetMapping(value = "new")
    public String productsNew(Model model) {
        model.addAttribute("product", new Producto());
        model.addAttribute("categories", categoriaService.categoriaSel());
        return "intranet/products_form";
    }

    @GetMapping(value = "edit/{id}")
    public String productsEdit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("product", productoService.productoGet(id));
        model.addAttribute("categories", categoriaService.categoriaSel());
        return "intranet/products_form";
    }

    @PostMapping("/save")
    public String proveedorIns(@Validated @ModelAttribute("product") Producto product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoriaService.categoriaSel());
            return "intranet/products_form";
        }
        productoService.productoInsUpd(product);
        return "redirect:/productos/list";
    }

    @GetMapping(value = "delete/{id}")
    public String productsDelete(@PathVariable("id") Integer id, Model model) {
        try {
            productoService.productoDel(id);
        } catch (Exception e) {
            model.addAttribute("error", 
                    String.format("Error: %s - %s", 
                            HttpStatus.INTERNAL_SERVER_ERROR, 
                            e.getMessage()));
            return "intranet/products_list";
        }
        return "redirect:/productos/list";
    }

}
