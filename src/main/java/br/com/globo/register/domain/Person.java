package br.com.globo.register.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Person {

    private String name;
    private String birthDate;
    private int age;
    @Id
    private String cpf;
    private String phone;
    @Embedded
    private Adress adress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Boolean active;

}
