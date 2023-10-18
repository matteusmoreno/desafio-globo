package br.com.globo.register;

import br.com.globo.register.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByCpf(String cpf);

    Page<Person> findAllByActiveTrue(Pageable pagination);

    Page<Person> findAllByActiveFalse(Pageable pagination);
}
