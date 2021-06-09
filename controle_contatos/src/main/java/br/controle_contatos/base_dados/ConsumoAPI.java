/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.base_dados;

import br.controle_contatos.models.Cliente;
import br.controle_contatos.models.DadosAPI;
import com.codesnippets4all.json.parsers.JSONParser;
import com.codesnippets4all.json.parsers.JsonParserFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NOTE_190
 */
public class ConsumoAPI {

    public Cliente getClienteByCNPJ(String cnpj) throws Exception {

        URL url = new URL("https://minhareceita.org/" + cnpj);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() != 200) {
            System.out.print("deu erro... HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output, json = "";
        while ((output = br.readLine()) != null) {
            json += output;
        }
        //System.out.println("Json Feio:");
        //System.out.println(json);

        Gson gson = new Gson();
        DadosAPI obj = gson.fromJson(json, DadosAPI.class);

        Cliente cliente = new Cliente();
        cliente.setCnpjCpf(cnpj);
        cliente.setRazaoSocial(obj.getRazao_social());
        cliente.setNomeFantasia(obj.getNome_fantasia());
        cliente.getEndereco().setBairro(obj.getBairro());
        cliente.getEndereco().setCep(obj.getCep());
        cliente.getEndereco().setComplemento(obj.getComplemento());
        cliente.getEndereco().setLogradouro( obj.getDescricao_tipo_logradouro() + " " + obj.getLogradouro());
        cliente.getEndereco().setMunicipio(obj.getMunicipio());
        //if (!obj.getNumero().isEmpty() && obj.getNumero() != null) {
        //    cliente.getEndereco().setNumero(Integer.valueOf(obj.getNumero()));
        //}
        cliente.getEndereco().setUf(obj.getUf());

        conn.disconnect();
        return cliente;
    }
}
