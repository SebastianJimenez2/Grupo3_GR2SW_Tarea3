package com.example.tarea3;

import com.example.tarea3.model.JuguetesEntity;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.List;

public class Comprobante {
    public void generarComprobanteVenta(int nuevaCantidad, BigDecimal precio, Model model) {
        model.addAttribute("nuevaCantidad", nuevaCantidad);
        model.addAttribute("precioUnitario", precio);
    }
}
