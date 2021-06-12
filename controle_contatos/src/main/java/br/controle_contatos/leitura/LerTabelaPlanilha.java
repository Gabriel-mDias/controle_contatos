package br.controle_contatos.leitura;

import br.controle_contatos.models.ClientePlanilha;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class LerTabelaPlanilha {

    public LerTabelaPlanilha() {
    }

    public ArrayList<ClientePlanilha> lerDados(String path) throws IOException {
        ArrayList<ClientePlanilha> clientes = new ArrayList<>();
        File file = new File(path);

        try (PDDocument document = PDDocument.load(file)) {

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                String lines[] = pdfFileInText.split("\\r?\\n");

                for (String line : lines) {
                    ClientePlanilha cliente = new ClientePlanilha();
                    String[] dados = new String[6];
                    if (line.contains("(33)") || line.contains("(28)") || line.contains("(22)") || line.contains("(27)") || line.contains("TELEFONE") || line.length() < 4) {

                    } else {
                        String preProcessada = line.replaceAll(" ([0-9])", ";$1").replaceAll("([0-9]) ([A-Z]|[a-z])", "$1;$2").replaceAll("(#)([A-Z]|[a-z])", "$1;$2");
                        String[] split = preProcessada.split(";");

                        for (int i = 0; i < split.length; i++) {
                            dados[i] = split[i];
                        }

                        cliente.setNomeFantasia(dados[1]);

                        cliente.setTelefones(dados[2]);
                        cliente.setContato(dados[3]);

                        clientes.add(cliente);
                    }

                }

            }

        }
        return clientes;
    }

}
