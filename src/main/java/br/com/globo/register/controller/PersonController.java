package br.com.globo.register.controller;

import br.com.globo.register.request.PersonCreateRequest;
import br.com.globo.register.request.PersonUpdateRequest;
import br.com.globo.register.response.PersonDetailsResponse;
import br.com.globo.register.response.PersonListResponse;
import br.com.globo.register.service.PersonService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // CRIAR PESSOA
    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid PersonCreateRequest request, UriComponentsBuilder uriBuilder) {
        var person = personService.create(request);
        var uri = uriBuilder.path("/person/{cpf}").buildAndExpand(person.getCpf()).toUri();

        return ResponseEntity.created(uri).body(new PersonDetailsResponse(person));
    }

    // DETALHAR PESSOA ATRAVÉS DO CPF
    @GetMapping("detailsbycpf/{cpf}")
    public ResponseEntity details(@PathVariable String cpf) {
        var person = personService.details(cpf);

        return ResponseEntity.ok(new PersonDetailsResponse(person));
    }

    // LISTAR PESSOAS ATIVAS
    @GetMapping("/listbyactive")
    public ResponseEntity<Page<PersonListResponse>> listByActive(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = personService.listByActiveTrue(pagination);
        return ResponseEntity.ok(page);
    }

    // LISTAR PESSOAS DESATIVADAS
    @GetMapping("/listbyinactive")
    public ResponseEntity<Page<PersonListResponse>> listByInactive(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = personService.listByActiveFalse(pagination);
        return ResponseEntity.ok(page);
    }

    // ATUALIZAR PESSOA
    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid PersonUpdateRequest request) {
        var person = personService.update(request);

        return ResponseEntity.ok(new PersonDetailsResponse(person));
    }

    // DESATIVAR PESSOA
    @DeleteMapping("/delete/{cpf}")
    @Transactional
    public ResponseEntity delete(@PathVariable String cpf) {
        personService.delete(cpf);

        return ResponseEntity.noContent().build();
    }

    // ATIVAR PESSOA
    @PutMapping("/activate/{cpf}")
    @Transactional
    public ResponseEntity activate(@PathVariable String cpf) {
        personService.activate(cpf);

        return ResponseEntity.ok().build();
    }
}
