package com.example.tarea3;

import com.example.tarea3.model.JuguetesEntity;
import com.example.tarea3.repository.JugueteRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SistemaParametrizadoTest {

    @Autowired
    private JugueteRepository jugueteRepository;

    @Autowired
    private Sistema sistema;

    @Transactional
    @ParameterizedTest
    @MethodSource("parameters")
    public void venderJugueteTest(int idJuguete, int cantidadVendida, int expectedRemainingQuantity) {
        JuguetesEntity juguete = new JuguetesEntity();
        juguete.setId(idJuguete);
        juguete.setPrecio(BigDecimal.TEN);
        juguete.setCantidad(5);
        jugueteRepository.save(juguete);

        sistema.venderJuguete(idJuguete, cantidadVendida);

        JuguetesEntity jugueteDespuesDeVenta = jugueteRepository.findById((long) idJuguete).orElse(null);
        assertNotNull(jugueteDespuesDeVenta);
        assertEquals(expectedRemainingQuantity, jugueteDespuesDeVenta.getCantidad());
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 1, 4),
                Arguments.of(3, 4, 1)
        );
    }
}