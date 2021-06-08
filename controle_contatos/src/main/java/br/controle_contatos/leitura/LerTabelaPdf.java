package br.controle_contatos.leitura;

import br.controle_contatos.models.ClientePDF;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class LerTabelaPdf {

    public LerTabelaPdf() {
    }

    public ArrayList<ClientePDF> lerDados(String path) throws IOException {

        ArrayList<ClientePDF> clientes = new ArrayList<>();
        File file = new File(path);

        try (PDDocument document = PDDocument.load(file)) {

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                String lines[] = pdfFileInText.split("\\r?\\n");

                for (String line : lines) {
                    // System.out.println(line);            
                    if (line.contains("Tipo")) {
                    } else {
                        //System.out.println(line);
                        ClientePDF cliente = new ClientePDF();
                        if (line.contains("Revendedor")) {
                            String[] split = line.split("Revendedor ");
                            //System.out.println(split[0]);
                            cliente.setNome(split[0]);
                            cliente.setTipo("Revendedor");
                            String[] separaCodigoCnpj = split[1].split(" ");
                            //System.out.println(separaCodigoCnpj[0]);
                            cliente.setCnpj(separaCodigoCnpj[0]);
                            String lojaRisco = separaCodigoCnpj[1].substring(separaCodigoCnpj[1].length() - 1);
                            //System.out.println(lojaRisco);
                            cliente.setLojaRisco(lojaRisco);
                            //System.out.println(separaCodigoCnpj[1]);
                            cliente.setCodigo(separaCodigoCnpj[1]);
                        } else if (line.contains("Solidario")) {
                            String[] split = line.split("Solidario ");
                            cliente.setNome(split[0]);
                            cliente.setTipo("Solidario");
                            String[] separaCodigoCnpj = split[1].split(" ");
                            cliente.setCnpj(separaCodigoCnpj[0]);
                            String lojaRisco = separaCodigoCnpj[1].substring(separaCodigoCnpj[1].length() - 1);
                            cliente.setLojaRisco(lojaRisco);
                            cliente.setCodigo(separaCodigoCnpj[1]);
                        } else {
                            String[] split = line.split("Produtor Rural ");
                            cliente.setNome(split[0]);
                            cliente.setTipo("Produtor Rural");
                            String[] separaCodigoCnpj = split[1].split(" ");
                            cliente.setCnpj(separaCodigoCnpj[0]);
                            String lojaRisco = separaCodigoCnpj[1].substring(separaCodigoCnpj[1].length() - 1);
                            cliente.setLojaRisco(lojaRisco);
                            cliente.setCodigo(separaCodigoCnpj[1]);
                        }
                        clientes.add(cliente);
                    }

                }

            }

        }
        //int x = 0;
        //for (ClientePDF c : clientes) {
            //System.out.println("Dados: " + x);
            //System.out.println("Nome: " + c.getNome());
            //System.out.println("Tipo: " + c.getTipo());
            //System.out.println("CNPJ/CPF: " + c.getCnpj());
            //System.out.println("Cdigo: " + c.getCodigo());
            //System.out.println("Loja Risco: " + c.getLojaRisco());
            //System.out.println("\n \n");
            //x++;

       // }
        return clientes;
    }
}
