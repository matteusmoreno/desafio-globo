package br.com.globo.register.response;

import br.com.globo.register.domain.Person;

public record PersonListResponse(
        String name,
        String phone,
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        Boolean active) {

    public PersonListResponse(Person person) {
        this(person.getName(),
                person.getPhone(),
                person.getCep(),
                person.getLogradouro(),
                person.getBairro(),
                person.getLocalidade(),
                person.getUf(), person.getActive());
    }
}
