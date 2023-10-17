CREATE TABLE person (

    id bigint PRIMARY KEY,
    name VARCHAR(155),
    birthDate DATE,
    age VARCHAR(155),
    phone VARCHAR(155),
    cpf VARCHAR(20),
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP,
    deletedAt TIMESTAMP,
    active BOOLEAN
);
