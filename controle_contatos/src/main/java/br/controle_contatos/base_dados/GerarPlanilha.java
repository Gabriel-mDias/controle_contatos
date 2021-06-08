/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.base_dados;

import br.controle_contatos.models.Cliente;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Código, razão social, telefone de contato (do Excel), nome do cliente
 *
 * @author NOTE_190
 */
public class GerarPlanilha {

    private static final String fileName = "C:\\Users\\NOTE_190\\OneDrive\\Documentos\\xlsx\\planilhaMarcelin\\teste.xlsx";

    public void gerarPlanilha(ArrayList<Cliente> clientes, String[] municipios) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetClientes = workbook.createSheet("Clientes");

        int rownum = 0;
        for (int i = 0; i < municipios.length; i++) {

            Row rowMunicipio = sheetClientes.createRow(rownum++);

            int cellnum = 0;
            Cell cellMunicipio = rowMunicipio.createCell(cellnum++);
            cellMunicipio.setCellValue(municipios[i]);

            Row rowCabeçalho = sheetClientes.createRow(rownum++);

            Cell cellCodigo = rowCabeçalho.createCell(cellnum++);
            cellCodigo.setCellValue("CÓDIGO");

            Cell cellRazaoSocial = rowCabeçalho.createCell(cellnum++);
            cellRazaoSocial.setCellValue("RAZÃO SOCIAL");

            Cell cellTelefone = rowCabeçalho.createCell(cellnum++);
            cellTelefone.setCellValue("TELEFONE");

            Cell cellContato = rowCabeçalho.createCell(cellnum++);
            cellContato.setCellValue("CONTATO");

            for (Cliente c : clientes) {

                if (c.getEndereco().getMunicipio().equals(municipios[i])) {

                    Row rowDados = sheetClientes.createRow(rownum++);
                    cellnum = 0;

                    Cell cellCod = rowDados.createCell(cellnum++);
                    cellCod.setCellValue(c.getCodigo());

                    Cell cellRazSocial = rowDados.createCell(cellnum++);
                    cellRazSocial.setCellValue(c.getRazaoSocial());

                    Cell cellTel = rowDados.createCell(cellnum++);
                    cellCod.setCellValue(c.getTelefone());

                    Cell cellCont = rowDados.createCell(cellnum++);
                    cellCont.setCellValue(c.getContato());
                }//if
            }//for clientes
        }//for municipios

        try {
            FileOutputStream out = new FileOutputStream(new File(GerarPlanilha.fileName));
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na edição do arquivo!");
        }

    }

}
