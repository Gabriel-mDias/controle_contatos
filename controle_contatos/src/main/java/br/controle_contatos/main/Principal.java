/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.main;

import br.controle_contatos.business.ClienteBusiness;
import br.controle_contatos.dao.ClienteDAO;
import br.controle_contatos.models.Cliente;

/**
 *
 * @author gabriel
 */
public class Principal {
    
    public static void main(String args[]){
        
        try{
            System.out.println("Resultado da consulta: ");
            
            for(Cliente elemento : new ClienteBusiness().getByParametros(new Cliente())){
                System.out.println(elemento.toString());
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
