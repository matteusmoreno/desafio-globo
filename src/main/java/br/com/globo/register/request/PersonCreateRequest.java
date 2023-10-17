package br.com.globo.register.request;

import br.com.globo.register.domain.Adress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PersonCreateRequest(
        @NotBlank(message = "Name is mandatory")
        String name,
        @NotBlank(message = "Birth date is mandatory")
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Birth date must be in the format dd-MM-yyyy")
        String birthDate,
        @NotNull
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF must be in the format xxx.xxx.xxx-xx")
        String cpf,
        String phone,
        @NotNull(message = "Adress is mandatory")
        Adress adress) {
}
