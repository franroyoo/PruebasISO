package com.iso2026.tests.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditoService {

    private final RestTemplate restTemplate;

    public CreditoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> evaluarCredito(Object puntajeCrediticio, Object ingresosMensuales) {
        return restTemplate.getForEntity(
                "/api/Test/credito?puntajeCrediticio={puntajeCrediticio}&ingresosMensuales={ingresosMensuales}",
                String.class,
                puntajeCrediticio,
                ingresosMensuales
        );
    }
}
