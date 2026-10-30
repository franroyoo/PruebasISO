package com.iso2026.tests;

import com.iso2026.tests.service.PrecioEntradaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PrecioEntradaTest {

    @Autowired
    private PrecioEntradaService precioEntradaService;

    // Caso de prueba 1 (se espera 400 pero devuelve 200)
    @Test
    void casoDePrueba1() {
        try {
            ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(-1, "Normal");
            assertEquals(400, response.getStatusCode().value());
        } catch (HttpStatusCodeException e) {
            assertEquals(400, e.getStatusCode().value());
        }
    }

    // Caso de prueba 2
    @Test
    void casoDePrueba2() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(0, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 3
    @Test
    void casoDePrueba3() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(2, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 4
    @Test
    void casoDePrueba4() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(3, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("15", response.getBody());
    }

    // Caso de prueba 5
    @Test
    void casoDePrueba5() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(11, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("15", response.getBody());
    }

    // Caso de prueba 6
    @Test
    void casoDePrueba6() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(12, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("25", response.getBody());
    }

    // Caso de prueba 7
    @Test
    void casoDePrueba7() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(17, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("25", response.getBody());
    }

    // Caso de prueba 8
    @Test
    void casoDePrueba8() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(18, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("40", response.getBody());
    }

    // Caso de prueba 9
    @Test
    void casoDePrueba9() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(64, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("40", response.getBody());
    }

    // Caso de prueba 10
    @Test
    void casoDePrueba10() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(65, "Normal");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("30", response.getBody());
    }

    // Caso de prueba 11
    @Test
    void casoDePrueba11() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(0, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 12
    @Test
    void casoDePrueba12() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(2, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 13
    @Test
    void casoDePrueba13() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(3, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("20", response.getBody());
    }

    // Caso de prueba 14
    @Test
    void casoDePrueba14() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(11, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("20", response.getBody());
    }

    // Caso de prueba 15
    @Test
    void casoDePrueba15() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(12, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("30", response.getBody());
    }

    // Caso de prueba 16
    @Test
    void casoDePrueba16() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(17, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("30", response.getBody());
    }

    // Caso de prueba 17
    @Test
    void casoDePrueba17() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(18, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("45", response.getBody());
    }

    // Caso de prueba 18
    @Test
    void casoDePrueba18() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(64, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("45", response.getBody());
    }

    // Caso de prueba 19
    @Test
    void casoDePrueba19() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(65, "FinDeSemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("35", response.getBody());
    }

    // Caso de prueba 20
    @Test
    void casoDePrueba20() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(0, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 21
    @Test
    void casoDePrueba21() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(2, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("0", response.getBody());
    }

    // Caso de prueba 22
    @Test
    void casoDePrueba22() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(3, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("25", response.getBody());
    }

    // Caso de prueba 23
    @Test
    void casoDePrueba23() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(11, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("25", response.getBody());
    }

    // Caso de prueba 24
    @Test
    void casoDePrueba24() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(12, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("35", response.getBody());
    }

    // Caso de prueba 25
    @Test
    void casoDePrueba25() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(17, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("35", response.getBody());
    }

    // Caso de prueba 26
    @Test
    void casoDePrueba26() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(18, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("50", response.getBody());
    }

    // Caso de prueba 27
    @Test
    void casoDePrueba27() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(64, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("50", response.getBody());
    }

    // Caso de prueba 28
    @Test
    void casoDePrueba28() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(65, "Feriado");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("40", response.getBody());
    }

    // Caso de prueba 29
    @Test
    void casoDePrueba29() {
        ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(20, "findesemana");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("45", response.getBody());
    }

    // Caso de prueba 30 (se espera 400 pero devuelve 200)
    @Test
    void casoDePrueba30() {
        try {
            ResponseEntity<String> response = precioEntradaService.obtenerPrecioEntrada(20, "DiaTextoInvalido");
            assertEquals(400, response.getStatusCode().value());
        } catch (HttpStatusCodeException e) {
            assertEquals(400, e.getStatusCode().value());
        }
    }
}
