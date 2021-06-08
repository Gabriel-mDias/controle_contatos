/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.base_dados;

import br.controle_contatos.base_dados.ConsumoAPI;
import br.controle_contatos.models.Cliente;
import br.controle_contatos.views.TelaPrincipalPresenter;
import java.io.IOException;

/**
 *
 * @author gabriel
 */
public class Principal {
    
    public static void main(String args[]) throws IOException{
       ConsumoAPI api = new ConsumoAPI();
       Cliente c = api.getClienteByCNPJ("36325447000188");
       System.out.println(c.toString());
    // new TelaPrincipalPresenter();
    }
}
