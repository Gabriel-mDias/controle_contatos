CREATE TABLE Cliente(id INTEGER PRIMARY KEY AUTOINCREMENT, nome_fantasia varchar(255), razao_social varchar(255), telefone_1 varchar(255), telefone_2 varchar(255), telefone_3 varchar(255), telefone_4 varchar(255), cnpj_cpf varchar(14));

CREATE TABLE Endereco(id INTEGER PRIMARY KEY AUTOINCREMENT, logradouro varchar(255), numero INTEGER, complemento varchar(255),bairro varchar(255),municipio varchar(255), cep varchar(255), uf varchar(2));

ALTER TABLE Endereco ADD COLUMN id_cliente INTEGER REFERENCES Cliente(id);
