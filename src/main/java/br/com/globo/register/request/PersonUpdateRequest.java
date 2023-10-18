package br.com.globo.register.request;

import jakarta.validation.constraints.NotBlank;

public record PersonUpdateRequest(
        @NotBlank
        String cpf,
        String name,
        String birthDate,
        String phone,
        String cep) {
}
