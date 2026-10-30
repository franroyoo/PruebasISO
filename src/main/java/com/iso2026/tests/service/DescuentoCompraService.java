package com.iso2026.tests.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DescuentoCompraService {

    private final RestTemplate restTemplate;

    public DescuentoCompraService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> obtenerDescuento(Object montoTotal, Object esVIP) {
        return restTemplate.getForEntity(
                "/api/Test/descuento-compra?montoTotal={montoTotal}&esVIP={esVIP}",
                String.class,
                montoTotal,
                esVIP
        );
    }
}
