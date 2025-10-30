package com.nossoprojeto.novaoportunidade.service;

import org.springframework.web.client.RestTemplate;

public class CepService {
    private final String BASE_URL = "https://viacep.com.br/ws/";

    public Endereco buscarEnderecoPorCep(String cep) {
        String url = BASE_URL + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Endereco.class);
    }
}
