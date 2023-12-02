package com.example.ventas.controller;

import com.example.ventas.entity.Venta;
import com.example.ventas.service.ClienteService;
import com.example.ventas.service.EmpleadoService;
import com.example.ventas.service.ProductoService;
import com.example.ventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "list")
    public String ventasSel(Model model) {
        model.addAttribute("data", ventaService.ventaSel());
        return "intranet/ventas_list";
    }

    @GetMapping(value = "new")
    public String ventasNew(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("empleados", empleadoService.empleadoSel());
        model.addAttribute("clientes", clienteService.clienteSel());
        model.addAttribute("productos", productoService.productoSel());
        return "intranet/ventas_form";
    }

    @GetMapping(value = "see/{id}")
    public String productsDetails(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("product", ventaService.ventaGet(id));
        return "cooming_soon";
    }

    @PostMapping(value = "send")
    public String realizarVenta(@Validated Venta venta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("empleado", empleadoService.empleadoSel());
            model.addAttribute("cliente", clienteService.clienteSel());
            return "intranet/products_form";
        }
        try {
            ventaService.realizarVenta(venta);
            //String.format("Venta realizada con éxito: %s", HttpStatus.OK)
            return "redirect:/venta/list";
        } catch (Exception e) {
            model.addAttribute("error", String.format("Error: %s - %s", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
            return "intranet/products_form";
        }
    }

}
