package br.com.globo.register.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Adress {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
