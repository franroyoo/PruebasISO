package com.iso2026.tests;

import com.iso2026.tests.service.DescuentoCompraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DescuentoCompraTest {

    @Autowired
    private DescuentoCompraService descuentoCompraService;

    // Caso de prueba 1 (la respuesta real de la API devuelve 200, pero deberia ser una Exception internamente y devolver 400)
    @Test
    void casoDePrueba1() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(-0.01, false);
        assertEquals(400, response.getStatusCode().value());
    }

    // Caso de prueba 2 (la respuesta real de la API devuelve 200, pero deberia ser una Exception internamente y devolver 400)
    @Test
    void casoDePrueba2() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(-0.01, true);
        assertEquals(400, response.getStatusCode().value());
    }

    // Caso de prueba 3
    @Test
    void casoDePrueba3() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(0, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 4
    @Test
    void casoDePrueba4() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(0, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 5
    @Test
    void casoDePrueba5() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(49.99, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 6
    @Test
    void casoDePrueba6() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(49.99, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 7
    @Test
    void casoDePrueba7() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(50, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("5", response.getBody());
    }

    // Caso de prueba 8
    @Test
    void casoDePrueba8() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(50, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("10", response.getBody());
    }

    // Caso de prueba 9
    @Test
    void casoDePrueba9() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(99.99, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("5", response.getBody());
    }

    // Caso de prueba 10
    @Test
    void casoDePrueba10() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(99.99, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("10", response.getBody());
    }

    // Caso de prueba 11
    @Test
    void casoDePrueba11() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(100, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("10", response.getBody());
    }

    // Caso de prueba 12
    @Test
    void casoDePrueba12() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(100, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("15", response.getBody());
    }

    // Caso de prueba 13
    @Test
    void casoDePrueba13() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(499.99, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("10", response.getBody());
    }

    // Caso de prueba 14
    @Test
    void casoDePrueba14() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(499.99, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("15", response.getBody());
    }

    // Caso de prueba 15
    @Test
    void casoDePrueba15() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(500, false);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("15", response.getBody());
    }

    // Caso de prueba 16
    @Test
    void casoDePrueba16() {
        ResponseEntity<String> response = descuentoCompraService.obtenerDescuento(500, true);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("20", response.getBody());
    }
}
