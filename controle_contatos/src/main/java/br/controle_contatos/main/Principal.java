/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.main;

import br.controle_contatos.views.TelaPrincipalPresenter;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author gabriel
 */
public class Principal {
    
    public static void main(String args[]) throws IOException, ParseException{
        //var texto = "99.999.999/5555-99";    
        //var cnpj = texto.replaceAll("[\\D]", "");
        //System.out.println(cnpj);
        new TelaPrincipalPresenter();
    }
}
