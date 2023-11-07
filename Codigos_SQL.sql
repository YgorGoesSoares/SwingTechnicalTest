CREATE DATABASE edamatec;


CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf CHAR(14) NOT NULL,
    telefone CHAR(12) NOT NULL,
    email VARCHAR(255) NOT NULL
));