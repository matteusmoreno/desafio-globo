package br.com.globo.register.response;

import br.com.globo.register.domain.Person;

import java.time.LocalDateTime;

public record PersonDetailsResponse(
        String name,
        String birthDate,
        int age,
        String cpf,
        String phone,
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt,
        Boolean active) {

    public PersonDetailsResponse(Person person) {
        this(
                person.getName(),
                person.getBirthDate(),
                person.getAge(),
                person.getCpf(),
                person.getPhone(),
                person.getCep(),
                person.getLogradouro(),
                person.getBairro(),
                person.getLocalidade(),
                person.getUf(),
                person.getCreatedAt(),
                person.getUpdatedAt(),
                person.getDeletedAt(),
                person.getActive());
    }
}
