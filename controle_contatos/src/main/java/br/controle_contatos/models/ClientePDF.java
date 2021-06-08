package br.controle_contatos.models;

public class ClientePDF {
    
    private String nome;
    private String tipo;
    private String cnpj;
    private String lojaRisco;
    private String codigo;
    

    public ClientePDF(){
        
    }
    
    public ClientePDF(String nome, String tipo, String cnpj, String codigo, String lojaRisco) {
        this.nome = nome;
        this.tipo = tipo;
        this.cnpj = cnpj;
        this.codigo = codigo;
        this.lojaRisco = lojaRisco;
    }
      
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLojaRisco() {
        return lojaRisco;
    }

    public void setLojaRisco(String lojaRisco) {
        this.lojaRisco = lojaRisco;
    }
    
     public String getLojaRisco( String str ){
        String lojaRisco = "";
        lojaRisco += str.substring(str.length()-2);
        lojaRisco += str.substring(str.length()-1);
        return lojaRisco;
    }
    
    
}
