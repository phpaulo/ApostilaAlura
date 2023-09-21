--Base de dados utilizada neste projeto Apache Derby 10.14
--DROP TABLE AGENDA.CONTATOS;

CREATE TABLE contatos(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(255),
    endereco VARCHAR(255),
    email VARCHAR(255),
    dataNascimento Date,
CONSTRAINT primary_key PRIMARY KEY (id)
);


-- insert into contatos (nome,endereco,email,dataNascimento) values ('Caelum','R. Vergueiro 3185 cj57','contato@caelum.com.br','01/09/2023')

