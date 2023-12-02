package com.example.ventas.controller;

import com.example.ventas.entity.Empleado;
import com.example.ventas.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @GetMapping("sign_in")
    public String toSignIn(Model model) {
        model.addAttribute("user", "");
        model.addAttribute("pass", "");
            model.addAttribute("error", null);
        return "sign_in";
    }

    @GetMapping("sign_up")
    public String toSignUp(Model model) {
        model.addAttribute("user", "");
        model.addAttribute("pass", "");
        return "sign_up";

    }

    @PostMapping("sign_in")
    public String logIn(Model model, String user, String pass) {
        try {
            Empleado empl = service.empleadoLogIn(user, pass);
            if (empl != null) {
                //Guardar sesión PROXIMAMENTE
                return "intranet";
            } else {
                model.addAttribute("user", user);
                model.addAttribute("error", "Datos incorrectos");
                return "sign_in";
            }
        } catch (Exception ex) {
            model.addAttribute("user", user);
            model.addAttribute("error", ex.getMessage());
            return "sign_in";
        }
    }

    @PostMapping("sign_up")
    public String register(Model model, String user, String pass) {
        System.out.println(user + " " + pass);
        return "sign_in";

    }
}
