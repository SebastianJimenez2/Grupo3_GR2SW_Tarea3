package com.example.tarea3;

import com.example.tarea3.model.JuguetesEntity;
import com.example.tarea3.repository.AdministradorRepository;
import com.example.tarea3.model.AdministradoresEntity;
import com.example.tarea3.repository.JugueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class Sistema {
    private final AdministradorRepository administradorRepository;
    private final EntityManager entityManager;

    @Autowired
    private JugueteRepository jugueteRepository;

    @Autowired
    public Sistema(AdministradorRepository administradorRepository, EntityManager entityManager) {
        this.administradorRepository = administradorRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("administrador", new AdministradoresEntity());
        return "Login";
    }

    @PostMapping("/registrar-juguete")
    public String registrarJuguete(@RequestParam int IDJuguete, @RequestParam BigDecimal PrecioJuguete, @RequestParam int Cantidad, Model model) {
        if (existeJuguete(IDJuguete)) {
            model.addAttribute("error2", true);
        } else {
            JuguetesEntity juguete = new JuguetesEntity();
            juguete.setId(IDJuguete);
            juguete.setPrecio(PrecioJuguete);
            juguete.setCantidad(Cantidad);
            jugueteRepository.save(juguete);
            model.addAttribute("error2", false);
        }
        return "GestionJuguete";
    }

    public boolean existeJuguete(int IDJuguete) {
        TypedQuery<Integer> query = entityManager.createQuery("SELECT a.id FROM JuguetesEntity a", Integer.class);
        List<Integer> idsJuguetes = query.getResultList();

        return idsJuguetes.contains(IDJuguete);
    }

    public void generarComprobante() {

    }

    @PostMapping("/verificarCredenciales")
    public String verificarCredenciales(String usuario, String password, Model model) {
        AdministradoresEntity usuarioObtenidoDeLaBDD = obtenerUsuarioDeLaBDD(usuario);
        boolean contraseniaCoincideConUsuarioIngresado = usuarioObtenidoDeLaBDD.getContrasenia().trim().equals(password);

        if (usuarioObtenidoDeLaBDD == null || !contraseniaCoincideConUsuarioIngresado) {
            model.addAttribute("error", true);
            return "Login";
        }
        return "GestionJuguete";
    }

    private AdministradoresEntity obtenerUsuarioDeLaBDD(String usuario) {
        TypedQuery<AdministradoresEntity> query = entityManager.createQuery("SELECT a FROM AdministradoresEntity a WHERE a.usuario = :usuario", AdministradoresEntity.class);
        query.setParameter("usuario", usuario);

        return query.getSingleResult();
    }
}