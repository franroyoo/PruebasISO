package com.iso2026.tests;

import com.iso2026.tests.service.AlmacenamientoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AlmacenamientoTest {

    @Autowired
    private AlmacenamientoService almacenamientoService;


    @Test
    void testCaso1_EspacioNegativo_DebeRetornarError() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(-1, 100);
        assertEquals(400, response.getStatusCode().value(), "Se esperaba 400");
    }

    @Test
    void testCaso2_CapacidadCero_DebeRetornarError() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(50, 0);
        assertEquals(400, response.getStatusCode().value(), "Se esperaba 400");
    }

    @Test
    void testCaso3_CapacidadNegativa_DebeRetornarError() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(50, -1);
        assertEquals(400, response.getStatusCode().value(), "Se esperaba 400");
    }

    // --- CASOS CON CAPACIDAD 100 GB ---

    @Test
    void testCaso4_LimiteInferiorNormal() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(0, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Normal", response.getBody());
    }

    @Test
    void testCaso5_ValorIntermedioNormal() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(50, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Normal", response.getBody());
    }

    @Test
    void testCaso6_LimiteSuperiorNormal() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(79.9, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Normal", response.getBody());
    }

    @Test
    void testCaso7_LimiteInferiorAtencion() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(80, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Atencion", response.getBody());
    }

    @Test
    void testCaso8_JustoPorEncimaAtencion() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(80.1, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Atencion", response.getBody());
    }

    @Test
    void testCaso9_ValorIntermedioAtencion() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(90, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Atencion", response.getBody());
    }

    @Test
    void testCaso10_LimiteSuperiorAtencion() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(99.9, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Atencion", response.getBody());
    }

    @Test
    void testCaso11_LimiteInferiorSaturado() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(100, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Saturado", response.getBody());
    }

    @Test
    void testCaso12_JustoPorEncimaSaturado() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(100.1, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Saturado", response.getBody());
    }

    @Test
    void testCaso13_ValorAltoSaturado() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(120, 100);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Saturado", response.getBody());
    }

    // --- CASOS CON CAPACIDAD 50 GB ---

    @Test
    void testCaso14_LimiteInferiorNormal_Capacidad50() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(0, 50);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Normal", response.getBody());
    }

    @Test
    void testCaso15_LimiteSuperiorNormal_Capacidad50() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(39.9, 50);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Normal", response.getBody());
    }

    @Test
    void testCaso16_LimiteInferiorAtencion_Capacidad50() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(40, 50);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Atencion", response.getBody());
    }

    @Test
    void testCaso17_ValorIntermedioAtencion_Capacidad50() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(45, 50);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Atencion", response.getBody());
    }

    @Test
    void testCaso18_LimiteSuperiorAtencion_Capacidad50() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(49.9, 50);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Atencion", response.getBody());
    }

    @Test
    void testCaso19_LimiteInferiorSaturado_Capacidad50() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(50, 50);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Saturado", response.getBody());
    }

    @Test
    void testCaso20_ValorAltoSaturado_Capacidad50() {
        ResponseEntity<String> response = almacenamientoService.consultarAlmacenamiento(60, 50);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Saturado", response.getBody());
    }
}