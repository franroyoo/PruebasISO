package com.iso2026.tests;

import com.iso2026.tests.service.MultaTransitoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MultaTransitoTest {

    @Autowired
    private MultaTransitoService multaTransitoService;

    // Caso de prueba 1 (se espera 400)
    @Test
    void casoDePrueba1() {
        try {
            ResponseEntity<String> response = multaTransitoService.calcularMulta(-1, 60);
            assertEquals(400, response.getStatusCode().value());
        } catch (HttpStatusCodeException e) {
            assertEquals(400, e.getStatusCode().value());
        }
    }

    // Caso de prueba 2 (se espera 400)
    @Test
    void casoDePrueba2() {
        try {
            ResponseEntity<String> response = multaTransitoService.calcularMulta(60, 0);
            assertEquals(400, response.getStatusCode().value());
        } catch (HttpStatusCodeException e) {
            assertEquals(400, e.getStatusCode().value());
        }
    }

    // Caso de prueba 3
    @Test
    void casoDePrueba3() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(50, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":0,\"puntos\":0}", response.getBody());
    }

    // Caso de prueba 4
    @Test
    void casoDePrueba4() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(60, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":0,\"puntos\":0}", response.getBody());
    }

    // Caso de prueba 5
    @Test
    void casoDePrueba5() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(60.1, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":5000,\"puntos\":0}", response.getBody());
    }

    // Caso de prueba 6
    @Test
    void casoDePrueba6() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(65, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":5000,\"puntos\":0}", response.getBody());
    }

    // Caso de prueba 7
    @Test
    void casoDePrueba7() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(70, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":5000,\"puntos\":0}", response.getBody());
    }

    // Caso de prueba 8
    @Test
    void casoDePrueba8() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(70.1, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":15000,\"puntos\":2}", response.getBody());
    }

    // Caso de prueba 9
    @Test
    void casoDePrueba9() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(80, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":15000,\"puntos\":2}", response.getBody());
    }

    // Caso de prueba 10
    @Test
    void casoDePrueba10() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(90, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":15000,\"puntos\":2}", response.getBody());
    }

    // Caso de prueba 11
    @Test
    void casoDePrueba11() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(90.1, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":30000,\"puntos\":5}", response.getBody());
    }

    // Caso de prueba 12
    @Test
    void casoDePrueba12() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(105, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":30000,\"puntos\":5}", response.getBody());
    }

    // Caso de prueba 13
    @Test
    void casoDePrueba13() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(120, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":30000,\"puntos\":5}", response.getBody());
    }

    // Caso de prueba 14
    @Test
    void casoDePrueba14() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(120.1, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":60000,\"puntos\":10}", response.getBody());
    }

    // Caso de prueba 15
    @Test
    void casoDePrueba15() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(150, 60);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":60000,\"puntos\":10}", response.getBody());
    }

    // Caso de prueba 16
    @Test
    void casoDePrueba16() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(40, 40);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":0,\"puntos\":0}", response.getBody());
    }

    // Caso de prueba 17
    @Test
    void casoDePrueba17() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(50, 40);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":5000,\"puntos\":0}", response.getBody());
    }

    // Caso de prueba 18
    @Test
    void casoDePrueba18() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(50.1, 40);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":15000,\"puntos\":2}", response.getBody());
    }

    // Caso de prueba 19
    @Test
    void casoDePrueba19() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(70, 40);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":15000,\"puntos\":2}", response.getBody());
    }

    // Caso de prueba 20
    @Test
    void casoDePrueba20() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(70.1, 40);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":30000,\"puntos\":5}", response.getBody());
    }

    // Caso de prueba 21
    @Test
    void casoDePrueba21() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(100, 40);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":30000,\"puntos\":5}", response.getBody());
    }

    // Caso de prueba 22
    @Test
    void casoDePrueba22() {
        ResponseEntity<String> response = multaTransitoService.calcularMulta(100.1, 40);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("{\"multa\":60000,\"puntos\":10}", response.getBody());
    }
}
