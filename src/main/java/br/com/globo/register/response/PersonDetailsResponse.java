package br.com.globo.register.response;

import br.com.globo.register.domain.Adress;
import br.com.globo.register.domain.Person;

import java.time.LocalDateTime;

public record PersonDetailsResponse(
        String name,
        String birthDate,
        int age,
        String cpf,
        String phone,
        Adress adress,
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
                person.getAdress(),
                person.getCreatedAt(),
                person.getUpdatedAt(),
                person.getDeletedAt(),
                person.getActive());
    }
}
