package br.com.globo.register.client;

import br.com.globo.register.exception.InvalidCepException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {
    @GetMapping("/{cep}/json")
    @ResponseStatus(HttpStatus.OK) // Defina o código de status como OK
    default Adress getAdress(@PathVariable String cep) {
        Adress address = requestAddress(cep);
        if (address.logradouro() == null || address.bairro() == null
                || address.localidade() == null || address.uf() == null) {
            throw new InvalidCepException("CEP inválido ou não encontrado.");
        }
        return address;
    }

    @GetMapping("/{cep}/json")
    Adress requestAddress(@PathVariable String cep);
}








/*
FeignClient sem tratar exceção

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {
    @GetMapping("/{cep}/json")
    Adress getAdress(@PathVariable String cep);
}

*/
