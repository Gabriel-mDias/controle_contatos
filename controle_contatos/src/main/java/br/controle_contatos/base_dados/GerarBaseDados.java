package br.controle_contatos.base_dados;

import br.controle_contatos.business.ClienteBusiness;
import br.controle_contatos.leitura.LerTabelaPdf;
import br.controle_contatos.leitura.LerTabelaPlanilha;
import br.controle_contatos.models.Cliente;
import br.controle_contatos.models.ClientePDF;
import br.controle_contatos.models.ClientePlanilha;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang3.StringUtils;

public class GerarBaseDados {

    private static ClienteBusiness clienteBusiness = new ClienteBusiness();

    public static void main(String[] args) throws IOException, DecoderException {

        LerTabelaPdf lerPDF = new LerTabelaPdf();
        ArrayList<ClientePDF> clientesPDF = lerPDF.lerDados("/home/gabriel/Downloads/Clientes Sergio[565] (1).pdf");           //biel
        //ArrayList<ClientePDF> clientesPDF = lerPDF.lerDados("C:\\Users\\NOTE_190\\Downloads\\Clientes Sergio[565] (1).pdf");     //said

        LerTabelaPlanilha lerPDFPlanilha = new LerTabelaPlanilha();
        ArrayList<ClientePlanilha> clientesPlanilha = lerPDFPlanilha.lerDados("/home/gabriel/Downloads/PROJETO DE ATUALIZAÇÃO[566] (3).pdf");         //biel
        //ArrayList<ClientePlanilha> clientesPlanilha = lerPDFPlanilha.lerDados("C:\\Users\\NOTE_190\\Downloads\\PROJETO DE ATUALIZAÇÃO[566] (3).pdf");   //said    

        String[] cnpjClientes = new String[clientesPDF.size()];
        for (int i = 0; i < cnpjClientes.length; i++) {
            cnpjClientes[i] = clientesPDF.get(i).getCnpj();
            cnpjClientes[i] = cnpjClientes[i].replace(".", "").replace("/", "").replace("-", "");
        }

        ArrayList<Cliente> clientes = new ArrayList<>();

        ConsumoAPI api = new ConsumoAPI();

        for (int i = 0; i < cnpjClientes.length; i++) {
            try {
                Cliente c = api.getClienteByCNPJ(cnpjClientes[i]);
                clientes.add(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ArrayList<String> municipios = new ArrayList<>();

        for (Cliente c : clientes) {
            municipios.add(c.getEndereco().getMunicipio());
            for (ClientePDF pdf : clientesPDF) {
                if (pdf.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals(c.getCnpjCpf())) {
                    c.setTipo(pdf.getTipo());
                    c.setLojaRisco(StringUtils.chop(pdf.getLojaRisco(pdf.getCodigo())));
                    String aux = StringUtils.chop(pdf.getCodigo());
                    c.setCodigo((StringUtils.chop(aux)).replace(".", ""));
                }
            }
        }

        matchNomeFantasia(clientes, clientesPlanilha);

        GerarPlanilha gerarPlanilha = new GerarPlanilha();

        Set set = new HashSet<>(municipios);
        municipios.clear();
        municipios.addAll(set);

        gerarPlanilha.gerarPlanilha(clientes, municipios);
    }

    public static void matchNomeFantasia(List<Cliente> clientesAPI, List<ClientePlanilha> clientesPlanilha) {
        try {
            int count = 0;
            for (Cliente api : clientesAPI) {
                for (ClientePlanilha planilha : clientesPlanilha) {
                    if (api.getRazaoSocial().contains(planilha.getNomeFantasia()) || planilha.getNomeFantasia().contains(api.getRazaoSocial())) {
                        if (api.getNomeFantasia() == null || api.getNomeFantasia().length() == 0) {
                            api.setNomeFantasia(planilha.getNomeFantasia());
                        }
                        if (planilha.getTelefones() != null) {
                            String str1 = planilha.getTelefones().trim().replace(" ", "X");
                            String[] split = str1.split("XX");
                            String aux = split[1].replace("X", " ");
                            api.setTelefone(split[0]);
                            api.setContato(aux);
                        }
                        count++;
                    }
                }

                clienteBusiness.insert(api);
            }

        } catch (Exception ex) {
            Logger.getLogger(GerarBaseDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
