package com.example.tarea3.controller;

import com.example.tarea3.Sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministradorController {

    private final Sistema sistema;

    @Autowired
    public AdministradorController(Sistema sistema) {
        this.sistema = sistema;
    }

    @PostMapping("/login")
    public void identificarse(@RequestParam String username, @RequestParam String password) {
        sistema.verificarCredenciales(username, password);
    }
}