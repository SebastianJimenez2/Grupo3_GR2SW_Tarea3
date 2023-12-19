package com.example.tarea3;

import com.example.tarea3.model.AdministradoresEntity;
import com.example.tarea3.model.JuguetesEntity;
import com.example.tarea3.repository.AdministradorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ConcurrentModel;

import java.math.BigDecimal;

import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class SistemaTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private Sistema sistema;
    // Variables que se usan en la mayoría de test instanciadas de forma global
    ConcurrentModel model = new ConcurrentModel();
    JuguetesEntity juguetesEntity = new JuguetesEntity();

    @Test
    void testRegistrarJuguete() {
        boolean existeAntesDeRegistrar = sistema.existeJuguete(29);
        ;
        sistema.registrarJuguete(29, BigDecimal.TEN, 4, model);
        boolean existeDespuesDeRegistrar = sistema.existeJuguete(29);
        ;

        assertFalse(existeAntesDeRegistrar);
        assertTrue(existeDespuesDeRegistrar);
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testRegistrarJugueteEjecutando() {
        boolean existeAntesDeRegistrar = sistema.existeJuguete(29);
        ;
        sistema.registrarJuguete(29, BigDecimal.TEN, 4, model);
        boolean existeDespuesDeRegistrar = sistema.existeJuguete(29);
        ;

        assertFalse(existeAntesDeRegistrar);
        assertTrue(existeDespuesDeRegistrar);
    }

    @Test
    void testRegistrarJugueteVacio() {
        Integer IDJuguete = null;

        assertThrows(NullPointerException.class, () -> {
            boolean existeAntesDeRegistrar = sistema.existeJuguete(29);
            ;
            sistema.registrarJuguete(IDJuguete, BigDecimal.TEN, 4, model);
            boolean existeDespuesDeRegistrar = sistema.existeJuguete(29);
            ;

            assertFalse(existeAntesDeRegistrar);
            assertTrue(existeDespuesDeRegistrar);
        });
    }

    @Test
    public void testVerificarCredencialesUsuarioNoExiste() {
        String usuarioNoExistente = "asd";
        String password = "1234";

        String result = sistema.verificarCredenciales(usuarioNoExistente, password, model);

        assertEquals("Login", result);
        assertEquals(true, model.getAttribute("error"));
    }

    @Test
    void testVenderJuguete() {
        sistema.registrarJuguete(29, BigDecimal.TEN, 5, model);

        sistema.venderJuguete(29, 2, model);
        juguetesEntity = sistema.jugueteRepository.findById((long) 29).orElse(null);
        assertEquals(3, juguetesEntity.getCantidad());
    }

    @Test
    public void testVentaExcedeStock() {
        sistema.registrarJuguete(29, BigDecimal.TEN, 3, model);

        sistema.venderJuguete(29, 5, model);
        juguetesEntity = sistema.jugueteRepository.findById((long) 1).orElse(null);
        assertEquals(3, juguetesEntity.getCantidad());
    }

    @Test
    void testCantidadNulaVenderJuguete() {
        Integer cantidad = null;

        assertThrows(NullPointerException.class, () -> {
            sistema.venderJuguete(2, cantidad, model);
        });
    }

    @Test
    public void testRegistroYGeneracionComprobanteExitoso() {
        String resultadoRegistro = sistema.registrarJuguete(29, new BigDecimal(20), 10, model);

        assertEquals("Comprobante", resultadoRegistro);
    }

    /*-------------------------------------------------------MOCO-----------------------------------------------------*/

    @Test
    public void testExisteJuguete() {
        // Configurar el EntityManager mock
        EntityManager entityManager = mock(EntityManager.class);
        TypedQuery<Integer> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Integer.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(1, 2, 3));

        // Crear la instancia de Sistema con el EntityManager mock
        Sistema sistema = new Sistema(mock(AdministradorRepository.class), entityManager);

        // Probar el método existeJuguete
        assertTrue(sistema.existeJuguete(2));
        assertFalse(sistema.existeJuguete(5));
    }

    @Test
    public void testVerificarCredenciales() {
        // Configuración del EntityManager mock
        EntityManager entityManager = mock(EntityManager.class);
        TypedQuery<AdministradoresEntity> query = obtenerAdministradoresEntityMock(entityManager);

        // Crear la instancia de Sistema con el EntityManager mock
        Sistema sistema = new Sistema(mock(AdministradorRepository.class), entityManager);

        // Credenciales correctas
        Model model1 = mock(Model.class);
        assertEquals("GestionJuguete", sistema.verificarCredenciales("darkchococrispis", "123", model1));
        verify(model1, never()).addAttribute(eq("error"), any());

        // Contraseña incorrecta
        Model model2 = mock(Model.class);
        assertEquals("Login", sistema.verificarCredenciales("darkchococrispis", "contraseniaIncorrecta", model2));
        verify(model2).addAttribute("error", true);

        // Usuario inexistente
        Model model3 = mock(Model.class);
        when(query.getSingleResult()).thenThrow(NoResultException.class); // Simula que no se encontró ningún resultado
        assertEquals("Login", sistema.verificarCredenciales("usuarioInexistente", "123", model3));
        verify(model3).addAttribute("error", true);
    }

    private static TypedQuery<AdministradoresEntity> obtenerAdministradoresEntityMock(EntityManager entityManager) {
        TypedQuery<AdministradoresEntity> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(AdministradoresEntity.class))).thenReturn(query);

        // Configurar el resultado para la primera llamada (usuario existente y contraseña correcta)
        AdministradoresEntity usuarioExistente = new AdministradoresEntity();
        usuarioExistente.setUsuario("darkchococrispis");
        usuarioExistente.setContrasenia("123");
        when(query.setParameter(eq("usuario"), eq("darkchococrispis"))).thenReturn(query);
        when(query.getSingleResult()).thenReturn(usuarioExistente);
        return query;
    }
}