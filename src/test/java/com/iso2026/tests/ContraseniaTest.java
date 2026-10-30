package com.iso2026.tests;

import com.iso2026.tests.service.ContraseniaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ContraseniaTest {

    @Autowired
    private ContraseniaService contraseniaService;

    // Caso de prueba 1
    @Test
    void casoDePrueba1() {
        ResponseEntity<String> response = contraseniaService.validarContrasenia("holaa", 5, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("false", response.getBody());
    }

    // Caso de prueba 2
    @Test
    void casoDePrueba2() {
        ResponseEntity<String> response = contraseniaService.validarContrasenia("hola#", 5, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("true", response.getBody());
    }

    // Caso de prueba 3
    @Test
    void casoDePrueba3() {
        ResponseEntity<String> response = contraseniaService.validarContrasenia("prueb", 5, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("true", response.getBody());
    }

    // Caso de prueba 4
    @Test
    void casoDePrueba4() {
        ResponseEntity<String> response = contraseniaService.validarContrasenia("prue#", 5, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("true", response.getBody());
    }

    // Caso de prueba 5
    @Test
    void casoDePrueba5() {
        // requiereEspeciales es indistinto ya que la longitud es menor a la mínima (5)
        ResponseEntity<String> response = contraseniaService.validarContrasenia("hola", 5, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("false", response.getBody());
    }

    // Caso de prueba 6
    @Test
    void casoDePrueba6() {
        ResponseEntity<String> response = contraseniaService.validarContrasenia("hol a", 5, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("false", response.getBody());
    }
}
