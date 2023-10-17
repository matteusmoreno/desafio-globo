package br.com.globo.register.service;

import br.com.globo.register.PersonRepository;
import br.com.globo.register.domain.Person;
import br.com.globo.register.request.PersonCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonService {

    private final PersonUtils personUtils;
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonUtils personUtils, PersonRepository personRepository) {
        this.personUtils = personUtils;
        this.personRepository = personRepository;
    }

    public Person create(PersonCreateRequest request) {
        Person person = new Person();

        person.setName(request.name());
        person.setBirthDate(request.birthDate());
        person.setAge(personUtils.calculateAgeFromDateString(request.birthDate()));
        person.setCpf(request.cpf());
        person.setPhone(request.phone());
        person.setAdress(request.adress());
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(null);
        person.setDeletedAt(null);
        person.setActive(true);

        personRepository.save(person);
        return person;
    }
}
