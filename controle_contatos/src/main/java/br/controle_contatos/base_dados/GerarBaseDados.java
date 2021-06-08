package br.controle_contatos.base_dados;

import br.controle_contatos.business.ClienteBusiness;
import br.controle_contatos.leitura.LerTabelaPdf;
import br.controle_contatos.leitura.LerTabelaPlanilha;
import br.controle_contatos.models.Cliente;
import br.controle_contatos.models.ClientePDF;
import br.controle_contatos.models.ClientePlanilha;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerarBaseDados {
    
    private ClienteBusiness clienteBusiness = new ClienteBusiness();
    
    public static void main(String[] args) throws IOException {

        LerTabelaPdf lerPDF = new LerTabelaPdf();
        ArrayList<ClientePDF> clientesPDF = lerPDF.lerDados("/home/gabriel/Downloads/Clientes Sergio[565] (1).pdf");

        LerTabelaPlanilha lerPDFPlanilha = new LerTabelaPlanilha();
        ArrayList<ClientePlanilha> clientesPlanilha = lerPDFPlanilha.lerDados("/home/gabriel/Downloads/PROJETO DE ATUALIZAÇÃO[566] (3).pdf");

        String[] cnpjClientes = new String[clientesPDF.size()];
        for (int i = 0; i < cnpjClientes.length; i++) {
            cnpjClientes[i] = clientesPDF.get(i).getCnpj();
            cnpjClientes[i] = cnpjClientes[i].replace(".", "").replace("/", "").replace("-", "");
            System.out.println(clientesPDF.size());
        }

        ArrayList<Cliente> clientes = new ArrayList<>();
        
        for( Cliente c: clientes ){
            for( ClientePDF pdf: clientesPDF ){
               if( pdf.getCnpj().replace(".", "").replace("/", "").replace("-", "") == c.getCnpjCpf() ){
                   c.setTipo( pdf.getTipo() );
                   c.setLojaRisco( pdf.getLojaRisco() );
                   c.setCodigo( pdf.getCodigo() );
               } 
            }
        }
    
        ConsumoAPI api = new ConsumoAPI();

       // for (int i = 0; i < cnpjClientes.length; i++) {
      //   //   Cliente c = api.getClienteByCNPJ( cnpjClientes[i] );
         //   System.out.println(cnpjClientes.length);
          //  clientes.add(c);
      //  }

        //for(Cliente c: clientes){
            
        //    System.out.printf("\n");
       // }
        for (int i = 0; i < cnpjClientes.length; i++) {
            try{
                Cliente c = api.getClienteByCNPJ( cnpjClientes[i] );
                clientes.add(c);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        
        matchNomeFantasia(clientes, clientesPlanilha);
    }
    
    
    public static List<Cliente> matchNomeFantasia(List<Cliente> clientesAPI, List<ClientePlanilha> clientesPlanilha){
        
        int count = 0;
        for(Cliente api : clientesAPI){
            for(ClientePlanilha planilha: clientesPlanilha){
                if(api.getRazaoSocial().contains(planilha.getNomeFantasia()) || planilha.getNomeFantasia().contains(api.getRazaoSocial())){
                    System.out.println("Retornado pela API: "+api.getRazaoSocial()+" e Retirado da planilha: "+planilha.getNomeFantasia());
                    if(api.getNomeFantasia() == null || api.getNomeFantasia().length() == 0){
                        api.setNomeFantasia(planilha.getNomeFantasia());
                    }
                    api.setContato(planilha.getContato());
                    api.setTelefone(planilha.getTelefones());
                    count++;
                }
            }
        }
        
        return clientesAPI;
    }
}
