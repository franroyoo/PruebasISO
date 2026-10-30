package com.iso2026.tests.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MultaTransitoService {

    private final RestTemplate restTemplate;

    public MultaTransitoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> calcularMulta(Object velocidadMedida, Object limitePermitido) {
        return restTemplate.getForEntity(
                "/api/Test/multa-transito?velocidadMedida={velocidadMedida}&limitePermitido={limitePermitido}",
                String.class,
                velocidadMedida,
                limitePermitido
        );
    }
}
