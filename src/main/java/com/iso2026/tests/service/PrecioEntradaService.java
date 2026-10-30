package com.iso2026.tests.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrecioEntradaService {

    private final RestTemplate restTemplate;

    public PrecioEntradaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> obtenerPrecioEntrada(Object edad, Object tipoDia) {
        return restTemplate.getForEntity(
                "/api/Test/precio-entrada?edad={edad}&tipoDia={tipoDia}",
                String.class,
                edad,
                tipoDia
        );
    }
}
