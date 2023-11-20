package com.example.tarea3;

import com.example.tarea3.model.JuguetesEntity;
import org.springframework.ui.Model;

public class Comprobante {
    public void generarComprobante(JuguetesEntity juguete, Model model) {
        model.addAttribute("IDJuguete", juguete.getId());
        model.addAttribute("Precio", juguete.getPrecio());
        model.addAttribute("Cantidad", juguete.getCantidad());
    }
}
