/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.models;

/**
 *
 * @author gabriel
 */
public class Cliente {

    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String telefone;
    private String cnpjCpf;
    private String contato;
    private Endereco endereco;

    public Cliente(){
        this.endereco = new Endereco();
    }
    public Cliente(Long id, String razaoSocial, String nomeFantasia, String telefone, String cnpjCpf, String contato, Endereco endereco) {
        this.id = id;
        this.telefone = telefone;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpjCpf = cnpjCpf;
        this.contato = contato;
        this.endereco = endereco;
    }

    public Cliente(Long id, String razaoSocial, String telefone, String nomeFantasia, String cnpjCpf, String contato) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.cnpjCpf = cnpjCpf;
        this.contato = contato;
    }

    public String toString() {
        return "\n---------- Dados Cliente ----------"
                + "\nRazão Social: " + this.getRazaoSocial()
                + "\nNome Fantasia: " + this.getNomeFantasia()
                + "\nTelefone: " + this.getTelefone()
                + "\nCNPJ: " + this.getCnpjCpf()
                + "\nContato: " + this.getContato()
                + "\n---------- Dados de Endereço ------------"
                + "\nLogradouro: " + this.getEndereco().getLogradouro()
                + "\nNumero: " + this.getEndereco().getNumero()
                + "\nComplemento: " + this.getEndereco().getComplemento()
                + "\nBairro: " + this.getEndereco().getBairro()
                + "\nMunicípio: " + this.getEndereco().getMunicipio()
                + "\nCep: " + this.getEndereco().getCep()
                + "\nUF: " + this.getEndereco().getUf();
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
