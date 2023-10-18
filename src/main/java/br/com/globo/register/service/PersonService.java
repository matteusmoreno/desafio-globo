package br.com.globo.register.service;

import br.com.globo.register.PersonRepository;
import br.com.globo.register.client.ViaCepClient;
import br.com.globo.register.domain.Person;
import br.com.globo.register.request.PersonCreateRequest;
import br.com.globo.register.request.PersonUpdateRequest;
import br.com.globo.register.response.PersonListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonService {

    private final PersonUtils personUtils;
    private final PersonRepository personRepository;
    private final ViaCepClient viaCepClient;

    @Autowired
    public PersonService(PersonUtils personUtils, PersonRepository personRepository, ViaCepClient viaCepClient) {
        this.personUtils = personUtils;
        this.personRepository = personRepository;
        this.viaCepClient = viaCepClient;
    }

    public Person create(PersonCreateRequest request) {
        Person person = new Person();

        person.setName(request.name());
        person.setBirthDate(request.birthDate());
        person.setAge(personUtils.calculateAgeFromDateString(request.birthDate()));
        person.setCpf(request.cpf());
        person.setPhone(request.phone());

        // ENDEREÇO
        person.setCep(request.cep());
        personUtils.setAdressAttributes(person, request.cep());

        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(null);
        person.setDeletedAt(null);
        person.setActive(true);

        personRepository.save(person);
        return person;
    }

    public Person details(String cpf) {
        return personRepository.findByCpf(cpf);
    }

    public Person update(PersonUpdateRequest request) {
        var person = personRepository.findByCpf(request.cpf());

        personUtils.setUpdateAttributes(person, request);
        person.setUpdatedAt(LocalDateTime.now());

        return person;
    }

    public void delete(String cpf) {
        personRepository.findByCpf(cpf).setActive(false);
    }

    public void activate(String cpf) {
        personRepository.findByCpf(cpf).setActive(true);
    }

    public Page<PersonListResponse> listByActiveTrue(Pageable pagination) {
        return personRepository.findAllByActiveTrue(pagination).map(PersonListResponse::new);
    }

    public Page<PersonListResponse> listByActiveFalse(Pageable pagination) {
        return personRepository.findAllByActiveFalse(pagination).map(PersonListResponse::new);
    }
}
