CREATE TABLE Cliente(id INTEGER PRIMARY KEY AUTOINCREMENT, nome_fantasia varchar(255), razao_social varchar(255), telefones varchar(255), cnpj_cpf varchar(14), tipo varchar(255), loja_risco varchar(255), codigo varchar(255));

CREATE TABLE Endereco(id INTEGER PRIMARY KEY AUTOINCREMENT, logradouro varchar(255), numero INTEGER, complemento varchar(255),bairro varchar(255),municipio varchar(255), cep varchar(255), uf varchar(2));

ALTER TABLE Cliente ADD COLUMN id_endereco INTEGER REFERENCES Endereco(id);
