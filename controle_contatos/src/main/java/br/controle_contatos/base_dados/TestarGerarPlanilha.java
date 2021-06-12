/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.base_dados;

import br.controle_contatos.models.Cliente;
import java.util.ArrayList;

/**
 *
 * @author NOTE_190
 */
public class TestarGerarPlanilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GerarPlanilha gerarPlanilha = new GerarPlanilha();
        ArrayList<Cliente> clientes = new ArrayList<>();

        String[] municipios = {"IUNA", "CASTELO"};

        Cliente c1 = new Cliente();
        c1.setCodigo("2353");
        c1.setRazaoSocial("PERIFERICOS ALMEIDA LTDA");
        c1.setTelefone("99925-9988");
        c1.setContato("VALDIR/LETICIA");
        c1.getEndereco().setMunicipio("IUNA");

        Cliente c2 = new Cliente();
        c2.setCodigo("6969");
        c2.setRazaoSocial("MERCADINHO LUIZAO LTDA");
        c2.setTelefone("99965-1111");
        c2.setContato("SAID/GABRIEL");
        c2.getEndereco().setMunicipio("CASTELO");

        clientes.add(c1);
        clientes.add(c2);

        //gerarPlanilha.gerarPlanilha( clientes, municipios);

    }

}
