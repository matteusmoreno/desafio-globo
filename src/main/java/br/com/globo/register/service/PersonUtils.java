package br.com.globo.register.service;

import br.com.globo.register.client.ViaCepClient;
import br.com.globo.register.domain.Person;
import br.com.globo.register.request.PersonUpdateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Component
public class PersonUtils {

    private final ViaCepClient viaCepClient;

    public PersonUtils(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public int calculateAgeFromDateString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(dateString, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

    public void setAdressAttributes(Person person, String cep) {
        var adress = viaCepClient.getAdress(cep);

        person.setLogradouro(adress.logradouro());
        person.setBairro(adress.bairro());
        person.setLocalidade(adress.localidade());
        person.setUf(adress.uf());
    }

    public void setUpdateAttributes(Person person, PersonUpdateRequest request) {
        if (request.name() != null) {
            person.setName(request.name());
        }
        if (request.birthDate() != null) {
            person.setBirthDate(request.birthDate());
            person.setAge(calculateAgeFromDateString(request.birthDate()));
        }
        if (request.phone() != null) {
            person.setPhone(request.phone());
        }
        if (request.cep() != null) {
            person.setCep(request.cep());
            setAdressAttributes(person, request.cep());
        }
    }

}

