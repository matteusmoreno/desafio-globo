package br.com.globo.register.client;

public record Adress(
        String logradouro,
        String bairro,
        String localidade,
        String uf) {
}
