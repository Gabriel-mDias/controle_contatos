/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.main;

import br.controle_contatos.views.TelaPrincipalPresenter;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author gabriel
 */
public class Principal {
    
    public static void main(String args[]) throws IOException, ParseException{
         String value = "36325447000188";
         
          MaskFormatter cnpj = new MaskFormatter("##.###.###/####-##");
          cnpj.setValueContainsLiteralCharacters(false);
          System.out.println(cnpj.valueToString(value));
        //new TelaPrincipalPresenter();
    }
}
