/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.models;

import java.util.ArrayList;

public class DadosAPI {

  private String cnpj;
  private float identificador_matriz_filial;
  private String descricao_matriz_filial;
  private String razao_social;
  private String nome_fantasia;
  private float situacao_cadastral;
  private String descricao_situacao_cadastral;
  private String data_situacao_cadastral;
  private float motivo_situacao_cadastral;
  private String nome_cidade_exterior;
  private float codigo_natureza_juridica;
  private String data_inicio_atividade;
  private float cnae_fiscal;
  private String cnae_fiscal_descricao;
  private String descricao_tipo_logradouro;
  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String cep;
  private String uf;
  private float codigo_municipio;
  private String municipio;
  private String ddd_telefone_1;
  private String ddd_telefone_2;
  private String ddd_fax;
  private float qualificacao_do_responsavel;
  private float capital_social;
  private float porte;
  private String descricao_porte;
  private boolean opcao_pelo_simples;
  private String data_opcao_pelo_simples;
  private String data_exclusao_do_simples;
  private boolean opcao_pelo_mei;
  private String situacao_especial;
  private String data_situacao_especial = null;
  ArrayList<Object> qsa = new ArrayList<Object>();
  ArrayList<Object> cnaes_secundarias = new ArrayList<Object>();


 // Getter Methods 

  public String getCnpj() {
    return cnpj;
  }

  public float getIdentificador_matriz_filial() {
    return identificador_matriz_filial;
  }

  public String getDescricao_matriz_filial() {
    return descricao_matriz_filial;
  }

  public String getRazao_social() {
    return razao_social;
  }

  public String getNome_fantasia() {
    return nome_fantasia;
  }

  public float getSituacao_cadastral() {
    return situacao_cadastral;
  }

  public String getDescricao_situacao_cadastral() {
    return descricao_situacao_cadastral;
  }

  public String getData_situacao_cadastral() {
    return data_situacao_cadastral;
  }

  public float getMotivo_situacao_cadastral() {
    return motivo_situacao_cadastral;
  }

  public String getNome_cidade_exterior() {
    return nome_cidade_exterior;
  }

  public float getCodigo_natureza_juridica() {
    return codigo_natureza_juridica;
  }

  public String getData_inicio_atividade() {
    return data_inicio_atividade;
  }

  public float getCnae_fiscal() {
    return cnae_fiscal;
  }

  public String getCnae_fiscal_descricao() {
    return cnae_fiscal_descricao;
  }

