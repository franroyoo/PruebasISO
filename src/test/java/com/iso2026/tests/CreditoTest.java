package com.iso2026.tests;

import com.iso2026.tests.service.CreditoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CreditoTest {

    @Autowired
    private CreditoService creditoService;


    private static final double SMVM_VIGENTE = 376_000.0;

    // Caso de prueba 1
    @Test
    void casoDePrueba1() {
        ResponseEntity<String> response = creditoService.evaluarCredito(-1, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 2
    @Test
    void casoDePrueba2() {
        ResponseEntity<String> response = creditoService.evaluarCredito(0, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 3
    @Test
    void casoDePrueba3() {
        ResponseEntity<String> response = creditoService.evaluarCredito(1, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 4
    @Test
    void casoDePrueba4() {
        ResponseEntity<String> response = creditoService.evaluarCredito(299, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 5
    @Test
    void casoDePrueba5() {
        ResponseEntity<String> response = creditoService.evaluarCredito(300, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 6
    @Test
    void casoDePrueba6() {
        ResponseEntity<String> response = creditoService.evaluarCredito(301, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 7
    @Test
    void casoDePrueba7() {
        ResponseEntity<String> response = creditoService.evaluarCredito(699, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 8
    @Test
    void casoDePrueba8() {
        ResponseEntity<String> response = creditoService.evaluarCredito(700, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 9
    @Test
    void casoDePrueba9() {
        ResponseEntity<String> response = creditoService.evaluarCredito(701, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 10
    @Test
    void casoDePrueba10() {
        ResponseEntity<String> response = creditoService.evaluarCredito(849, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 11
    @Test
    void casoDePrueba11() {
        ResponseEntity<String> response = creditoService.evaluarCredito(850, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 12
    @Test
    void casoDePrueba12() {
        ResponseEntity<String> response = creditoService.evaluarCredito(851, SMVM_VIGENTE);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 13
    @Test
    void casoDePrueba13() {
        ResponseEntity<String> response = creditoService.evaluarCredito(700, (SMVM_VIGENTE * 2) - 1);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 14
    @Test
    void casoDePrueba14() {
        ResponseEntity<String> response = creditoService.evaluarCredito(700, SMVM_VIGENTE * 2);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Aprobada", response.getBody());
    }

    // Caso de prueba 15
    @Test
    void casoDePrueba15() {
        ResponseEntity<String> response = creditoService.evaluarCredito(700, (SMVM_VIGENTE * 2) + 1);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Aprobada", response.getBody());
    }

    // Caso de prueba 16
    @Test
    void casoDePrueba16() {
        ResponseEntity<String> response = creditoService.evaluarCredito(850, (SMVM_VIGENTE * 2) - 1);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Pendiente", response.getBody());
    }

    // Caso de prueba 17
    @Test
    void casoDePrueba17() {
        ResponseEntity<String> response = creditoService.evaluarCredito(850, SMVM_VIGENTE * 2);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Aprobada", response.getBody());
    }

    // Caso de prueba 18
    @Test
    void casoDePrueba18() {
        ResponseEntity<String> response = creditoService.evaluarCredito(850, (SMVM_VIGENTE * 2) + 1);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Aprobada", response.getBody());
    }

    // Caso de prueba 19
    @Test
    void casoDePrueba19() {
        ResponseEntity<String> response = creditoService.evaluarCredito(200, SMVM_VIGENTE - 1);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 20
    @Test
    void casoDePrueba20() {
        ResponseEntity<String> response = creditoService.evaluarCredito(500, SMVM_VIGENTE - 1);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 21
    @Test
    void casoDePrueba21() {
        ResponseEntity<String> response = creditoService.evaluarCredito(750, SMVM_VIGENTE - 1);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 22
    @Test
    void casoDePrueba22() {
        ResponseEntity<String> response = creditoService.evaluarCredito(500, 0);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 23
    @Test
    void casoDePrueba23() {
        ResponseEntity<String> response = creditoService.evaluarCredito(500, -1);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }

    // Caso de prueba 24
    @Test
    void casoDePrueba24() {
        ResponseEntity<String> response = creditoService.evaluarCredito(3200, 450000);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Rechazada", response.getBody());
    }
}
