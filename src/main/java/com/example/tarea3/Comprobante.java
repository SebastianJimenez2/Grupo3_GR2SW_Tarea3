package com.example.tarea3;

import com.example.tarea3.model.JuguetesEntity;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.List;

public class Comprobante {
    public void generarComprobante(JuguetesEntity juguete, Model model) {
        model.addAttribute("IDJuguete", juguete.getId());
        model.addAttribute("Precio", juguete.getPrecio());
        model.addAttribute("Cantidad", juguete.getCantidad());
    }

    public void generarComprobanteVenta(int nuevaCantidad, BigDecimal precio, Model model) {
        model.addAttribute("nuevaCantidad", nuevaCantidad);
        model.addAttribute("precioUnitario", precio);
    }
}