  public String getDescricao_tipo_logradouro() {
    return descricao_tipo_logradouro;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCep() {
    return cep;
  }

  public String getUf() {
    return uf;
  }

  public float getCodigo_municipio() {
    return codigo_municipio;
  }

  public String getMunicipio() {
    return municipio;
  }

  public String getDdd_telefone_1() {
    return ddd_telefone_1;
  }

  public String getDdd_telefone_2() {
    return ddd_telefone_2;
  }

  public String getDdd_fax() {
    return ddd_fax;
  }

  public float getQualificacao_do_responsavel() {
    return qualificacao_do_responsavel;
  }

  public float getCapital_social() {
    return capital_social;
  }

  public float getPorte() {
    return porte;
  }

  public String getDescricao_porte() {
    return descricao_porte;
  }

  public boolean getOpcao_pelo_simples() {
    return opcao_pelo_simples;
  }

  public String getData_opcao_pelo_simples() {
    return data_opcao_pelo_simples;
  }

  public String getData_exclusao_do_simples() {
    return data_exclusao_do_simples;
  }

  public boolean getOpcao_pelo_mei() {
    return opcao_pelo_mei;
  }

  public String getSituacao_especial() {
    return situacao_especial;
  }

  public String getData_situacao_especial() {
    return data_situacao_especial;
  }

 // Setter Methods 

  public void setCnpj( String cnpj ) {
    this.cnpj = cnpj;
  }

  public void setIdentificador_matriz_filial( float identificador_matriz_filial ) {
    this.identificador_matriz_filial = identificador_matriz_filial;
  }

  public void setDescricao_matriz_filial( String descricao_matriz_filial ) {
    this.descricao_matriz_filial = descricao_matriz_filial;
  }

  public void setRazao_social( String razao_social ) {
    this.razao_social = razao_social;
  }

  public void setNome_fantasia( String nome_fantasia ) {
    this.nome_fantasia = nome_fantasia;
  }

  public void setSituacao_cadastral( float situacao_cadastral ) {
    this.situacao_cadastral = situacao_cadastral;
  }

  public void setDescricao_situacao_cadastral( String descricao_situacao_cadastral ) {
    this.descricao_situacao_cadastral = descricao_situacao_cadastral;
  }

  public void setData_situacao_cadastral( String data_situacao_cadastral ) {
    this.data_situacao_cadastral = data_situacao_cadastral;
  }

  public void setMotivo_situacao_cadastral( float motivo_situacao_cadastral ) {
    this.motivo_situacao_cadastral = motivo_situacao_cadastral;
  }

  public void setNome_cidade_exterior( String nome_cidade_exterior ) {
    this.nome_cidade_exterior = nome_cidade_exterior;
  }

  public void setCodigo_natureza_juridica( float codigo_natureza_juridica ) {
    this.codigo_natureza_juridica = codigo_natureza_juridica;
  }

  public void setData_inicio_atividade( String data_inicio_atividade ) {
    this.data_inicio_atividade = data_inicio_atividade;
  }

  public void setCnae_fiscal( float cnae_fiscal ) {
    this.cnae_fiscal = cnae_fiscal;
  }

  public void setCnae_fiscal_descricao( String cnae_fiscal_descricao ) {
    this.cnae_fiscal_descricao = cnae_fiscal_descricao;
  }

  public void setDescricao_tipo_logradouro( String descricao_tipo_logradouro ) {
    this.descricao_tipo_logradouro = descricao_tipo_logradouro;
  }

  public void setLogradouro( String logradouro ) {
    this.logradouro = logradouro;
  }

  public void setNumero( String numero ) {
    this.numero = numero;
  }

  public void setComplemento( String complemento ) {
    this.complemento = complemento;
  }

  public void setBairro( String bairro ) {
    this.bairro = bairro;
  }

  public void setCep( String cep ) {
    this.cep = cep;
  }

  public void setUf( String uf ) {
    this.uf = uf;
  }

  public void setCodigo_municipio( float codigo_municipio ) {
    this.codigo_municipio = codigo_municipio;
  }

  public void setMunicipio( String municipio ) {
    this.municipio = municipio;
  }

  public void setDdd_telefone_1( String ddd_telefone_1 ) {
    this.ddd_telefone_1 = ddd_telefone_1;
  }

  public void setDdd_telefone_2( String ddd_telefone_2 ) {
    this.ddd_telefone_2 = ddd_telefone_2;
  }

  public void setDdd_fax( String ddd_fax ) {
    this.ddd_fax = ddd_fax;
  }

  public void setQualificacao_do_responsavel( float qualificacao_do_responsavel ) {
    this.qualificacao_do_responsavel = qualificacao_do_responsavel;
  }

  public void setCapital_social( float capital_social ) {
    this.capital_social = capital_social;
  }

  public void setPorte( float porte ) {
    this.porte = porte;
  }

  public void setDescricao_porte( String descricao_porte ) {
    this.descricao_porte = descricao_porte;
  }

  public void setOpcao_pelo_simples( boolean opcao_pelo_simples ) {
    this.opcao_pelo_simples = opcao_pelo_simples;
  }

  public void setData_opcao_pelo_simples( String data_opcao_pelo_simples ) {
    this.data_opcao_pelo_simples = data_opcao_pelo_simples;
  }

  public void setData_exclusao_do_simples( String data_exclusao_do_simples ) {
    this.data_exclusao_do_simples = data_exclusao_do_simples;
  }

  public void setOpcao_pelo_mei( boolean opcao_pelo_mei ) {
    this.opcao_pelo_mei = opcao_pelo_mei;
  }

  public void setSituacao_especial( String situacao_especial ) {
    this.situacao_especial = situacao_especial;
  }

  public void setData_situacao_especial( String data_situacao_especial ) {
    this.data_situacao_especial = data_situacao_especial;
  }

}
