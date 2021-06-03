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
public class Contato {
    
    private Long id;
    private String razaoSocial;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String cnpjCpf;
    private String localidade;
    private String uf;

    public Contato(Long id, String razaoSocial, String telefone1, String telefone2, String telefone3, String cnpjCpf, String localidade, String uf) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
        this.cnpjCpf = cnpjCpf;
        this.localidade = localidade;
        this.uf = uf;
    }
    
    public Contato(){
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

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", razaoSocial=" + razaoSocial + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", telefone3=" + telefone3 + ", cnpjCpf=" + cnpjCpf + ", localidade=" + localidade + ", uf=" + uf + '}';
    }    
    
}
