package br.controle_contatos.models;

import java.util.ArrayList;

public class ClientePlanilha {
    
    private String telefones;
    private String contato;
    private String nomeFantasia;

    public ClientePlanilha(){
    
}
    public ClientePlanilha( String telefones, String contato, String nomeFantasia) {
        this.telefones = telefones;
        this.contato = contato;
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    
}
