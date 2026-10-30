package com.iso2026.tests.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContraseniaService {

    private final RestTemplate restTemplate;

    public ContraseniaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> validarContrasenia(Object contrasenia, Object longitudMinima, Object requiereEspeciales) {
        return restTemplate.getForEntity(
                "/api/Test/contrasenia?contrasenia={contrasenia}&longitudMinima={longitudMinima}&requiereEspeciales={requiereEspeciales}",
                String.class,
                contrasenia,
                longitudMinima,
                requiereEspeciales
        );
    }
}
