package com.example.tarea3;

import com.example.tarea3.model.JuguetesEntity;
import com.example.tarea3.repository.AdministradorRepository;
import com.example.tarea3.model.AdministradoresEntity;
import com.example.tarea3.repository.JugueteRepository;
import jakarta.persistence.NoResultException;
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

@Controller
public class Sistema {
    private final AdministradorRepository administradorRepository;
    private final EntityManager entityManager;

    @Autowired
    public JugueteRepository jugueteRepository;

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

    @PostMapping("/aniadir-admin")
    public String añadirAdministrador(@RequestParam String nombre,
                                      @RequestParam String apellido,
                                      @RequestParam String usuario,
                                      @RequestParam String contrasena,
                                      @RequestParam String confirmarContrasena,
                                      Model model) {
        if (camposEstánVacios(nombre, apellido, usuario, contrasena, confirmarContrasena)) {
            model.addAttribute("errorCamposVacios", true);
            return "Registrarse";
        }

        if (verificarUsuariosExistentes(usuario)) {
            model.addAttribute("errorUsuarioRepetido", true);
            return "Registrarse";
        }

        if (!contrasena.equals(confirmarContrasena)) {
            model.addAttribute("errorContrasenasDiferentes", true);
            return "Registrarse";
        }

        AdministradoresEntity administradores = new AdministradoresEntity();

        administradores.setUsuario(usuario);
        administradores.setNombre(nombre);
        administradores.setApellido(apellido);
        administradores.setContrasenia(contrasena);

        administradorRepository.save(administradores);

        return "Login";
    }

    private boolean camposEstánVacios(String... campos) {
        for (String campo : campos) {
            if (campo.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarUsuariosExistentes(String usuarioEnviado) {
        TypedQuery<String> query = entityManager.createQuery("SELECT a.usuario FROM AdministradoresEntity a", String.class);
        List<String> usuarios = query.getResultList();

        for (String usuario : usuarios) {
            if (usuario.trim().equals(usuarioEnviado)) {
                return true;
            }
        }
        return false;
    }

    @PostMapping("/registrar-juguete")
    public String registrarJuguete(@RequestParam int IDJuguete, @RequestParam BigDecimal PrecioJuguete, @RequestParam int Cantidad, Model model) {
        if (existeJuguete(IDJuguete)) {
            model.addAttribute("error2", true);
            return "GestionJuguete";
        } else {
            JuguetesEntity juguete = new JuguetesEntity();
            juguete.setId(IDJuguete);
            juguete.setPrecio(PrecioJuguete);
            juguete.setCantidad(Cantidad);
            jugueteRepository.save(juguete);
            model.addAttribute("error2", false);

            return generacionDeComprobanteDeJugueteRegistrado(model, juguete);
        }
    }

    private String generacionDeComprobanteDeJugueteRegistrado(Model model, JuguetesEntity juguete) {
        //Comprobante comprobante = new Comprobante();
        //comprobante.generarComprobante(juguete, model);
        return "Comprobante";
    }

    public boolean existeJuguete(int IDJuguete) {
        TypedQuery<Integer> query = entityManager.createQuery("SELECT a.id FROM JuguetesEntity a", Integer.class);
        List<Integer> idsJuguetes = query.getResultList();

        return idsJuguetes.contains(IDJuguete);
    }

    @PostMapping("/verificarCredenciales")
    public String verificarCredenciales(String usuario, String password, Model model) {
        AdministradoresEntity usuarioObtenidoDeLaBDD = obtenerUsuarioDeLaBDD(usuario);
        if (usuarioObtenidoDeLaBDD != null) {
            boolean contraseniaCoincideConUsuarioIngresado = password.equals(usuarioObtenidoDeLaBDD.getContrasenia().trim());

            if (!contraseniaCoincideConUsuarioIngresado) {
                model.addAttribute("error", true);
                return "Login";
            } else {
                return "OpcionesDeAdministrador";
            }
        } else {
            model.addAttribute("error", true);
            return "Login";
        }
    }

    public AdministradoresEntity obtenerUsuarioDeLaBDD(String usuario) {
        try {
            TypedQuery<AdministradoresEntity> query = entityManager.createQuery("SELECT a FROM AdministradoresEntity a WHERE a.usuario = :usuario", AdministradoresEntity.class);
            query.setParameter("usuario", usuario);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Devuelve null cuando no se encuentra ningún usuario
        }
    }

    @PostMapping("/vender-juguete")
    public String venderJuguete(@RequestParam int IDJuguete, @RequestParam int cantidad, Model model) {
        int index = 0;
        boolean elJugueteExiste = existeJuguete(IDJuguete);

        if (elJugueteExiste) {
            TypedQuery<JuguetesEntity> query = entityManager.createQuery("SELECT a FROM JuguetesEntity a", JuguetesEntity.class);
            List<JuguetesEntity> contenidoTabla = query.getResultList();

            for (int i = 0; i < contenidoTabla.size(); i++) {
                if (contenidoTabla.get(i).getId().equals(IDJuguete)) {
                    index = i;
                }
            }

            if (contenidoTabla.get(index).getCantidad() <= cantidad) {
                model.addAttribute("errorCantidadInsuficiente", true);
                return "VentaJuguete";
            }

            int nuevaCantidad = contenidoTabla.get(index).getCantidad() - cantidad;
            contenidoTabla.get(index).setCantidad(nuevaCantidad);
            jugueteRepository.save(contenidoTabla.get(index));

            Comprobante comprobante = new Comprobante();
            comprobante.generarComprobanteVenta(nuevaCantidad, contenidoTabla.get(index).getPrecio(), model);
            return "ComprobanteDeVenta";
        }

        model.addAttribute("errorJugueteNoExiste", true);
        return "VentaJuguete";
    }

    @PostMapping("/stock")
    public String generarInformeCantidadProductos(Model model) {
        List<JuguetesEntity> listaJuguetes = entityManager.createQuery("SELECT j FROM JuguetesEntity j", JuguetesEntity.class).getResultList();
        model.addAttribute("juguetesList", listaJuguetes);

        return "ReporteJuguetes";
    }
}