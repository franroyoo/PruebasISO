package com.iso2026.tests.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlmacenamientoService {

    private final RestTemplate restTemplate;

    public AlmacenamientoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> consultarAlmacenamiento(Object espacioUsadoGB, Object capacidadTotalGB) {
        return restTemplate.getForEntity(
                "/api/Test/almacenamiento?espacioUsadoGB={espacioUsadoGB}&capacidadTotalGB={capacidadTotalGB}",
                String.class,
                espacioUsadoGB,
                capacidadTotalGB
        );
    }
}
