package br.com.globo.register.controller;

import br.com.globo.register.request.PersonCreateRequest;
import br.com.globo.register.response.PersonDetailsResponse;
import br.com.globo.register.service.PersonService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid PersonCreateRequest request, UriComponentsBuilder uriBuilder) {
        var person = personService.create(request);
        var uri = uriBuilder.path("/person/{cpf}").buildAndExpand(person.getCpf()).toUri();

        return ResponseEntity.created(uri).body(new PersonDetailsResponse(person));
    }
}
