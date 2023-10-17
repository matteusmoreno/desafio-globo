CREATE TABLE person (
    cpf VARCHAR(20) PRIMARY KEY,
    name VARCHAR(255),
    birth_date VARCHAR(10),
    age INT,
    phone VARCHAR(20),
    cep VARCHAR(10),
    logradouro VARCHAR(255),
    bairro VARCHAR(255),
    localidade VARCHAR(255),
    uf VARCHAR(2),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    active BOOLEAN
);
