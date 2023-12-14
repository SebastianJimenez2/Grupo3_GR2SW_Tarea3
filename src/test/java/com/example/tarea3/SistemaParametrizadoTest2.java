package com.example.tarea3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ConcurrentModel;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SistemaParametrizadoTest2 {

    @Autowired
    private Sistema sistema;

    @Transactional
    @ParameterizedTest
    @MethodSource("parameters")
    public void testVerificarCredencialesParametros(String usuario, String password, String expected) {
        ConcurrentModel model = new ConcurrentModel();
        String actual = sistema.verificarCredenciales(usuario, password, model);
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("darkchococrispis", "123", "GestionJuguete"),
                Arguments.of("sus", "123", "Login"),
                Arguments.of("xd", "123", "Login")
        );
    }

}
