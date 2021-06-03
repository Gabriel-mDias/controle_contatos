#!/bin/bash

    #Gera o banco e roda o primeiro script que é responsável pelas tabelas
sqlite3 banco_contatos.db < scripts/tables.sql

    #Executa o segundo script que é responsável pelas inserções
sqlite3 banco_contatos.db < scripts/inserts.sql


