/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.main;

import br.controle_contatos.business.ClienteBusiness;
import br.controle_contatos.models.Cliente;
import br.controle_contatos.views.TelaPrincipalPresenter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Principal {
    
    public static void main(String args[]){
        try {
            
            var c = new Cliente();
            c.setCnpjCpf("123");
            
            new TelaPrincipalPresenter();
            new ClienteBusiness().insert(c);
            c.setRazaoSocial("Sem");
            new ClienteBusiness().insert(c);
            new ClienteBusiness().insert(new Cliente());
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
