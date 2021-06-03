#!/bin/bash

nome_projeto='controle_contatos'

    #Gera o banco e roda o primeiro script que é responsável pelas tabelas
sqlite3 database.db < scripts/tables.sql

    #Executa o segundo script que é responsável pelas inserções
sqlite3 database.db < scripts/inserts.sql

    #Diretório default para armazenar o banco neste projeto
mv database.db ./../$nome_projeto/src/main/database/database.db

echo "Caso não tenha ocorrido erros, o banco database.db foi gerado no diretório: ./src/main/database/";


