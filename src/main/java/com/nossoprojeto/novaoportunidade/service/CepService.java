package com.nossoprojeto.novaoportunidade.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nossoprojeto.novaoportunidade.model.Aluno;
import com.nossoprojeto.novaoportunidade.model.ViaCepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private static final String BASE_URL = "https://viacep.com.br/ws/";

    public Aluno buscarEnderecoPorCep(String cep, Long numero) {
        try {
            String cepLimpo = cep.replaceAll("\\D", "");
            if (cepLimpo.length() != 8) {
                throw new RuntimeException("CEP inválido: deve conter 8 dígitos.");
            }

            String url = BASE_URL + cepLimpo + "/json";
            RestTemplate restTemplate = new RestTemplate();
            String responseBody = restTemplate.getForObject(url, String.class);

            System.out.println("Resposta ViaCEP: " + responseBody);

            if (responseBody == null || responseBody.trim().startsWith("<")) {
                throw new RuntimeException("Resposta inválida do ViaCEP (HTML recebido). Verifique o CEP ou a conexão.");
            }

            ObjectMapper mapper = new ObjectMapper();
            ViaCepResponse response = mapper.readValue(responseBody, ViaCepResponse.class);

            if (response.getCep() == null) {
                throw new RuntimeException("CEP não encontrado: " + cepLimpo);
            }

            Aluno aluno = new Aluno();
            aluno.setCep(Long.valueOf(cepLimpo));
            aluno.setRua(response.getLogradouro());
            aluno.setBairro(response.getBairro());
            aluno.setCidade(response.getLocalidade());
            aluno.setUf(response.getUf());
            aluno.setNumero(numero);

            return aluno;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar CEP: " + e.getMessage(), e);
        }
    }
}
