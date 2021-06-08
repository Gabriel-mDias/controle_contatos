package br.controle_contatos.base_dados;

import br.controle_contatos.leitura.LerTabelaPdf;
import br.controle_contatos.leitura.LerTabelaPlanilha;
import br.controle_contatos.models.Cliente;
import br.controle_contatos.models.ClientePDF;
import br.controle_contatos.models.ClientePlanilha;
import java.io.IOException;
import java.util.ArrayList;

public class GerarBaseDados {

    public static void main(String[] args) throws IOException {

        LerTabelaPdf lerPDF = new LerTabelaPdf();
        ArrayList<ClientePDF> clientesPDF = lerPDF.lerDados("C:\\Users\\NOTE_190\\Downloads\\Clientes Sergio[565] (1).pdf");

        LerTabelaPlanilha lerPDFPlanilha = new LerTabelaPlanilha();
        ArrayList<ClientePlanilha> clientesPlanilha = lerPDFPlanilha.lerDados("C:\\Users\\NOTE_190\\Downloads\\PROJETO DE ATUALIZAÇÃO[566] (3).pdf");

        String[] cnpjClientes = new String[clientesPDF.size()];
        for (int i = 0; i < cnpjClientes.length; i++) {
            cnpjClientes[i] = clientesPDF.get(i).getCnpj();
            cnpjClientes[i] = cnpjClientes[i].replace(".", "").replace("/", "").replace("-", "");
            //System.out.println(cnpjClientes[i]);
        }

        ArrayList<Cliente> clientes = new ArrayList<>();

        ConsumoAPI api = new ConsumoAPI();

        for (int i = 0; i < cnpjClientes.length; i++) {
            Cliente c = api.getClienteByCNPJ( cnpjClientes[i] );
            clientes.add(c);
        }

        for(Cliente c: clientes){
            c.toString();
            System.out.printf("\n");
        }
        
        
    }
}
