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
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String telefone4;
    private String cnpjCpf;
    private Endereco endereco;

    public Cliente(Long id, String razaoSocial, String nomeFantasia, String telefone1, String telefone2, String telefone3, String telefone4, String cnpjCpf, Endereco endereco) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
        this.telefone4 = telefone4;
        this.cnpjCpf = cnpjCpf;
        this.endereco = endereco;
    }

    public Cliente(Long id, String razaoSocial, String nomeFantasia, String telefone1, String telefone2, String telefone3, String telefone4, String cnpjCpf) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
        this.telefone4 = telefone4;
        this.cnpjCpf = cnpjCpf;
    }

    public Cliente() {
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

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public String getTelefone4() {
        return telefone4;
    }

    public void setTelefone4(String telefone4) {
        this.telefone4 = telefone4;
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
